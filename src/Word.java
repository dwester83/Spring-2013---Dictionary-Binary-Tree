/**
 * Word implementation of interface.
 * 
 * @author Daniel Wester
 */

@SuppressWarnings("rawtypes")
public class Word implements WordADT, Comparable {

	private String word;
	private String description;
	
	/**
	 * Default constructor. Sets all the values to "".
	 */
	public Word(){
		word ="";
		description="";
	}

	/**
	 * Default word constructor
	 * 
	 * @param word String word to be input
	 * @param description String description of the word
	 */
	public Word(String word, String description){
		setWord(word);
		setDescription(description);
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWord() {
		return word;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean equals(Object word){
		if ((word != null) && (this.getClass() == word.getClass())){
			WordADT otherWord = (WordADT) word;
			return (otherWord.getWord().equalsIgnoreCase(getWord()));
		}
		return false;
	}

	public int compareTo(Object word) {
		WordADT otherWord = (WordADT) word; //Not sure if this works yet??
		return this.getWord().compareToIgnoreCase(otherWord.getWord());
	}

	public void makeCopy(WordADT otherWord) {
		WordADT word = (WordADT) otherWord;
		setWord(word.getWord());
		setDescription(word.getDescription());
	}

	public WordADT getCopy() {
		WordADT wordReturn = new Word(getWord(), getDescription());;
		return wordReturn;
	}

}
