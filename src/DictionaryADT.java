/**
 * @author Daniel Wester
 */

import java.io.IOException;

public interface DictionaryADT {
	
	/**
	 * Will add a word with a description to the dictionary.
	 * 
	 * @param name String represents the name of the word being added.
	 * @param description String represents the description of the word being added.
	 * @return boolean Will return true if added, or false if failed.
	 * @require Must not exist in the dictionary already.
	 */
	public boolean add(String name, String description);
	
	/**
	 * Will remove the word from the dictionary.
	 * 
	 * @param name String represents the name of the word being removed from the dictionary.
	 * @return boolean Will return true if removed, false if failed.
	 * @require Word must exist in the dictionary.
	 * @ensure The word will be removed and a lookup() will not show the word in the list.
	 */
	public boolean remove(String name); 
	
	/**
	 * Will list all words that match the name and definition of the word.
	 * 
	 * @param name String word that is being looked up.
	 * @return String A string list of all the words that match the word.
	 * @require word must be a string that exists in the dictionary.
	 * @ensure Will list the word that matches what is being searched.
	 */
	public String lookup(String word);
	
	/**
	 * Will list all the words inside the tree.
	 * 
	 * @return String A string list of the all the words inside the tree inorder.
	 * @ensure Will list all the words and descriptions that are in the tree inorder.
	 */
	public String listInorder();
	
	/**
	 * Will list all the words inside the tree.
	 * 
	 * @return String A string list of the all the words inside the tree preorder.
	 * @ensure Will list all the words and descriptions that are in the tree preorder.
	 */
	public String listPreorder();
	
	/**
	 * Will list all the words inside the tree.
	 * 
	 * @return String A string list of the all the words inside the tree postorder.
	 * @ensure Will list all the words and descriptions that are in the tree postorder.
	 */
	public String listPostorder();
	
	/**
	 * Saves the changes made the dictionary
	 * @throws IOException If the file cannot be found.
	 * @ensure The document will be correctly formated after the save.
	 */
	public void save() throws IOException;

}
