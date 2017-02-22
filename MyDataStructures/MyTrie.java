package MyDataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a .,
 */
public class MyTrie {
  MyTrieNode root;

  public MyTrie() {
    root = new MyTrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    HashMap<Character, MyTrieNode> children = root.getChildren();

    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new MyTrieNode(c);
        children.put(c, t);
      }

      children = t.getChildren();

      //set leaf node
      if(i==word.length()-1)
        t.setLeaf(true);
    }
  }

  public void insert(String word, String pos) {
    HashMap<Character, MyTrieNode> children = root.getChildren();

    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new MyTrieNode(c);
        children.put(c, t);
      }

      children = t.getChildren();

      //set leaf node
      if(i==word.length()-1) {
        t.setLeaf(true);
        t.setPos(pos);
      }
    }
  }


  public MyTrieNode search(String str){
    Map<Character, MyTrieNode> children = root.getChildren();
    MyTrieNode t = null;
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(children.containsKey(c)){
        t = children.get(c);
        children = t.getChildren();
      } else {
        return null;
      }
    }
    return t;
  }

  public boolean contains(String str){
    Map<Character, MyTrieNode> children = root.getChildren();
    MyTrieNode t = null;
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(children.containsKey(c)){
        t = children.get(c);
        children = t.getChildren();
      } else {
        return false;
      }
    }
    return t.isLeaf();
  }

  public ArrayList<String> getPOS(String str){
    Map<Character, MyTrieNode> children = root.getChildren();
    MyTrieNode t = null;
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(children.containsKey(c)){
        t = children.get(c);
        children = t.getChildren();
      } else {
        throw new IllegalArgumentException("Wasn't safely called, the given word wasn't marked or isn't a word");
      }
    }
    return t.getPos();
  }

  public MyTrieNode getRoot() {
    return root;
  }

  public void setRoot(MyTrieNode root) {
    this.root = root;
  }
}
