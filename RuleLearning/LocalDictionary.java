package RuleLearning;

import MyDataStructures.MyTrie;
import MyDataStructures.MyTrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Implements the dictionary interface, holding the attributes of a trie
 */
public class LocalDictionary extends MyTrie implements Dictionary {

  private MyTrie dictionary;

  LocalDictionary(MyTrie dictionary) {
    this.dictionary = dictionary;
  }

  LocalDictionary() {
    this.dictionary = DictionaryReader.populateDictionary();
  }

  @Override
  public boolean isInDictionary(String word) {
    MyTrieNode t = dictionary.search(word);
    if(t != null && t.isLeaf())
      return true;
    else
      return false;
  }

  @Override
  public Dictionary insertNewWord(String word, String pos) {
    HashMap<Character, MyTrieNode> children = dictionary.getRoot().getChildren();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new MyTrieNode(c);
        children.put(c, t);
      }

      children = t.getChildren();

      if (i == word.length() - 1) {
        t.setLeaf(true);
      }
    }
    return this;
  }

  @Override
  public ArrayList<String> getPartOfSpeech(String word) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.getRoot().getChildren();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist in the dictionary");
      }
      children = t.getChildren();

      if (i == word.length() - 1) {
        return t.getPos();
      }
    }
    return null;
  }

  /**
   * Determines if a word is tagged yet or not
   * @param word word to be inquired about
   * @return tagged status
   * @throws BadWordException if word isn't in dictionary
   */
  private boolean isTagged(String word) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.getRoot().getChildren();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist in the dictionary");
      }
      children = t.getChildren();

//      if (i == word.length() - 1) {
//        return !(t.partofspeech == null);
//      }
    }
    throw new IllegalStateException("Your RuleLearning.Dictionary populater or Trie is Faulty, Duane");
  }

  @Override
  public Dictionary tagPartOfSpeech(String word, String partofspeech) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.getRoot().getChildren();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist to be tagged");
      }
      children = t.getChildren();

      if (i == word.length() - 1) {
        t.setPos(partofspeech);
      }
    }
    return this;
  }

  @Override
  public String isInDictionarySuperfluous(String word) throws BadWordException {
    StringBuilder usermessage = new StringBuilder();
    if (isInDictionary(word)) {
      usermessage.append("Yes, ");
    } else {
      usermessage.append("No");
      return usermessage.toString();
    }
    if (isTagged(word)) {
      usermessage.append(getPartOfSpeech(word).toString());
    } else {
      usermessage.append("untagged");
    }
    return usermessage.toString();
  }


}
