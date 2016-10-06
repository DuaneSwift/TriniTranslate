import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads words into the dictionary, from the given list of words,
 * usually from ASE as of now
 */
public class DictionaryReader {

  //Trie of words
  private static MyTrie trie = new MyTrie();
  //Instantiation
  private static LocalDictionary temporarylocaldictionary = new LocalDictionary(trie);

  DictionaryReader(){}

  // Populates the trie with words
  static LocalDictionary populateDictionary() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("dictionary.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (scanner.hasNextLine()) {
      Scanner scanner1 = new Scanner(scanner.nextLine());
      while (scanner1.hasNext()) {
        String s = scanner1.next();
        temporarylocaldictionary.insertSetup(s);
      }
    }
    return temporarylocaldictionary;
  }
}