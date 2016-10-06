/**
 * The concept of a word
 */
public class Word {
  private final PARTOFSPEECH tag;
  private final String wordstring;

  private Word(String wordstring, PARTOFSPEECH tag) {
    this.tag = tag;
    this.wordstring = wordstring;
  }

  /**
   * Returns the POS of a word
   */
  public PARTOFSPEECH getTag() {
    return tag;
  }

  /**
   * Gets the word string
   */
  public String getWordstring() {
    return wordstring;
  }
}
