package RuleLearning;

import MyDataStructures.MyTrie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by duane on 8/9/2016.
 */
public class RuleReader {

  private static MyTrie trie = new MyTrie();
  private static LocalDictionary temporarylocaldictionary = new LocalDictionary(trie);


  RuleReader(){}

  static LocalDictionary populateDictionary() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("BaseMorphemes.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (scanner.hasNextLine()) {
      Scanner scanner1 = new Scanner(scanner.nextLine());
      while (scanner1.hasNext()) {
        String word = scanner1.next();
        String temppos = scanner1.next();
        String pos = null;
        pos = temppos;
        temporarylocaldictionary.insertNewWord(word, pos);
      }
    }
    return temporarylocaldictionary;
  }

}
