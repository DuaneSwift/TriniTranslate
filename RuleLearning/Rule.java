package RuleLearning;

/**
 * The concept of a rule as an object
 */
public class Rule {
  String preceedingCategory;
  String currentCategory;
  String postCategory;
  double probability;

  Rule(String prev, String partofspeech, String post) {
    this.preceedingCategory = prev;
    this.currentCategory = partofspeech;
    this.postCategory = post;
  }
}
