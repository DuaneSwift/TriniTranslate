import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a trie
 */
public class MyTrie {
  MyTrieNode root;

  public MyTrie() {
    root = new MyTrieNode();
  }

  // Inserts a word into the trie.
  public void insertSetup(String word) {
    HashMap<Character, MyTrieNode> children = root.children;

    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new MyTrieNode(c);
        children.put(c, t);
      }

      children = t.children;

      //set leaf node
      if(i==word.length()-1)
        t.isLeaf = true;
    }
  }


  public MyTrieNode searchNode(String str){
    Map<Character, MyTrieNode> children = root.children;
    MyTrieNode t = null;
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(children.containsKey(c)){
        t = children.get(c);
        children = t.children;
      } else {
        return null;
      }
    }
    return t;
  }
}
