import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by duane on 8/8/2016.
 */
public class BaseRules {
  private static LinkedList<LinkedList<LinkedList<PARTOFSPEECH>>> treeruletree = new LinkedList<>();

  BaseRules() {
    this.treeruletree = BaseRuleReader.populateRules();
  }

  // To fix, currently just polls first
  public static PARTOFSPEECH getRule(PARTOFSPEECH prev, PARTOFSPEECH post) {
    treeruletree = BaseRuleReader.populateRules();
    return treeruletree.get(treeruletree.indexOf(prev)).get(treeruletree.indexOf(post)).poll();
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
