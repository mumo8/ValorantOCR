package valorant;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

import org.opencv.core.Mat;

public class Controller
{	
	String[] inputData = new String[10];
	String[] organizedData = new String[27];
	String[][] tenEightyFullCrop = {{},{},{},{},{},{},{},{},{},{}};
	String[][] tenEightyWindowedCrop = {};
	
	
	
	public void mainProgram()
	{
		try 
		{
			GrabData system = new GrabData();	
			system.setCrop(false);
			system.setOcrDictionary("progesinPROGESIN");
			Mat size = system.imageProcess();
			int height = size.height()/4;
			//Sets the crop values and the click values
			String tabSetup = system.performOcr(size);
			System.out.println(size);
			boolean tab = tabSetup.toLowerCase().contains("progression");
			switch(height)
			{
			case 1080:
				if(tab) {}
				else {}
				break;
			case 1440:
				if(tab) {}
				else {}
				break;
			case 2160:
				if(tab) {}
				else {}
				break;
			default:
				break;
			}
			
			
		    system.click(645, 193); //Summary Tab
		    TimeUnit.MILLISECONDS.sleep(1000);
		    
		    
		  //Finding what the starting side is
		    system.setCrop(true);
		    system.setOcrDictionary("ATKDEFatkdef");
		    system.setCrop(1380, 347, 50, 23);
		    system.setThresholdMin(115);
		    system.setImgName("side.jpg");
		    inputData[7] = system.performOcr(system.imageProcess());
		    
		    //Figuring out the name of the person playing.
		    system.setOcrDictionary("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		    system.setCrop(151, 915, 100, 33);
		    system.setThresholdMin(175);
		    system.setImgName("currentPlayer.jpg");
		    inputData[8] = system.performOcr(system.imageProcess());
		    
		    //Getting the number of rounds won on attack and defense by the ally team
		    system.setOcrDictionary("1234567890");
		    system.setCrop(1345, 406, 270, 38);
		    system.setThresholdMin(175);
		    system.setImgName("roundWins.jpg");
		    inputData[9] = system.performOcr(system.imageProcess());
		    
			
		 	system.click(835, 195); //Scoreboard Tab
		    TimeUnit.MILLISECONDS.sleep(300);
		    system.setCrop(331, 309, 1210, 557);
		    system.setImgName("scoreboard.jpg");
		    inputData[0] = system.performOcr(system.imageProcess()); //score board
		   
		    
		    system.setCrop(1695, 184, 114, 70);
		    system.setThresholdMin(115);
		    system.setImgName("mapData.jpg");
		    inputData[1] = system.performOcr(system.imageProcess());    
		    

		    system.setOcrDictionary("1234567890");
		    
		    //Getting the rounds won of the ally team
		    system.setCrop(722, 94, 75, 60);
		    system.setImgName("allyScore.jpg");
		    inputData[2] = system.performOcr(system.imageProcess()); //ally score
		    
		    //Getting the score of the enemy team
		    system.setCrop(1080, 104, 70, 50);
		    system.setThresholdMin(106);
		    system.setImgName("enemyScore.jpg");
		    inputData[3] = system.performOcr(system.imageProcess()); //enemy score
		    
		    //Capturing if the game was a win or loss
		    system.setOcrDictionary("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		    system.setCrop(810, 97, 240, 60);
		    system.setThresholdMin(150);
		    system.setImgName("result.jpg");
		    inputData[4] = system.performOcr(system.imageProcess()); //result
		    
		    //Team Player Name Capture
		    system.click(1028, 190); //Timeline Tab
		    system.setOcrDictionary("ABCEGHIJKLMNIPRSTVXYZabceghijklmnoprstvxyz");
		    TimeUnit.MILLISECONDS.sleep(1000);
		    system.setCrop(250, 500, 160, 217);
		    system.setThresholdMin(179);
		    system.setImgName("teamChar.jpg");
		    inputData[5] = system.performOcr(system.imageProcess());
		    
		    //Enemy Player Name Capture
		    system.click(1216, 190); //Performance Tab
		    TimeUnit.MILLISECONDS.sleep(1000);
		    system.setCrop(990, 345, 330, 345);
		    system.setThresholdMin(130);
		    system.setImgName("enemyChar.jpg");
		    inputData[6] = system.performOcr(system.imageProcess());
		    
		    	
		}
		catch (Exception e)
		{
			System.out.println("Excpetion caught in tasks function.");
		}
			
	}
	public String[] getInputData()
	{
		return(inputData);
		
	}

	
	 

}
