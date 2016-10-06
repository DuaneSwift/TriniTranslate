/**
 * The concept of a rule as an object
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
