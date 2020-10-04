package valorant;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.MatOfByte;
//import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
//import org.opencv.core.Scalar;
import net.sourceforge.tess4j.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.AWTException;
//import java.io.InputStream;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.DataBufferByte;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.time.LocalTime; 

public class GrabData {
	
	int thresholdMin = 180;
	int thresholdMax = 255;
	String ocrDictionary ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890:-";
	String inputPicture = "";
	String outputPicture = "";
	String characterName = "NotTurntEnough";
	String excelLocation = "C:\\Users\\wilki\\Desktop\\VData.xlsx";
	String imgName = "new.jpg";
	int[] crop = new int[4];
	String[] characters = {"Phoenix", "Raze", "Reyna", "Breach", "Sage","Sova", "Viper", "Brimstone", "Cypher", "Killjoy", "Jett", "Omen"};
	//Mat currentMat = new Mat();
	   
	
		public static void main( String[] args ) throws IOException, Exception
	   {
	      
		  GrabData system = new GrabData();
	      system.click(835, 195);
	      TimeUnit.MILLISECONDS.sleep(300);
	      system.setCrop(331, 309, 1210, 557);
	      system.setImgName("scoreboard.jpg");
	      String scoreboardData = system.processData(system.imageProcess());
	     
	      
	      system.setCrop(1695, 184, 114, 70);
	      system.setThresholdMin(115);
	      system.setImgName("mapData.jpg");
	      String mapData = system.processData(system.imageProcess());
	      
	      

	      system.setOcrDictionary("1234567890");
	      
	      //Getting the rounds won of the ally team
	      system.setCrop(722, 94, 75, 60);
	      system.setThresholdMin(115);
	      system.setImgName("allyScore.jpg");
	      String allyScore = system.processData(system.imageProcess());
	      
	      //Getting the score of the enemy team
	      system.setCrop(1080, 104, 70, 50);
	      system.setThresholdMin(106);
	      system.setImgName("enemyScore.jpg");
	      String enemyScore = system.processData(system.imageProcess());
	      
	      //Capturing if the game was a win or loss
	      system.setOcrDictionary("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	      system.setCrop(810, 97, 240, 60);
	      system.setThresholdMin(150);
	      system.setImgName("result.jpg");
	      String result = system.processData(system.imageProcess());
	      
	      //Team Player Name Capture
	      system.click(1028, 190);
	      system.setOcrDictionary("ABCEGHIJKLMNIPRSTVXYZabceghijklmnoprstvxyz");
	      TimeUnit.MILLISECONDS.sleep(1000);
	      system.setCrop(250, 500, 160, 217);
	      system.setThresholdMin(179);
	      system.setImgName("teamChar.jpg");
	      String teamPlayers = system.processData(system.imageProcess());
	      
	      //Enemy Player Name Capture
	      system.click(1216, 190);
	      TimeUnit.MILLISECONDS.sleep(1000);
	      system.setCrop(990, 345, 330, 345);
	      system.setThresholdMin(130);
	      system.setImgName("enemyChar.jpg");
	      String enemyPlayers = system.processData(system.imageProcess());
	      
	      system.setOcrDictionary("ATKDEFatkdef");
	      system.click(645, 193);
	      TimeUnit.MILLISECONDS.sleep(1000);
	      system.setCrop(1380, 347, 50, 23);
	      system.setThresholdMin(115);
	      system.setImgName("side.jpg");
	      String startSide = system.processData(system.imageProcess());
	      
	      system.setOcrDictionary("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
	      system.setCrop(151, 915, 100, 33);
	      system.setThresholdMin(175);
	      system.setImgName("currentPlayer.jpg");
	      String currentPlayer = system.processData(system.imageProcess());
	      
	      system.setOcrDictionary("1234567890");
	      system.setCrop(1345, 406, 270, 38);
	      system.setThresholdMin(175);
	      system.setImgName("roundWins.jpg");
	      String roundWins = system.processData(system.imageProcess());
	      
	      
	      system.processScoreBoard(scoreboardData,mapData, allyScore, enemyScore, result, teamPlayers, enemyPlayers, startSide, currentPlayer, roundWins);
	      
	   }
	
	   public Mat imageProcess() throws Exception
	   {		   
		   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		   Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		   BufferedImage capture = new Robot().createScreenCapture(screenRect);
		   
		   capture = capture.getSubimage(crop[0], crop[1], crop[2], crop[3]);
		   
		   //Convert BufferedImage to Mat for Processing with OPENCV
		   ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		   ImageIO.write(capture, "png", byteArrayOutputStream);
		   byteArrayOutputStream.flush();
		   Mat source = Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_ANYCOLOR);    		
		  
		   
		   Mat destination = new Mat();
		   Size largen = new Size(source.width()*4,source.height()*4);
		   Imgproc.resize(source, source, largen);
		   Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
		   Imgproc.threshold(destination, destination, thresholdMin, thresholdMax,1);
		   //Imgproc.equalizeHist(destination, destination);
		   
		   //Mat invertcolormatrix = new Mat(destination.rows(),destination.cols(), destination.type(), new Scalar(255,255,255));
		   //Core.subtract(invertcolormatrix, destination, destination);
		   
		   Imgcodecs.imwrite("C:\\Users\\wilki\\Desktop\\vphoto\\"+ imgName, destination);
		   //System.out.println("The image is successfully converted to Grayscale");
		   return(destination);
	   }
	   
	   public String processData(Mat currentMat) throws IOException
	   {
		   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		   
		   //Convert Mat to BufferedImage for compatibility with Tesseract
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
	            String text 
	                = tesseract.doOCR(ocrData);	
	            
	            	
	            // path of your image file 
	            System.out.print(text); 
	            return(text);
	        } 
	        catch (TesseractException e) { 
	            e.printStackTrace();
	            return("fail");
	        } 
	        
	   }
	   
	   public void processScoreBoard(String scoreBoard, String mapInfo, String ally, String enemy, String theResult, String teamChar, String enemyChar, String side,String player, String wins) throws FileNotFoundException, IOException
	   {
		   String yourScore = "";
		   String theMap = "";
		   String[] splitScore = new String[9];
		   int index = scoreBoard.indexOf(characterName);
		   yourScore = scoreBoard.substring(index + characterName.length(),index + characterName.length() + 19);
		   yourScore = yourScore.trim();
		   System.out.println(yourScore);
		   splitScore = yourScore.split(" ");
		   String splitMapInfo[] = mapInfo.split("\n");
		   
		   FileInputStream dataStorage = new FileInputStream(excelLocation);
		   
		   XSSFWorkbook gameData = new XSSFWorkbook(dataStorage);
		   XSSFSheet workSheet = gameData.getSheetAt(0);
		   int lastRow = workSheet.getLastRowNum();
		   Row row = workSheet.createRow(++lastRow); 
		   
		   ally = ally.trim();
		   enemy = enemy.trim();
		   
		   int teamCellNum = 18;
		   int enemCellNum = 22;
		   for(int i = 0; i < 12; i++)
		   {
			  
			   if(teamCellNum == 22)
			   {
				   
			   }else if(teamChar.contains(characters[i])) 
			   {				   				   
					   row.createCell(teamCellNum).setCellValue(characters[i]);
					   teamCellNum++;
			   }
			   
			   if(enemCellNum ==  28)
			   {
				   
			   }
			   else  if(enemyChar.contains(characters[i])) 
			   {
				   	   row.createCell(enemCellNum).setCellValue(characters[i]);
					   enemCellNum++;
				   
			   }
			   
		   }
				   
		   side = side.toLowerCase();
		   
		   if (side.contains("a")||side.contains("t")||side.contains("k"))
		   {
			   row.createCell(3).setCellValue("Attack");
			   System.out.println("Wins: " + wins.substring(wins.indexOf(" ")));
			   row.createCell(4).setCellValue(Integer.parseInt(wins.substring(0, wins.indexOf(" ")).trim()));
			   row.createCell(5).setCellValue(Integer.parseInt(wins.substring(wins.indexOf(" ")).trim()));
		   }
		   else if (side.contains("d")||side.contains("e")||side.contains("f"))
		   {
			   row.createCell(3).setCellValue("Defend");
			   row.createCell(5).setCellValue(Integer.parseInt(wins.substring(0, wins.indexOf(" ")).trim()));
			   row.createCell(4).setCellValue(Integer.parseInt(wins.substring(wins.indexOf(" ")).trim()));
		   }
		   else
		   {
			   row.createCell(3).setCellValue("Read Error");
			   row.createCell(4).setCellValue("Read Error");
			   row.createCell(5).setCellValue("Read Error");
		   }
		   
		   
		   
		   
		   String time = "" + LocalTime.now();
		   time = time.substring(0,5);
		   
		   int space = splitMapInfo[2].indexOf("-") + 1;
		   splitMapInfo[2] = splitMapInfo[2].substring(space);
		   
		   //set excel values here
		   row.createCell(0).setCellValue(theResult.substring(0,1).toUpperCase() + theResult.substring(1).toLowerCase());
		   row.createCell(1).setCellValue(Integer.parseInt(ally.trim()));
		   row.createCell(2).setCellValue(Integer.parseInt(enemy.trim()));
		   row.createCell(6).setCellValue(splitMapInfo[2].substring(0,1) + splitMapInfo[2].substring(1).toLowerCase());
		   row.createCell(9).setCellValue("" + java.time.LocalDate.now());
		   row.createCell(10).setCellValue(time);
		   row.createCell(11).setCellValue(splitMapInfo[3]);
		   row.createCell(12).setCellValue(Integer.parseInt(splitScore[0]));
		   row.createCell(13).setCellValue(Integer.parseInt(splitScore[4]));
		   row.createCell(14).setCellValue(Integer.parseInt(splitScore[1]));
		   row.createCell(15).setCellValue(Integer.parseInt(splitScore[2]));
		   row.createCell(16).setCellValue(Integer.parseInt(splitScore[3]));
		   row.createCell(17).setCellValue(player.substring(0,1).toUpperCase() + player.substring(1).toLowerCase());
		   
		   //close file
		   dataStorage.close();
		   
		   FileOutputStream outputFile = new FileOutputStream(new File(excelLocation));
		   gameData.write(outputFile);
		   outputFile.close();
		   gameData.close(); 	   
		   
	   }
	   
	   public void click(int x, int y) throws AWTException{
		    Robot bot = new Robot();
		    bot.mouseMove(x, y);    
		    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	   
	   public int getThresholdMin()
	   {
		   return(thresholdMin);
	   }
	   
	   public void setThresholdMin (int aThresholdMin)
	   {
		   thresholdMin = aThresholdMin;
	   }
	   
	   public void setThresholdMax (int aThresholdMax)
	   {
		   thresholdMax = aThresholdMax;
	   }
	   
	   public String getOcrDictionary()
	   {
		   return(ocrDictionary);
	   }
	   
	   public void setOcrDictionary (String aDictionary)
	   {
		   ocrDictionary = aDictionary;
	   }
	   public void setCrop (int xCrop, int yCrop, int xSize, int ySize)
	   {
		   crop[0] = xCrop;
		   crop[1] = yCrop;
		   crop[2] = xSize;
		   crop[3] = ySize;
		   
	   }
	   public void setImgName (String aName)
	   {
		   imgName = aName;
	   }
}

