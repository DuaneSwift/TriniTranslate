import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by duane on 8/9/2016.
 */
public class RegularTaggingTest {
  @Test
  public void pretagging() throws Exception {
    RegularTagging regularTagging = new RegularTagging("he likes him");
    System.out.print(regularTagging.pretagging());
    System.out.print(regularTagging.posttagging());
  }

}