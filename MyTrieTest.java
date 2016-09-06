import static org.junit.Assert.*;

/**
 * Created by duane on 8/8/2016.
 */
public class MyTrieTest {

  MyTrie trie = new MyTrie();

  @org.junit.Test
  public void insertSetup() throws Exception {
    trie.insertSetup("hi");
    assertTrue(trie.searchNode("h").children.containsKey('i'));
    assertFalse(trie.searchNode("h").children.containsKey('e'));
    trie.insertSetup("he");
    assertTrue(trie.searchNode("h").children.containsKey('i'));
    assertTrue(trie.searchNode("h").children.containsKey('e'));
  }
}