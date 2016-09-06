import java.util.HashMap;

/**
 * Created by duane on 8/8/2016.
 */
public class MyTrieNode {
  private char root;
  PARTOFSPEECH partofspeech;
  boolean isLeaf;
  HashMap<Character, MyTrieNode> children = new HashMap<Character, MyTrieNode>();

  public MyTrieNode() {}

  public MyTrieNode(char letter){
    this.root = letter;
  }

//  public MyTrieNode(char letter, PARTOFSPEECH partofspeech){
//    this.root = letter;
//    this.partofspeech = partofspeech;
//  }
}
