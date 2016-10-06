/**
 * Interface for the Dictonary of ASE Words,
 * and all relevant accessors/modifiers
 */
public interface Dictionary {

  /**
   * Is this word in the dictionary as it stands?
   * @param word given word
   * @return whether or not the word is in the dictionary
   */
  boolean isInDictionary(String word);

  /**
   * Add this word to the dictionary
   * @param word word to be added
   * @param pos part of speech to be tagged as
   * @return {@code this}
   */
  Dictionary insertNewWord(String word, PARTOFSPEECH pos);

  /**
   * What is the part of speech of this word?
   * @param word word that this inquiry is about
   * @return the part of speech of the word
   * @throws BadWordException if the word isn't in the dictionary, this will be thrown
   */
  PARTOFSPEECH getPartOfSpeech(String word) throws BadWordException;

  /**
   * Used to tag the part of speech of a word that is already in the dictionary
   * @param word word to be tagged
   * @param partofspeech the part of speech to tag the word as
   * @return {@code this}
   * @throws BadWordException if the word to be tagged isn't in the dictionary
   */
  Dictionary tagPartOfSpeech(String word, PARTOFSPEECH partofspeech) throws BadWordException;

  /**
   * Returns a more superfluous version of isInDictionary, indicating POS as well
   * @param word the word to be checked
   * @return a string of whether or not the word is in the dictionary.
   * If it is, it returns both true and the POS of the word
   * @throws BadWordException if the word isn't in the dictionary
   */
  String isInDictionarySuperfluous(String word) throws BadWordException;
}
