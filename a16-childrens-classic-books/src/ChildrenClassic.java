/**
 * Finds the title of a book according to the library reference number.
 * 
 * modified     20220530
 * date         20220530
 * @filename    Fibonacci.java
 * @author      Alvin Chan, Hammad Hassan, Oscar Lam, Evan Shizas
 * @version     1.0.0
 * @see         A16 - Searching Routines
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class ChildrenClassic extends JFrame {

	private JPanel contentPane;
	private JTextField dialogBox;
	private JTextField linearBox;
	private JTextField binaryBox;
	private JSpinner referenceSelect;
	private JButton find;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChildrenClassic frame = new ChildrenClassic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChildrenClassic() {
		setBackground(Color.WHITE);
		setTitle("A16 - Children's Classics");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Children's Classics");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 571, 40);
		contentPane.add(title);
		
		JLabel enterHereLbl = new JLabel("Enter Reference Number Here:");
		enterHereLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterHereLbl.setBackground(Color.WHITE);
		enterHereLbl.setBounds(10, 153, 210, 23);
		contentPane.add(enterHereLbl);
		
		JLabel linearLbl = new JLabel("Linear Search:");
		linearLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		linearLbl.setBackground(Color.WHITE);
		linearLbl.setBounds(10, 221, 110, 23);
		contentPane.add(linearLbl);
		
		JLabel binaryLbl = new JLabel("Binary Search:");
		binaryLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		binaryLbl.setBackground(Color.WHITE);
		binaryLbl.setBounds(10, 255, 110, 23);
		contentPane.add(binaryLbl);
		
		JTextArea programInfo = new JTextArea();
		programInfo.setWrapStyleWord(true);
		programInfo.setText("This program will find the title of a book according to the library reference number.\r\n\r\nThe program will use a Binary Search and a Linear Search...");
		programInfo.setLineWrap(true);
		programInfo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		programInfo.setEditable(false);
		programInfo.setBackground(Color.WHITE);
		programInfo.setBounds(10, 51, 551, 95);
		contentPane.add(programInfo);
		
		find = new JButton("Find Book!");
		find.setBounds(391, 153, 170, 23);
		contentPane.add(find);
		find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findActionPerformed(evt);
			}
		});
		
		referenceSelect = new JSpinner();
		referenceSelect.setModel(new SpinnerNumberModel(0, 0, 400000000, 1));
		referenceSelect.setForeground(Color.WHITE);
		referenceSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		referenceSelect.setBackground(Color.WHITE);
		referenceSelect.setBounds(200, 153, 181, 23);
		contentPane.add(referenceSelect);
		
		dialogBox = new JTextField();
		dialogBox.setBackground(Color.WHITE);
		dialogBox.setEditable(false);
		dialogBox.setBounds(10, 187, 551, 23);
		contentPane.add(dialogBox);
		dialogBox.setColumns(10);
		
		linearBox = new JTextField();
		linearBox.setEditable(false);
		linearBox.setBackground(Color.WHITE);
		linearBox.setColumns(10);
		linearBox.setBounds(130, 221, 431, 23);
		contentPane.add(linearBox);
		
		binaryBox = new JTextField();
		binaryBox.setEditable(false);
		binaryBox.setBackground(Color.WHITE);
		binaryBox.setColumns(10);
		binaryBox.setBounds(130, 255, 431, 23);
		contentPane.add(binaryBox);
	}
	
	private void findActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
}
