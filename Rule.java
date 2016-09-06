/**
 * Created by duane on 8/9/2016.
 */
public class Rule {
  PARTOFSPEECH preceedingCategory;
  PARTOFSPEECH currentCategory;
  PARTOFSPEECH postCategory;
  double probability;

  Rule(PARTOFSPEECH prev, PARTOFSPEECH partofspeech, PARTOFSPEECH post) {
    this.preceedingCategory = prev;
    this.currentCategory = partofspeech;
    this.postCategory = post;
  }
}
