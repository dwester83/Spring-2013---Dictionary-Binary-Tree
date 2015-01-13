/**
 * Word interface to be used instead of Data Element.
 * 
 * @author Daniel Wester
 */

public interface WordADT {
	
	/**
	 * Sets the word for the dictionary.
	 * 
	 * @param word String of the word.
	 * @ensure getWord() will return the word input.
	 */
	public void setWord(String word);
	
	/**
	 * Sets the description of the word for the dictionary.
	 * 
	 * @param description String sets the description of the word.
	 * @ensure getDescription() returns the description input.
	 */
	public void setDescription(String description);
	
	/**
	 * Returns the word.
	 * 
	 * @return String of the word input from setWord()
	 */
	public String getWord();
	
	/**
	 * Returns the description of the word.
	 * 
	 * @return String of the description from setDescription()
	 */
	public String getDescription();
	
	/**
	 * Method to determine whether two objects contain the same data.
	 * 
	 * @param word Object word to be checked if equal.
	 * @return Returns true if this object contains the 
	 * same data as the object otherElement; 
	 * otherwise, it returns false.
	 */
	public boolean equals(Object word);
	
	/**
	 * Method to compare two objects.
	 * 
	 * @param word Object word to be compared to another word.
	 * @return Returns a value < 0 if this object is 
	 * less than the object otherElement; 
	 * Returns 0 if this object is the same as the 
	 * object otherElement. 
	 * Returns a value > 0 if this object is greater 
	 * than the object otherElement.
	 */
	public int compareTo(Object word);
	
	/**
	 * Method to copy otherElement into this object.
	 * 
	 * @param otherWord The data of otherElement is copied into this object.
	 */
	public void makeCopy(WordADT otherWord);
	
	/**
	 * Method to return a copy of this object.
	 * 
	 * @return A copy of this object is created and
	 *  a reference of the copy is returned.
	 */
	public WordADT getCopy();
	
}
