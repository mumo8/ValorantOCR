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
//import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
//import java.io.InputStream;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.DataBufferByte;

public class GrabData {
	
	int thresholdMin = 180;
	int thresholdMax = 255;
	String ocrDictionary ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	String inputPicture = "";
	String outputPicture = "";
	String characterName = "";
	//Mat currentMat = new Mat();
	   
	
		public static void main( String[] args ) throws IOException, Exception
	   {
	      GrabData system = new GrabData();
	      
	      system.processData(system.imageProcess());
	   }
	
	   public Mat imageProcess() throws Exception
	   {		   
		   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		   Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		   BufferedImage capture = new Robot().createScreenCapture(screenRect);
		   
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
		   Imgproc.equalizeHist(destination, destination);
		   
		   //Mat invertcolormatrix = new Mat(destination.rows(),destination.cols(), destination.type(), new Scalar(255,255,255));
		   //Core.subtract(invertcolormatrix, destination, destination);
		   
		   Imgcodecs.imwrite("C:\\Users\\wilki\\Desktop\\new.jpg", destination);
		   //System.out.println("The image is successfully converted to Grayscale");
		   return(destination);
	   }
	   
	   public void processData(Mat currentMat) throws IOException
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
	        } 
	        catch (TesseractException e) { 
	            e.printStackTrace(); 
	        } 
		   
	   }
	   
	   public int getThresholdMin()
	   {
		   return(thresholdMin);
	   }
	   
	   public void setThresholdMin (int aThresholdMin)
	   {
		   thresholdMin = aThresholdMin;
	   }
	   
	   public String getOcrDictionary()
	   {
		   return(ocrDictionary);
	   }
	   
	   public void setOcrDictionary (String aDictionary)
	   {
		   ocrDictionary = aDictionary;
	   }
}

