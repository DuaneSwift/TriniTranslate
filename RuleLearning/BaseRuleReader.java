package RuleLearning;

import MyDataStructures.MyTrie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reader for the base grammatical rules of the program
 *
 * Follows the format PREV POST RESULT
 * Example: If given a sentence "He likes him",
 * the rule would be N N V in the form He him likes
 * meaning that in the condition of two surrounding Ns,
 * the middle element might be a verb
 */
public class BaseRuleReader {
  static MyTrie treeruletree = new MyTrie();

  BaseRuleReader(){}

  static MyTrie populateRules() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("RuleLearning.BaseRules.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (scanner.hasNextLine()) {
      Scanner scanner1 = new Scanner(scanner.nextLine());
      while (scanner1.hasNext()) {
        String prev = scanner1.next();
        String post = scanner1.next();
        String result = scanner1.next();
        treeruletree.insert(prev+post+result);
      }
    }
    return treeruletree;
  }
}
