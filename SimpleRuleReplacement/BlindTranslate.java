package SimpleRuleReplacement;

/**
 * Created by duane on 2/21/2017.
 */
public interface BlindTranslate {

    /**
     * Is there a TTEC Equivalent to this word? (TO IMPLEMENT)
     * @param s ASE/BSE word
     * @return whether or not there is a Trini equivalent
     */
    Boolean hasTriniEquivalent(String s);

    /**
     * Self explanatory - Takes a ASE Sentence and Translates it to TTEC
     * @param s sentence/word
     * @return TTEC Sentence/word
     */
    String translate(String s);
}
