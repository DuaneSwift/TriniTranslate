import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by duane on 8/8/2016.
 */
public class DictionaryTest {
  MyTrie trie = new MyTrie();
  Dictionary dictionary;

  @Test
  public void insertNewWord() throws Exception {
    dictionary = new LocalDictionary(trie);
    dictionary.insertNewWord("house", PARTOFSPEECH.N);
    assertTrue(trie.searchNode("h").children.containsKey('o'));
    assertTrue(trie.searchNode("hou").children.containsKey('s'));
  }

  @Test
  public void isInDictionary() throws Exception {
    trie.insertSetup("hi");
    trie.insertSetup("he");
    trie.insertSetup("him");
    trie.insertSetup("apple");
    dictionary = new LocalDictionary(trie);
    assertTrue(dictionary.isInDictionary("he"));
    assertTrue(dictionary.isInDictionary("apple"));
    assertFalse(dictionary.isInDictionary("app"));
    dictionary.insertNewWord("app", PARTOFSPEECH.N);
    assertTrue(dictionary.isInDictionary("app"));
  }

  @Test
  public void isInDictionarySuperfluous() throws Exception {
    trie.insertSetup("hi");
    trie.insertSetup("he");
    trie.insertSetup("him");
    trie.insertSetup("apple");
    dictionary = new LocalDictionary(trie);
    assertEquals("Yes, untagged" ,dictionary.isInDictionarySuperfluous("he"));
    assertEquals("Yes, untagged", dictionary.isInDictionarySuperfluous("apple"));
    assertEquals("No", dictionary.isInDictionarySuperfluous("app"));
    dictionary.insertNewWord("app", PARTOFSPEECH.N);
    assertEquals("Yes, N", dictionary.isInDictionarySuperfluous("app"));
  }

  @Test
  public void getPartOfSpeech() throws Exception {

  }

  @Test
  public void tagPartOfSpeech() throws Exception {

  }

}