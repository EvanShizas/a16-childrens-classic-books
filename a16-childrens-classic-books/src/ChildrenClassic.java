/**
 * Finds the title of a book according to the library reference number.
 * 
 * modified    	20220603
 * date        	20220530
 * @filename   	ChildrenClassic.java
 * @author		Alvin Chan
 * @author		Hammad Hassan
 * @author		Oscar Lam
 * @author		Evan Shizas
 * @version    	1.0.0
 * @see        	A16 - Searching Routines
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		dialogBox.setFont(new Font("Courier New", Font.BOLD, 13));
		dialogBox.setBackground(Color.WHITE);
		dialogBox.setEditable(false);
		dialogBox.setBounds(10, 187, 551, 23);
		contentPane.add(dialogBox);
		dialogBox.setColumns(10);

		linearBox = new JTextField();
		linearBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		linearBox.setEditable(false);
		linearBox.setBackground(Color.WHITE);
		linearBox.setColumns(10);
		linearBox.setBounds(130, 221, 431, 23);
		contentPane.add(linearBox);

		binaryBox = new JTextField();
		binaryBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		binaryBox.setEditable(false);
		binaryBox.setBackground(Color.WHITE);
		binaryBox.setColumns(10);
		binaryBox.setBounds(130, 255, 431, 23);
		contentPane.add(binaryBox);
	}

	private void findActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			ArrayList <String> list = new ArrayList <String>();
			BufferedReader br = new BufferedReader(new FileReader("src/BookList.txt"));
			String word, input = referenceSelect.getValue().toString();
			boolean valid = false;

			while ((word = br.readLine()) != null){
				list.add(word);
			}

			String[] bookList = new String[list.size()], book = new String[list.size()/2], num = new String[list.size()/2];
			
			list.toArray(bookList);
			
			for (int i = 0; i < bookList.length; i++) {
				if (i % 2 == 0) {
					num[i/2] = bookList[i];
				}

				else if (i % 2 == 1) {
					book[i/2] = bookList[i];
				}
			}

			for (int i = 0; i < num.length; i++) {
				if (input.equals(num[i])) {
					valid = true;
					break;
				}
			}
			
			if (!valid) {
				dialogBox.setText("ERROR: REFERENCE NUMBER DOES NOT EXIST! TRY AGAIN!");
				linearBox.setText("");
				binaryBox.setText("");
			}

			else {
				dialogBox.setText("SUCCESS: REFERENCE NUMBER FOUND!");
				
				linearSearch(book, num, input);
				binarySearch(book, num, 0, book.length-1, input);
			}

			br.close();
		} 

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void linearSearch(String[] book, String[] num, String input) {
		for (int i = 0; i < num.length; i++) {
			if (num[i].equals(input)) {
				linearBox.setText("Book Found --> " + book[i]);
			}
		}
	}

	public boolean binarySearch(String[] book, String[] num, int left, int right, String input){
		int middle = (left + right)/2;

		if (left > right) {
			return false;
		}

		int compare = input.compareTo(num[middle]);

		if (compare == 0) {
			binaryBox.setText("Book Found --> " + book[middle]);
			return true;
		}

		else if (input.equals(num[right])) {
			binaryBox.setText("Book Found --> " + book[right]);
			return true;
		}

		if (compare < 0) {
			return binarySearch(book, num, left, middle-1, input);
		} 

		else if (Integer.parseInt(input) < Integer.parseInt(num[middle])) {
			return binarySearch(book, num, left, middle-1, input);
		}

		else {
			return binarySearch(book, num, middle + 1, right, input);
		}
	}
}
