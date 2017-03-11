package rankTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.DefaultComboBoxModel;

public class RankText2FolderWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankText2FolderWindow window = new RankText2FolderWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RankText2FolderWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Append \"_Out\""}));
		comboBox.setBounds(207, 111, 195, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTextToFolders = new JLabel("Text to Folders for S3 Bucket");
		lblTextToFolders.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTextToFolders.setBounds(121, 20, 211, 16);
		frame.getContentPane().add(lblTextToFolders);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(74, 178, 298, 177);
		frame.getContentPane().add(textArea);
		
		JLabel lblCopyTextHere = new JLabel("Copy Text Here:");
		lblCopyTextHere.setBounds(74, 150, 168, 16);
		frame.getContentPane().add(lblCopyTextHere);
		
		JLabel lblOptions = new JLabel("Options:");
		lblOptions.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOptions.setBounds(54, 115, 143, 16);
		frame.getContentPane().add(lblOptions);
		
		JButton btnGenerate = new JButton("Generate!");
		btnGenerate.setBounds(161, 367, 117, 29);
		frame.getContentPane().add(btnGenerate);
		
		JLabel isDone = new JLabel("Not Generated...");
		isDone.setBounds(171, 408, 132, 16);
		frame.getContentPane().add(isDone);
		
		 ActionListener al = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        System.out.println("Button Pressed!");
		        Boolean appendEnd;
		        String comboBoxChoice = (String)comboBox.getSelectedItem();
		        if(comboBoxChoice.equals("Append \"_Out\"")){
		        	appendEnd = true;
		        }else{
		        	appendEnd = false;
		        }
		        Text2Folders run = new Text2Folders("Generated_Folders",textArea.getText(),appendEnd);
		        isDone.setText("Generated!");
		        btnGenerate.setEnabled(false);
		      }
		    };
		 btnGenerate.addActionListener(al);   
	}
}
