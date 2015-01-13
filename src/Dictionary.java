/**
 * @author Daniel Wester
 */

import java.io.*;
import java.util.*;

public class Dictionary implements DictionaryADT {

	private String fileLocation;
	private BinarySearchTree tree;

	/**
	 * Default constructor. Requires a file to given to build from / to.
	 * 
	 * @param txt File location to be used.
	 * @throws FileNotFoundException Thrown if a file cannot be found.
	 */
	public Dictionary(String txt) throws FileNotFoundException {
		tree = new BinarySearchTree();
		fileLocation = txt;

		Scanner scanner = new Scanner(new File(fileLocation));

		while(scanner.hasNext()){
			add(scanner.next(),scanner.next() + scanner.nextLine());
		}
	}

	public boolean add(String name, String description) {
		WordADT word = new Word(name, description);
		return tree.insert(word);
	}

	public boolean remove(String name) {
		WordADT word = new Word(name,"");
		return tree.deleteNode(word);
	}

	public String lookup(String word) {
		WordADT searchWord =  new Word(word, "");

		long startTime = System.nanoTime();
		searchWord = tree.search(searchWord);
		long  iterationTime = System.nanoTime() - startTime;
		
		String output = (searchWord.getWord() + " - " + searchWord.getDescription() + "\n"
				+ "It took " + iterationTime + " nanoseconds to find this.");

		return output;
	}

	public String listInorder() {
		List<WordADT> list = tree.inorderTraversal();
		return listLoop(list);
	}

	public String listPreorder() {
		List<WordADT> list = tree.preorderTraversal();
		return listLoop(list);
	}

	public String listPostorder() {
		List<WordADT> list = tree.postorderTraversal();
		return listLoop(list);
	}
	
	/**
	 * Goes through the list and makes the string representation from a List
	 *
	 * @param list List that needs to be made into a string
	 * @return String of the list being made.
	 */
	private String listLoop(List<WordADT> list){
		WordADT word;
		ListIterator<WordADT> l = list.listIterator();
		String output = "";

		while (l.hasNext()){
			word = l.next();
			output += (word.getWord() + " - " + word.getDescription() + "\n");
		}
		return output;
	}

	public void save() throws IOException {

		FileWriter filewrite = new FileWriter(fileLocation);
		BufferedWriter bw = new BufferedWriter(filewrite);

		WordADT word;
		List<WordADT> list = tree.preorderTraversal();
		ListIterator<WordADT> l = list.listIterator();

		while (l.hasNext()){
			word = l.next();
			String next = (word.getWord() + " " + word.getDescription());
			bw.write(next);
			if(l.hasNext())
				bw.newLine();
		}

		bw.close();
	}

}
