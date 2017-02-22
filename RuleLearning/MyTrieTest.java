package RuleLearning;

import MyDataStructures.MyTrie;

import static org.junit.Assert.*;

/**
 * Trie Tests
 */
public class MyTrieTest {

  MyTrie trie = new MyTrie();

  @org.junit.Test
  public void insertSetup() throws Exception {
    trie.insert("hi");
    assertTrue(trie.search("h").getChildren().containsKey('i'));
    assertFalse(trie.search("h").getChildren().containsKey('e'));
    trie.insert("he");
    assertTrue(trie.search("h").getChildren().containsKey('i'));
    assertTrue(trie.search("h").getChildren().containsKey('e'));
  }
}