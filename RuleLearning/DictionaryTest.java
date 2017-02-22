package RuleLearning;

import MyDataStructures.MyTrie;
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
    dictionary.insertNewWord("house", "N");
    assertTrue(trie.search("h").getChildren().containsKey('o'));
    assertTrue(trie.search("hou").getChildren().containsKey('s'));

  }

  @Test
  public void isInDictionary() throws Exception {
    trie.insert("hi");
    trie.insert("he");
    trie.insert("him");
    trie.insert("apple");
    dictionary = new LocalDictionary(trie);
    assertTrue(dictionary.isInDictionary("he"));
    assertTrue(dictionary.isInDictionary("apple"));
    assertFalse(dictionary.isInDictionary("app"));
    dictionary.insertNewWord("app", "N");
    assertTrue(dictionary.isInDictionary("app"));
  }

  @Test
  public void isInDictionarySuperfluous() throws Exception {
    trie.insert("hi");
    trie.insert("he");
    trie.insert("him");
    trie.insert("apple");
    dictionary = new LocalDictionary(trie);
    assertEquals("Yes, untagged" ,dictionary.isInDictionarySuperfluous("he"));
    assertEquals("Yes, untagged", dictionary.isInDictionarySuperfluous("apple"));
    assertEquals("No", dictionary.isInDictionarySuperfluous("app"));
    dictionary.insertNewWord("app", "N");
    assertEquals("Yes, N", dictionary.isInDictionarySuperfluous("app"));
  }

  @Test
  public void getPartOfSpeech() throws Exception {

  }

  @Test
  public void tagPartOfSpeech() throws Exception {

  }

}