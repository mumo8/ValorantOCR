package valorant;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
import org.opencv.core.Scalar;
import net.sourceforge.tess4j.*;
import java.io.File;
public class GrabData {
	
	int thresholdMin = 0;
	int thresholdMax = 0;
	String ocrDictionary ="";
	String inputPicture = "";
	String outputPicture = "";
	String characterName = "";	  
	   
	   public void imageProcess()
	   {		   
		   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		   String input = "C:\\Users\\wilki\\Desktop\\Valorant2.jpg";
		   Mat source = Imgcodecs.imread(input);
		   Mat destination = new Mat();
		   Size largen = new Size(source.width()*4,source.height()*4);
		   Imgproc.resize(source, source, largen);
		   Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
		   Imgproc.threshold(destination, destination, 180, 255,1);
		   Imgproc.equalizeHist(destination, destination);
		   
		   //Mat invertcolormatrix = new Mat(destination.rows(),destination.cols(), destination.type(), new Scalar(255,255,255));
		   //Core.subtract(invertcolormatrix, destination, destination);
		   
		   Imgcodecs.imwrite("C:\\Users\\wilki\\Desktop\\new.jpg", destination);
		   System.out.println("The image is successfully converted to Grayscale");
		   
	   }
	   
	   public void processData()
	   {
		   Tesseract tesseract = new Tesseract(); 
	        try { 
	  
	            tesseract.setDatapath("E:\\Packages\\Tess4J\\tessdata");
	            tesseract.setOcrEngineMode(3);
	            tesseract.setLanguage("eng");
	            tesseract.setPageSegMode(6);
	            tesseract.setTessVariable("tessedit_char_whitelist", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890");
	            // the path of your tess data folder 
	            // inside the extracted file 
	            String text 
	                = tesseract.doOCR(new File("C:\\Users\\wilki\\Desktop\\new.jpg")); 
	            	
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
}
