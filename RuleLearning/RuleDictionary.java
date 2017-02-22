package RuleLearning;

import MyDataStructures.MyTrie;

/**
 * Created by duane on 10/1/2016.
 */
public class RuleDictionary extends MyTrie {

  MyTrie trieoftree = new MyTrie();

  public RuleDictionary(MyTrie trie) {
    trieoftree = trie;
  }
}