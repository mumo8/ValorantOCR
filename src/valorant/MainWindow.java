package valorant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
//import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MainWindow {

	private JFrame mainWindow;
	private JTextField fileLocation;
	private JDialog fileVisual;
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		fileVisual = new JDialog();
		fileVisual.setBounds(100, 100, 655, 414);
		fileVisual.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JFileChooser fileChooser = new JFileChooser();		
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				File file = fileChooser.getSelectedFile();
				fileLocation.setText(file.getPath().toString());
				fileVisual.setVisible(false);
			}
		});
		fileVisual.getContentPane().add(fileChooser, BorderLayout.CENTER);
		
		mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 523, 303);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Screen Resolution");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 154, 18);
		mainWindow.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1920 x 1080", "2560 x 1440", "3840\u2009\u00D7\u20092160"}));
		comboBox.setBounds(174, 10, 323, 22);
		mainWindow.getContentPane().add(comboBox);
		
		JLabel lblScreenMode = new JLabel("Screen Mode");
		lblScreenMode.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblScreenMode.setBounds(10, 54, 154, 18);
		mainWindow.getContentPane().add(lblScreenMode);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Fullscreen", "Windowed Fullscreen", "Windowed"}));
		comboBox_1.setBounds(174, 54, 323, 22);
		mainWindow.getContentPane().add(comboBox_1);
		
		JLabel lblExcelFileLocation = new JLabel("Excel File Location");
		lblExcelFileLocation.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblExcelFileLocation.setBounds(10, 95, 154, 18);
		mainWindow.getContentPane().add(lblExcelFileLocation);
		
		JLabel lblGameMode = new JLabel("Game Mode");
		lblGameMode.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblGameMode.setBounds(10, 134, 154, 18);
		mainWindow.getContentPane().add(lblGameMode);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Unrated", "Competitive"}));
		comboBox_1_1.setBounds(174, 134, 323, 22);
		mainWindow.getContentPane().add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Collect Data");
		btnNewButton.setBounds(219, 230, 114, 23);
		mainWindow.getContentPane().add(btnNewButton);
		
		JLabel lblView = new JLabel("View");
		lblView.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblView.setBounds(10, 182, 154, 18);
		mainWindow.getContentPane().add(lblView);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Progression Tab Visible", "No Progression Tab"}));
		comboBox_1_1_1.setBounds(174, 182, 323, 22);
		mainWindow.getContentPane().add(comboBox_1_1_1);
		
		fileLocation = new JTextField();
		fileLocation.setBounds(171, 96, 233, 20);
		mainWindow.getContentPane().add(fileLocation);
		fileLocation.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Browse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileVisual.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(414, 95, 83, 23);
		mainWindow.getContentPane().add(btnNewButton_1);
	}
	
	public void setFrameHidden ()
	{
		mainWindow.setVisible(false);
	}
	public void setFrameVisible()
	{
		mainWindow.setVisible(true);
	}
	
	public String getFileLocation()
	{
		return(fileLocation.toString());
	}
}
