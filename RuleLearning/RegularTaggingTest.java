package RuleLearning;

import org.junit.Test;

/**
 * Tests for tagging
 */
public class RegularTaggingTest {
  @Test
  public void pretagging() throws Exception {
    RegularTagging regularTagging = new RegularTagging("he likes him");
    System.out.print(regularTagging.pretagging());
    System.out.print(regularTagging.posttagging());
  }

}