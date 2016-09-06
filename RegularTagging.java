/**
 * Created by duane on 8/9/2016.
 */
public class RegularTagging {

  private final String sentence;

  MyTrie trie1 = new MyTrie();
  LocalDictionary localDictionary = new LocalDictionary(trie1);

  MyTrie trie2 = new MyTrie();
  LocalDictionary rulesDictionary = new LocalDictionary(trie2);

  BaseRules baseRules = new BaseRules();

  String[][] sentencetagged;

  public RegularTagging(String sentence) {
    this.sentence = sentence;
    setup();
    sentencetagged = new String[][]{};
  }

  private void setup() {
    localDictionary = DictionaryReader.populateDictionary();
    rulesDictionary = RuleReader.populateDictionary();
  }

  public String pretagging() throws BadWordException {
    StringBuilder sb = new StringBuilder();
    String[] arr = sentence.split(" ");
    sentencetagged = new String[arr.length][2];
    int i = 0;
      PARTOFSPEECH pos = null;
      for (String s : arr) {
        sentencetagged[i][0] = s;
        sb.append(s);
        sb.append("\n");
        if (rulesDictionary.isInDictionary(s)) {
          pos = rulesDictionary.getPartOfSpeech(s);
          sb.append(pos);
          sentencetagged[i][1] = pos.toString();
        } else {
          sb.append("?");
          sentencetagged[i][1] = "untagged";
        }
        sb.append("\n\n");
        i++;
      }
    return sb.toString();
  }

  public String posttagging() throws BadWordException {
    pretagging();
    for (int i = 0; i < sentencetagged.length; i++) {
      if (sentencetagged[i][1].equals("untagged")) {
        if (i == 0) {
          sentencetagged[i][1] = "N";
          localDictionary.insertNewWord(sentencetagged[i][0], PARTOFSPEECH.N);
        } else {
          //To FIX, will fail if last word wasn't pretagged
          PARTOFSPEECH recommendedpos = BaseRules.getRule(
                  PARTOFSPEECH.reversePOS(sentencetagged[i - 1][1]),
                  PARTOFSPEECH.reversePOS(sentencetagged[i + 1][1]));
          localDictionary.insertNewWord(sentencetagged[i][0], recommendedpos);
          sentencetagged[i][1] = recommendedpos.toString();
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < sentencetagged.length; j++) {
      sb.append(sentencetagged[j][0]);
      sb.append("\n");
      sb.append(sentencetagged[j][1]);
      sb.append("\n\n");
    }
    return sb.toString();
  }
}
