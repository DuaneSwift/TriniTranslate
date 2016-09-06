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
//      System.out.print(scanner.next());
      while (scanner1.hasNext()) {
        String word = scanner1.next();
        String temppos = scanner1.next();
        PARTOFSPEECH pos = null;
        if (temppos.equals("N")) {
          pos = PARTOFSPEECH.N;
        } else if (temppos.equals("V")) {
          pos = PARTOFSPEECH.V;
        } else if (temppos.equals("ADJ")) {
          pos = PARTOFSPEECH.ADJ;
        } else if (temppos.equals("ADV")) {
          pos = PARTOFSPEECH.ADV;
        } else if (temppos.equals("CONJ")) {
          pos = PARTOFSPEECH.CONJ;
        } else if (temppos.equals("AUX")) {
          pos = PARTOFSPEECH.AUX;
        }
//        System.out.println(word);
//        System.out.println(temppos);
//        System.out.println(pos.toString());
        temporarylocaldictionary.insertNewWord(word, pos);
      }
    }
    return temporarylocaldictionary;
  }

//    private LocalRules temporarylocalrules;
//
//    RuleReader(){}
//
//    LocalRules preAddRules() {
//      Scanner scanner = null;
//      try {
//        scanner = new Scanner(new File("BaseMorphemes.txt"));
//      } catch (FileNotFoundException e) {
//        e.printStackTrace();
//      }
//      while (scanner.hasNextLine()) {
//        Scanner scanner1 = new Scanner(scanner.nextLine());
//        while (scanner1.hasNext()) {
//          String word = scanner1.next();
//          String pos = scanner1.next();
//          temporarylocalrules.insertSetup(s);
//        }
//      }
//      return temporarylocaldictionary;
//    }


}
