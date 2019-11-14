package textformatter;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class FormatterFrame {

	private JFrame frmF;
	// Any temporary file that the user/customer does not mess with
	// **modify this so it can work for you
	String filelocation = "C:\\Users\\yoabd\\git\\asuwork\\Project1\\src\\textformatter\\";
	String filename = "input.txt";
	private File temp = new File(filelocation+filename);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormatterFrame window = new FormatterFrame();
					window.frmF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormatterFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmF = new JFrame();
		frmF.setTitle("Text Formatter");
		frmF.setBounds(100, 100, 581, 395);
		frmF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmF.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(65, 117, 431, 202);
		frmF.getContentPane().add(textArea);
		
		Button button = new Button("Open");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser(new File("c:\\"));
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textArea.setText("Loading "+filename+"...\n");
				textArea.append("Formatting File...\n");
				formatFile(filename);
				textArea.append("Done.\n");
			}
		});
		button.setBounds(65, 38, 179, 46);
		frmF.getContentPane().add(button);
		
		Button button_2 = new Button("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Saving File...\n");
				JFileChooser saver = new JFileChooser(new File("c:\\"));
				saver.setDialogTitle("Save a File");
				int result = saver.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					Scanner sc = null;
					try {
						sc = new Scanner(temp);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					File fi = saver.getSelectedFile();
					try {
						// copies file from the temp file to a file the user chooses
						FileWriter fw = new FileWriter(fi.getPath());
						while(sc.hasNextLine()) {
							String s = sc.nextLine();
							fw.write(s);
							fw.write('\n');
						}
						fw.flush();
						fw.close();
					} catch (Exception e2) {
						String err = "Error. File not Found";
						JOptionPane.showMessageDialog(null, err);
					}
				}
				textArea.append("File Saved.");
			}
		});
		button_2.setBounds(317, 38, 179, 46);
		frmF.getContentPane().add(button_2);
	}
	
	public void formatFile(String filepath) {
		// Copying JS' Code
		int char_length = 80;
		int spacing, columns = 1;
		boolean wrap, indent = false;
		char justified = 'l'; // left right center equal
		List<String> output = new ArrayList<>();
		FormLogic logic = new FormLogic();
		Path path = Paths.get(filelocation, filename);
		try
		{

			List<String> input = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8); // read input.txt and place each line into its own index within list
			output = logic.formatLength(input, char_length); // apply character limit rule

			Files.write(path, output, StandardCharsets.UTF_8); // write output.txt

		} catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}