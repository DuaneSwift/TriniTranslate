import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by duane on 8/8/2016.
 */
public class DictionaryReader {

  private static MyTrie trie = new MyTrie();
  private static LocalDictionary temporarylocaldictionary = new LocalDictionary(trie);

  DictionaryReader(){}

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
