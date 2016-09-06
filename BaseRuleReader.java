import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by duane on 8/9/2016.
 */
public class BaseRuleReader {
  static LinkedList<LinkedList<LinkedList<PARTOFSPEECH>>> treeruletree = new LinkedList<>();

  BaseRuleReader(){}

  static LinkedList<LinkedList<LinkedList<PARTOFSPEECH>>> populateRules() {
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
