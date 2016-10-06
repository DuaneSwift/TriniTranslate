import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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
      scanner = new Scanner(new File("BaseRules.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (scanner.hasNextLine()) {
      Scanner scanner1 = new Scanner(scanner.nextLine());
      while (scanner1.hasNext()) {
        PARTOFSPEECH prev = PARTOFSPEECH.reversePOS(scanner1.next());
        PARTOFSPEECH post = PARTOFSPEECH.reversePOS(scanner1.next());
        PARTOFSPEECH result = PARTOFSPEECH.reversePOS(scanner1.next());
      }
    }
    return treeruletree;
  }
}
