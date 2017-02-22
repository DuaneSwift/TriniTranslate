package RuleLearning;

import MyDataStructures.MyTrie;

import java.util.Set;

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


  public static Set<Character> getRule(String prev, String post) {
    trieofrules = BaseRuleReader.populateRules();
    RuleDictionary d = new RuleDictionary(trieofrules);
    if (d.contains(prev+post)) {
      if (!d.search(prev+post).isLeaf()) {
        return d.search(prev+post).getChildren().keySet();
      }
    }
    return null;
  }
}
