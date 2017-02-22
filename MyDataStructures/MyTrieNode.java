package MyDataStructures;


import java.util.*;

/**
 * Trie implementation
 */
public class MyTrieNode {
  private char root;
  private boolean isLeaf;
  private HashMap<Character, MyTrieNode> children = new HashMap<Character, MyTrieNode>();
  private HashMap<String, Integer> pos = new HashMap<>();

  public MyTrieNode() {}

  public MyTrieNode(char letter){
    this.root = letter;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public char getRoot() {
    return root;
  }

  public HashMap<Character, MyTrieNode> getChildren() {
    return children;
  }

  public void setLeaf(boolean leaf) {
    isLeaf = leaf;
  }

  public void setRoot(char root) {
    this.root = root;
  }

  public void setPos(String newpos) {
    if (this.pos.containsKey(newpos)) {
      pos.put(newpos, pos.get(newpos)+1);
    } else {
      pos.put(newpos, 1);
    }
  }

  public ArrayList<String> getPos() {
    ArrayList<String> pos = new ArrayList<>();
    Iterator<Map.Entry<String, Integer>> iterator = this.pos.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, Integer> map = iterator.next();
      pos.add(map.getKey());
    }
    return pos;
  }
}
