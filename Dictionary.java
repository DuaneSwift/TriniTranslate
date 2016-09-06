/**
 * Created by duane on 8/8/2016.
 */
public interface Dictionary {

  boolean isInDictionary(String word);

  Dictionary insertNewWord(String word, PARTOFSPEECH pos);

  PARTOFSPEECH getPartOfSpeech(String word) throws BadWordException;

  Dictionary tagPartOfSpeech(String word, PARTOFSPEECH partofspeech) throws BadWordException;

  String isInDictionarySuperfluous(String word) throws BadWordException;
}
