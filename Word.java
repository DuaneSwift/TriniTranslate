/**
 * Created by duane on 8/8/2016.
 */
public class Word {
  private final PARTOFSPEECH tag;
  private final String wordstring;

  private Word(String wordstring, PARTOFSPEECH tag) {
    this.tag = tag;
    this.wordstring = wordstring;
  }

  public PARTOFSPEECH getTag() {
    return tag;
  }

  public String getWordstring() {
    return wordstring;
  }
}
