package valorant;

import org.opencv.core.Core;
import org.opencv.core.MatOfByte;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
import net.sourceforge.tess4j.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalTime;

public class GrabData {

	int thresholdMin = 180;
	int thresholdMax = 255;
	String ocrDictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890:-";
	String inputPicture = "";
	String outputPicture = "";
	String characterName = "NotTurntEnough";
	String excelLocation = "C:\\Users\\wilki\\Desktop\\VData.xlsx";
	String imgName = "new.jpg";
	int[] crop = new int[4];
	String[] characters = { "Phoenix", "Raze", "Reyna", "Breach", "Sage", "Sova", "Viper", "Brimstone", "Cypher",
			"Killjoy", "Jett", "Omen" };
	// String[] preProcessedData = new String[10];
	String[] processedData = new String[27];
	// Mat currentMat = new Mat();
	boolean doCrop = true;

	public Mat imageProcess() throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);

		if (doCrop)
		{
			capture = capture.getSubimage(crop[0], crop[1], crop[2], crop[3]);
		}
		

		// Convert BufferedImage to Mat for Processing with OPENCV
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(capture, "png", byteArrayOutputStream);
		byteArrayOutputStream.flush();
		Mat source = Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_ANYCOLOR);

		Mat destination = new Mat();
		Size largen = new Size(source.width() * 4, source.height() * 4);
		Imgproc.resize(source, source, largen);
		Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
		Imgproc.threshold(destination, destination, thresholdMin, thresholdMax, 1);
		// Imgproc.equalizeHist(destination, destination);

		// Mat invertcolormatrix = new Mat(destination.rows(),destination.cols(),
		// destination.type(), new Scalar(255,255,255));
		// Core.subtract(invertcolormatrix, destination, destination);

		Imgcodecs.imwrite("C:\\Users\\wilki\\Desktop\\vphoto\\" + imgName, destination);
		// System.out.println("The image is successfully converted to Grayscale");
		return (destination);
	}
	
	

	public String performOcr(Mat currentMat) throws IOException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Convert Mat to BufferedImage for compatibility with Tesseract
		MatOfByte dataIn = new MatOfByte();
		Imgcodecs.imencode(".png", currentMat, dataIn);
		BufferedImage ocrData = ImageIO.read(new ByteArrayInputStream(dataIn.toArray()));

		Tesseract tesseract = new Tesseract();
		try {

			tesseract.setDatapath("E:\\Packages\\Tess4J\\tessdata");
			tesseract.setOcrEngineMode(3);
			tesseract.setLanguage("eng");
			tesseract.setPageSegMode(6);
			tesseract.setTessVariable("tessedit_char_whitelist", ocrDictionary);
			// the path of your tess data folder
			// inside the extracted file
			String text = tesseract.doOCR(ocrData);

			// path of your image file
			System.out.print(text);
			return (text);
		} catch (TesseractException e) {
			e.printStackTrace();
			return ("fail");
		}

	}

	public String[] separateData(String[] dataSets) {
		String yourScore = "";
		String[] splitScore = new String[9];
		int index = dataSets[0].indexOf(characterName); // Finding index of your character name in k/d/a score board
		yourScore = dataSets[0].substring(index + characterName.length(), index + characterName.length() + 19);
		yourScore = yourScore.trim();
		splitScore = yourScore.split(" ");
		String splitMapInfo[] = dataSets[1].split("\n");

		dataSets[2] = dataSets[2].trim(); // ally Rounds Won
		dataSets[3] = dataSets[3].trim(); // Enemy Rounds Won

		int teamCellNum = 18;
		int enemCellNum = 22;
		for (int i = 0; i < 12; i++) {

			if (teamCellNum == 22) {

			} else if (dataSets[5].contains(characters[i])) // Ally character list
			{
				processedData[teamCellNum] = characters[i];
				teamCellNum++;
			} else {
				processedData[teamCellNum] = "error";
			}

			if (enemCellNum == 28) {

			} else if (dataSets[6].contains(characters[i])) // Enemy character list
			{
				processedData[enemCellNum] = characters[i];
				enemCellNum++;

			} else {
				processedData[enemCellNum] = "error";
			}

		}

		dataSets[7] = dataSets[7].toLowerCase();

		if (dataSets[7].contains("a") || dataSets[7].contains("t") || dataSets[7].contains("k")) {
			processedData[3] = "Attack";
			processedData[4] = dataSets[9].substring(0, dataSets[9].indexOf(" ")).trim();
			processedData[5] = dataSets[9].substring(dataSets[9].indexOf(" ")).trim();
		} else if (dataSets[7].contains("d") || dataSets[7].contains("e") || dataSets[7].contains("f")) {
			processedData[3] = "Defend";
			processedData[5] = dataSets[9].substring(0, dataSets[9].indexOf(" ")).trim();
			processedData[4] = dataSets[9].substring(dataSets[9].indexOf(" ")).trim();
		} else {
			processedData[3] = "Read Error";
			processedData[5] = "Read Error";
			processedData[4] = "Read Error";
		}

		int space = splitMapInfo[2].indexOf("-") + 1;
		splitMapInfo[2] = splitMapInfo[2].substring(space);

		// set excel values here
		processedData[0] = dataSets[4].substring(0, 1).toUpperCase() + dataSets[4].substring(1).toLowerCase();
		processedData[1] = dataSets[2];
		processedData[2] = dataSets[3];
		processedData[6] = splitMapInfo[2].substring(0, 1) + splitMapInfo[2].substring(1).toLowerCase();
		processedData[9] = "" + java.time.LocalDate.now();
		processedData[10] = LocalTime.now().toString().substring(0, 5);
		processedData[10] = splitMapInfo[3];
		processedData[12] = splitScore[0];
		processedData[13] = splitScore[4];
		processedData[14] = splitScore[1];
		processedData[15] = splitScore[2];
		processedData[16] = splitScore[3];
		processedData[17] = dataSets[8].substring(0, 1).toUpperCase() + dataSets[8].substring(1).toLowerCase();

		return (processedData);
	}
	
	public void writeToExcel(String[] excelData)
	{
		try 
		{
			FileInputStream dataStorage = new FileInputStream(excelLocation);

			XSSFWorkbook gameData = new XSSFWorkbook(dataStorage);
			XSSFSheet workSheet = gameData.getSheetAt(0);
			int lastRow = workSheet.getLastRowNum();
			Row row = workSheet.createRow(++lastRow);
			
			row.createCell(0).setCellValue(excelData[0]);
			row.createCell(1).setCellValue(Integer.parseInt(excelData[1]));
			row.createCell(2).setCellValue(Integer.parseInt(excelData[2]));
			row.createCell(3).setCellValue(excelData[3]);
			row.createCell(4).setCellValue(excelData[4]);
			row.createCell(5).setCellValue(excelData[5]);
			row.createCell(6).setCellValue(excelData[6]);
			row.createCell(7).setCellValue(excelData[7]);
			row.createCell(8).setCellValue(excelData[8]);
			row.createCell(9).setCellValue(excelData[9]);
			row.createCell(10).setCellValue(excelData[10]);
			row.createCell(11).setCellValue(excelData[11]);
			row.createCell(12).setCellValue(Integer.parseInt(excelData[12]));
			row.createCell(13).setCellValue(Integer.parseInt(excelData[13]));
			row.createCell(14).setCellValue(Integer.parseInt(excelData[14]));
			row.createCell(15).setCellValue(Integer.parseInt(excelData[15]));
			row.createCell(16).setCellValue(Integer.parseInt(excelData[16]));
			row.createCell(17).setCellValue(excelData[17]);
			row.createCell(18).setCellValue(excelData[18]);
			row.createCell(19).setCellValue(excelData[19]);
			row.createCell(20).setCellValue(excelData[20]);
			row.createCell(21).setCellValue(excelData[21]);
			row.createCell(22).setCellValue(excelData[22]);
			row.createCell(23).setCellValue(excelData[23]);
			row.createCell(24).setCellValue(excelData[24]);
			row.createCell(25).setCellValue(excelData[25]);
			row.createCell(26).setCellValue(excelData[26]);
			gameData.close();
			dataStorage.close();
		}
		catch (FileNotFoundException fileLost)
		{
			System.out.println("Error. Could not locate excel file!");
		}
		catch (IOException d)
		{
			System.out.println("Error. File IO Exception!");
		}
		
		
		
	}

	public void click(int x, int y) throws AWTException {
		Robot bot = new Robot();
		bot.mouseMove(x, y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public int getThresholdMin() {
		return (thresholdMin);
	}

	public void setThresholdMin(int aThresholdMin) {
		thresholdMin = aThresholdMin;
	}

	public void setThresholdMax(int aThresholdMax) {
		thresholdMax = aThresholdMax;
	}

	public String getOcrDictionary() {
		return (ocrDictionary);
	}

	public void setOcrDictionary(String aDictionary) {
		ocrDictionary = aDictionary;
	}

	public void setCrop(int xCrop, int yCrop, int xSize, int ySize) {
		crop[0] = xCrop;
		crop[1] = yCrop;
		crop[2] = xSize;
		crop[3] = ySize;

	}

	public void setImgName(String aName) {
		imgName = aName;
	}

	public void setExcelLocation(String aLocation) {
		excelLocation = aLocation;

	}
	
	public void setCrop(boolean theCrop)
	{
		
		doCrop = theCrop;
	}
}
