package valorant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DataView {

	private JFrame frame;
	private JTextField allyScoreLive;
	private JTextField resultLive;
	private JTextField enemScoreLive;
	private JTextField combatScore;
	private JTextField econ;
	private JTextField kills;
	private JTextField deaths;
	private JTextField assists;
	private JTextField allyA;
	private JTextField allyB;
	private JTextField allyC;
	private JTextField allyD;
	private JTextField allyE;
	private JTextField enemA;
	private JTextField enemB;
	private JTextField enemC;
	private JTextField enemD;
	private JTextField enemE;
	private JTextField attackWins;
	private JTextField defendWins;
	private JTextField gameLength;
	private JLabel lblRank;
	private JLabel lblRankChange;
	private JLabel lblTime;
	private JTextField time;
	private JTextField rankChangeLive;
	private JTextField rankLive;
	private String[] windowData = new String[24];
	

	/**
	 * Create the application.
	 */
	public DataView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ally Score");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 11, 81, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnemyScore = new JLabel("Enemy Score");
		lblEnemyScore.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblEnemyScore.setBounds(233, 11, 97, 20);
		frame.getContentPane().add(lblEnemyScore);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblResult.setBounds(144, 11, 51, 20);
		frame.getContentPane().add(lblResult);
		
		allyScoreLive = new JTextField();
		allyScoreLive.setBounds(25, 42, 81, 20);
		frame.getContentPane().add(allyScoreLive);
		allyScoreLive.setColumns(10);
		
		resultLive = new JTextField();
		resultLive.setColumns(10);
		resultLive.setBounds(126, 42, 81, 20);
		frame.getContentPane().add(resultLive);
		
		enemScoreLive = new JTextField();
		enemScoreLive.setColumns(10);
		enemScoreLive.setBounds(243, 42, 81, 20);
		frame.getContentPane().add(enemScoreLive);
		
		JLabel lblAcs = new JLabel("ACS");
		lblAcs.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblAcs.setBounds(25, 73, 40, 20);
		frame.getContentPane().add(lblAcs);
		
		JLabel lblEcon = new JLabel("Econ");
		lblEcon.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblEcon.setBounds(25, 99, 40, 20);
		frame.getContentPane().add(lblEcon);
		
		JLabel lblK = new JLabel("K");
		lblK.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblK.setBounds(25, 123, 40, 20);
		frame.getContentPane().add(lblK);
		
		JLabel lblAcs_2_1 = new JLabel("D");
		lblAcs_2_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblAcs_2_1.setBounds(25, 152, 40, 20);
		frame.getContentPane().add(lblAcs_2_1);
		
		JLabel lblAcs_2_1_1 = new JLabel("A");
		lblAcs_2_1_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblAcs_2_1_1.setBounds(25, 179, 40, 20);
		frame.getContentPane().add(lblAcs_2_1_1);
		
		combatScore = new JTextField();
		combatScore.setColumns(10);
		combatScore.setBounds(64, 75, 40, 20);
		frame.getContentPane().add(combatScore);
		
		econ = new JTextField();
		econ.setColumns(10);
		econ.setBounds(64, 99, 40, 20);
		frame.getContentPane().add(econ);
		
		kills = new JTextField();
		kills.setColumns(10);
		kills.setBounds(64, 125, 40, 20);
		frame.getContentPane().add(kills);
		
		deaths = new JTextField();
		deaths.setColumns(10);
		deaths.setBounds(64, 152, 40, 20);
		frame.getContentPane().add(deaths);
		
		assists = new JTextField();
		assists.setColumns(10);
		assists.setBounds(64, 179, 40, 20);
		frame.getContentPane().add(assists);
		
		JLabel lblAllies = new JLabel("Allies");
		lblAllies.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblAllies.setBounds(144, 73, 51, 20);
		frame.getContentPane().add(lblAllies);
		
		JLabel lblEnemies = new JLabel("Enemies");
		lblEnemies.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblEnemies.setBounds(253, 73, 71, 20);
		frame.getContentPane().add(lblEnemies);
		
		allyA = new JTextField();
		allyA.setColumns(10);
		allyA.setBounds(126, 99, 81, 20);
		frame.getContentPane().add(allyA);
		
		allyB = new JTextField();
		allyB.setColumns(10);
		allyB.setBounds(126, 125, 81, 20);
		frame.getContentPane().add(allyB);
		
		allyC = new JTextField();
		allyC.setColumns(10);
		allyC.setBounds(126, 154, 81, 20);
		frame.getContentPane().add(allyC);
		
		allyD = new JTextField();
		allyD.setColumns(10);
		allyD.setBounds(126, 181, 81, 20);
		frame.getContentPane().add(allyD);
		
		allyE = new JTextField();
		allyE.setColumns(10);
		allyE.setBounds(126, 208, 81, 20);
		frame.getContentPane().add(allyE);
		
		enemA = new JTextField();
		enemA.setColumns(10);
		enemA.setBounds(243, 99, 81, 20);
		frame.getContentPane().add(enemA);
		
		enemB = new JTextField();
		enemB.setColumns(10);
		enemB.setBounds(243, 125, 81, 20);
		frame.getContentPane().add(enemB);
		
		enemC = new JTextField();
		enemC.setColumns(10);
		enemC.setBounds(243, 154, 81, 20);
		frame.getContentPane().add(enemC);
		
		enemD = new JTextField();
		enemD.setColumns(10);
		enemD.setBounds(243, 181, 81, 20);
		frame.getContentPane().add(enemD);
		
		enemE = new JTextField();
		enemE.setColumns(10);
		enemE.setBounds(243, 208, 81, 20);
		frame.getContentPane().add(enemE);
		
		JLabel lblAtkWins = new JLabel("ATK Wins");
		lblAtkWins.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblAtkWins.setBounds(25, 239, 81, 20);
		frame.getContentPane().add(lblAtkWins);
		
		JLabel lblDefWins = new JLabel("DEF Wins");
		lblDefWins.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblDefWins.setBounds(126, 239, 81, 20);
		frame.getContentPane().add(lblDefWins);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblDuration.setBounds(243, 239, 81, 20);
		frame.getContentPane().add(lblDuration);
		
		attackWins = new JTextField();
		attackWins.setColumns(10);
		attackWins.setBounds(25, 262, 81, 20);
		frame.getContentPane().add(attackWins);
		
		defendWins = new JTextField();
		defendWins.setColumns(10);
		defendWins.setBounds(126, 262, 81, 20);
		frame.getContentPane().add(defendWins);
		
		gameLength = new JTextField();
		gameLength.setColumns(10);
		gameLength.setBounds(243, 262, 81, 20);
		frame.getContentPane().add(gameLength);
		
		lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblRank.setBounds(25, 294, 81, 20);
		frame.getContentPane().add(lblRank);
		
		lblRankChange = new JLabel("Rank Change");
		lblRankChange.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblRankChange.setBounds(116, 294, 109, 20);
		frame.getContentPane().add(lblRankChange);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblTime.setBounds(243, 294, 81, 20);
		frame.getContentPane().add(lblTime);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(243, 317, 81, 20);
		frame.getContentPane().add(time);
		
		rankChangeLive = new JTextField();
		rankChangeLive.setColumns(10);
		rankChangeLive.setBounds(126, 317, 81, 20);
		frame.getContentPane().add(rankChangeLive);
		
		rankLive = new JTextField();
		rankLive.setColumns(10);
		rankLive.setBounds(25, 317, 81, 20);
		frame.getContentPane().add(rankLive);
	}
	
	public void setFrameHiden ()
	{
		frame.setVisible(false);
	}
	public void setFrameVisible()
	{
		frame.setVisible(true);
	}
	
	public String[] getFieldData ()
	{	
		
		windowData[0] = allyScoreLive.toString();
		windowData[1] = resultLive.toString();
		windowData[2] = enemScoreLive.toString();
		windowData[3] = combatScore.toString();
		windowData[4] = econ.toString();
		windowData[5] = kills.toString();
		windowData[6] = deaths.toString();
		windowData[7] = assists.toString();
		windowData[8] = allyA.toString();
		windowData[9] = allyB.toString();
		windowData[10] = allyC.toString();
		windowData[11] = allyD.toString();
		windowData[12] = allyE.toString();
		windowData[13] = enemA.toString();
		windowData[14] = enemB.toString();
		windowData[15] = enemC.toString();
		windowData[16] = enemD.toString();
		windowData[17] = enemE.toString();
		windowData[18] = attackWins.toString();
		windowData[19] = defendWins.toString();
		windowData[20] = gameLength.toString();
		windowData[21] = time.toString();
		windowData[22] = rankChangeLive.toString();
		windowData[23] = rankLive.toString();
		return(windowData);
	}
	public void setFieldData(String[] theFieldData)
	{
		allyScoreLive.setText(windowData[0]);
		resultLive.setText(windowData[1]);
		enemScoreLive.setText(windowData[2]);
		combatScore.setText(windowData[3]);
		econ.setText(windowData[4]);
		kills.setText(windowData[5]);
		deaths.setText(windowData[6]);
		assists.setText(windowData[7]);
		allyA.setText(windowData[8]);
		allyB.setText(windowData[9]);
		allyC.setText(windowData[10]);
		allyD.setText(windowData[11]);
		allyE.setText(windowData[12]);
		enemA.setText(windowData[13]);
		enemB.setText(windowData[14]);
		enemC.setText(windowData[15]);
		enemD.setText(windowData[16]);
		enemE.setText(windowData[17]);
		attackWins.setText(windowData[18]);
		defendWins.setText(windowData[19]);
		gameLength.setText(windowData[20]);
		time.setText(windowData[21]);
		rankChangeLive.setText(windowData[22]);
		rankLive.setText(windowData[23]);
	}

}
