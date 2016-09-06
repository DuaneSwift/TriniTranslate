import java.util.HashMap;

/**
 * Created by duane on 8/8/2016.
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
    MyTrieNode t = dictionary.searchNode(word);
    if(t != null && t.isLeaf)
      return true;
    else
      return false;
  }

  @Override
  public Dictionary insertNewWord(String word, PARTOFSPEECH pos) {
    HashMap<Character, MyTrieNode> children = dictionary.root.children;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new MyTrieNode(c);
        children.put(c, t);
      }

      children = t.children;

      if (i == word.length() - 1) {
        t.isLeaf = true;
        t.partofspeech = pos;
      }
    }
    return this;
  }

  @Override
  public PARTOFSPEECH getPartOfSpeech(String word) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.root.children;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist in the dictionary");
      }
      children = t.children;

      if (i == word.length() - 1) {
        return t.partofspeech;
      }
    }
    return null;
  }

  private boolean isTagged(String word) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.root.children;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist in the dictionary");
      }
      children = t.children;

      if (i == word.length() - 1) {
        return !(t.partofspeech == null);
      }
    }
    throw new IllegalStateException("Your Dictionary populater or Trie is Faulty, Duane");
  }

  @Override
  public Dictionary tagPartOfSpeech(String word, PARTOFSPEECH partofspeech) throws BadWordException {
    HashMap<Character, MyTrieNode> children = dictionary.root.children;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      MyTrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        throw new BadWordException("This word doesn't exist to be tagged");
      }
      children = t.children;

      if (i == word.length() - 1) {
        t.partofspeech = partofspeech;
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
