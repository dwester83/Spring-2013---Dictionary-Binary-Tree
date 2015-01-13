/**
 * @author Daniel Wester
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class BinaryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnSearch, btnRemove, btnAdd, btnSaveButton, 
		btnInorder, btnPostorder, btnPreorder;
	private JRadioButton rdbtnChatDictionary, rdbtnFile;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private DictionaryADT dictionary;
	private JLabel lblSortType, lblDictionary;

	/**
	 * Create the frame.
	 */
	public BinaryGUI() {
		setTitle("Dictionary Binary Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 34, 46, 57, 0, 0, 0, 0, 43, 26, 0, 39, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblThisProgramWill = new JLabel("This program will add/remove or search a dictionary for a definition.");
		GridBagConstraints gbc_lblThisProgramWill = new GridBagConstraints();
		gbc_lblThisProgramWill.gridwidth = 2;
		gbc_lblThisProgramWill.insets = new Insets(0, 0, 5, 5);
		gbc_lblThisProgramWill.gridx = 1;
		gbc_lblThisProgramWill.gridy = 0;
		contentPane.add(lblThisProgramWill, gbc_lblThisProgramWill);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		textField.addActionListener(new btnSearchAL());
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		btnSearch.addActionListener(new btnSearchAL());
		contentPane.add(btnSearch, gbc_btnSearch);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.SOUTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 2;
		btnAdd.addActionListener(new btnAddAL());
		contentPane.add(btnAdd, gbc_btnAdd);

		btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.anchor = GridBagConstraints.NORTH;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 2;
		gbc_btnRemove.gridy = 3;
		btnRemove.addActionListener(new btnRemoveAL());
		contentPane.add(btnRemove, gbc_btnRemove);

		lblSortType = new JLabel("Sort Type");
		GridBagConstraints gbc_lblSortType = new GridBagConstraints();
		gbc_lblSortType.insets = new Insets(0, 0, 5, 5);
		gbc_lblSortType.gridx = 2;
		gbc_lblSortType.gridy = 4;
		contentPane.add(lblSortType, gbc_lblSortType);

		btnInorder = new JButton("Inorder");
		GridBagConstraints gbc_btnInorder = new GridBagConstraints();
		gbc_btnInorder.insets = new Insets(0, 0, 5, 5);
		gbc_btnInorder.gridx = 2;
		gbc_btnInorder.gridy = 5;
		btnInorder.addActionListener(new btnInorderAL());
		contentPane.add(btnInorder, gbc_btnInorder);

		btnPostorder = new JButton("Postorder");
		GridBagConstraints gbc_btnPostorder = new GridBagConstraints();
		gbc_btnPostorder.insets = new Insets(0, 0, 5, 5);
		gbc_btnPostorder.gridx = 2;
		gbc_btnPostorder.gridy = 6;
		btnPostorder.addActionListener(new btnPostorderAL());
		contentPane.add(btnPostorder, gbc_btnPostorder);

		btnPreorder = new JButton("Preorder");
		GridBagConstraints gbc_btnInorder_1 = new GridBagConstraints();
		gbc_btnInorder_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnInorder_1.gridx = 2;
		gbc_btnInorder_1.gridy = 7;
		btnPreorder.addActionListener(new btnPreorderAL());
		contentPane.add(btnPreorder, gbc_btnInorder_1);

		lblDictionary = new JLabel("Dictionary");
		GridBagConstraints gbc_lblDictionary = new GridBagConstraints();
		gbc_lblDictionary.anchor = GridBagConstraints.SOUTH;
		gbc_lblDictionary.insets = new Insets(0, 0, 5, 5);
		gbc_lblDictionary.gridx = 2;
		gbc_lblDictionary.gridy = 8;
		contentPane.add(lblDictionary, gbc_lblDictionary);

		rdbtnChatDictionary = new JRadioButton("Chat");
		rdbtnChatDictionary.setSelected(true);
		buttonGroup.add(rdbtnChatDictionary);
		GridBagConstraints gbc_rdbtnChatDictionary = new GridBagConstraints();
		gbc_rdbtnChatDictionary.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnChatDictionary.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnChatDictionary.gridx = 2;
		gbc_rdbtnChatDictionary.gridy = 9;
		rdbtnChatDictionary.addActionListener(new chatButtonAL());
		contentPane.add(rdbtnChatDictionary, gbc_rdbtnChatDictionary);

		rdbtnFile = new JRadioButton("File Extension");
		buttonGroup.add(rdbtnFile);
		GridBagConstraints gbc_rdbtnFile = new GridBagConstraints();
		gbc_rdbtnFile.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFile.gridx = 2;
		gbc_rdbtnFile.gridy = 10;
		rdbtnFile.addActionListener(new fileButtonAL());
		contentPane.add(rdbtnFile, gbc_rdbtnFile);

		btnSaveButton = new JButton("Save");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 11;
		btnSaveButton.addActionListener(new btnSaveAL());
		contentPane.add(btnSaveButton, gbc_btnNewButton);

		//Default running actions.
		new chatButtonAL().actionPerformed(null);
	}

	private class btnSearchAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			try{
				String word = textField.getText();
				if (word.equals("")){
					new btnInorderAL().actionPerformed(null);
					return;
				}
				textArea.setText(dictionary.lookup(word));
			} catch (Exception e){
				textArea.setText(e.toString());
			}
		}
	}

	private class btnAddAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			try{
				String word = JOptionPane.showInputDialog("Please " +
						"enter the word you'd like to add to the list.");
				String description = JOptionPane.showInputDialog("Please " +
						"enter the description of the word " + word);
				if (dictionary.add(word, description))
					textArea.setText("Success!!! The word has been added to the list.");
				else 
					textArea.setText("The word is already in the list.");
			} catch (Exception e){
				textArea.setText(e.toString());
			}
		}
	}

	private class btnRemoveAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			try{
				String word = JOptionPane.showInputDialog("Please " +
						"enter the word you'd like to remove from the list.");
				if (dictionary.remove(word))
					textArea.setText("Success!!! The word has been removed from the list.");
				else 
					textArea.setText("The word is not in the list.");
			} catch (Exception e){
				textArea.setText(e.toString());
			}
		}
	}

	private class btnInorderAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			textArea.setText(dictionary.listInorder());
		}
	}

	private class btnPreorderAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			textArea.setText(dictionary.listPreorder());
		}
	}

	private class btnPostorderAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			textArea.setText(dictionary.listPostorder());
		}
	}

	private class btnSaveAL implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			try {
				dictionary.save();
			} catch (IOException e) {
				textArea.setText(e.toString());
			}
			textArea.setText("Save Complete");
		}
	}

	private class chatButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				dictionary = new Dictionary("bin/chatdictionary.txt");
				new btnInorderAL().actionPerformed(null);
			} catch (FileNotFoundException e) {
				textArea.setText("No file could be found. Make sure it's in the correct Directory /bin/chatdictionary.txt");
			}
		}
	}

	private class fileButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				dictionary = new Dictionary("bin/fileextensiondictionary.txt");
				new btnInorderAL().actionPerformed(null);
			} catch (FileNotFoundException e) {
				textArea.setText("No file could be found. Make sure it's in the correct Directory /bin/fileextensiondictionary.txt");
			}
		}
	}

}
