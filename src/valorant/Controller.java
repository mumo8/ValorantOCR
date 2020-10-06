package valorant;


import java.util.concurrent.TimeUnit;

public class Controller
{
	public static void main(String[] args) throws Exception
	{
		MainWindow mainWindow = new MainWindow();
		mainWindow.setFrameVisible();
		
		GrabData system = new GrabData();
		system.setExcelLocation(mainWindow.getFileLocation());
		/*
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
		*/
	}
	
	 

}
