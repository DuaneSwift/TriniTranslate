import java.util.LinkedList;

/**
 * The base rules of the program to be expanded on as it grows
 */
public class BaseRules {
  private static MyTrie trieofrules = new MyTrie();

  /**
   * Instantiation
   */
  BaseRules() {
    this.trieofrules = BaseRuleReader.populateRules();
  }

  // To fix, currently just polls first
  public static PARTOFSPEECH getRule(PARTOFSPEECH prev, PARTOFSPEECH post) {
    trieofrules = BaseRuleReader.populateRules();
    RuleDictionary d = new RuleDictionary(trieofrules);
    d.trieoftree.root
    return
  }
/**
 * Rules As I Go to remember to code
 *
 * V after N, Optional AUX
 *
 * N after CONJ always
 *
 */
}
