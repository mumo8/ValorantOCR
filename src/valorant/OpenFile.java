package valorant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Window;

public class OpenFile {

	private JDialog fileVisual;
	private String fileLocation = "C:\\";

	/**
	 * Create the application.
	 */
	public OpenFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fileVisual = new JDialog();
		fileVisual.setBounds(100, 100, 655, 414);
		fileVisual.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		JFileChooser fileChooser = new JFileChooser();		
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				File file = fileChooser.getSelectedFile();
				fileLocation = file.getPath();
				fileVisual.setVisible(false);
			}
		});
		fileVisual.getContentPane().add(fileChooser, BorderLayout.CENTER);
	}
	
	public void setFrameHidden ()
	{
		fileVisual.setVisible(false);
	}
	public void setFrameVisible()
	{
		fileVisual.setVisible(true);
	}
	public String getFileLocation()
	{
		return(fileLocation);
		
	}

}