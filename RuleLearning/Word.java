package RuleLearning;

/**
 * The concept of a word
 */
public class Word {
  private final String tag;
  private final String wordstring;

  private Word(String wordstring, String tag) {
    this.tag = tag;
    this.wordstring = wordstring;
  }

  /**
   * Returns the POS of a word
   */
  public String getTag() {
    return tag;
  }

  /**
   * Gets the word string
   */
  public String getWordstring() {
    return wordstring;
  }
}
