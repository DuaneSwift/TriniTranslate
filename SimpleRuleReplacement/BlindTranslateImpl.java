package SimpleRuleReplacement;

import MyDataStructures.MyTrie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class BlindTranslateImpl implements BlindTranslate {

    public BlindTranslateImpl() {
    }

    //****************************SETUP****************************//

    // Dictionary which holds a trie of all given words,
    // with a hashmap of its part(s) of speech along with the
    // runtime occurences of those particular POSes
    private static MyTrie dictionary = new MyTrie();

    // Hashmap of Irregular Verbs, with Irregular Past Tense as the Key,
    // and Present Tense as the value.
    private static HashMap<String, String> irregularHashMap = new HashMap<>();

    /**
     * Populates Trie of English Verbs
     *
     * @return Trie of English Verbs
     */
    private static MyTrie populateVerbs() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("verbs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()) {
                String s = scanner1.next();
                dictionary.insert(s, "verb");
            }
        }
        return dictionary;
    }

    /**
     * Populates Trie of English Auxs
     *
     * @return Trie of English Auxs
     */
    private static MyTrie populateAux() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("presaux.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()) {
                String s = scanner1.next();
                dictionary.insert(s, "presaux");
            }
        }
        scanner = null;
        try {
            scanner = new Scanner(new File("pastaux.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()) {
                String s = scanner1.next();
                dictionary.insert(s, "pastaux");
            }
        }
        return dictionary;
    }

    /**
     * Populates Hashmap of Irregular English Verbs
     *
     * @return Hashmap of Irregular-Past-Tense -> Present Tense
     */
    private static void populateIrregularVerbs() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("irregularverbs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean shouldscan = true;
        while (scanner.hasNextLine()) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()) {
                if (shouldscan) {
                    String s = scanner1.next();
                    String s2 = scanner1.next();
                    irregularHashMap.put(s2, s);
                    shouldscan = false;
                } else {
                    scanner1.next();
                    shouldscan = true;
                }
            }
        }
    }


    /**
     * Populates Trie of English Nouns
     *
     * @return Trie of English Nouns
     */
    private static MyTrie populateNouns() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("nouns.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()) {
                String s = scanner1.next();
                dictionary.insert(s, "noun");
            }
        }
        return dictionary;
    }


    //*********************** PHONETIC FUNCTIONS **************************//

    /**
     * The de-nasalzation of the English engma to [n]
     * @param s possible word
     * @return de-nasalized ending
     */
    private static String ingShortening(String s) {
        if (s.endsWith("ing")) {
            return s.substring(0, s.length() - 3) + "in";
        }
        return s;
    }

    /**
     * The vowel-sonorant merger that occurs, usually [er] to [a]
     * @param s possible word
     * @return vowel-sonorant merge
     */
    private static String erShortening(String s) {
        if (s.endsWith("er")) {
            return s.substring(0, s.length() - 2) + "a";
        }
        return s;
    }

    /**
     * Idiosyncratic change that occures in TTEC
     * @param s possible word
     * @return possible change
     */
    private static String toChange(String s) {
        if (s.equals("to")) {
            return "tuh";
        }
        return s;
    }

    /**
     * Systematic de-frication of [th] to [d]
     * @param s possible word
     * @return possible defricated word
     */
    private static String thDeFrication(String s) {
        if (s.startsWith("th")) {
            return "d"+s.substring(2, s.length());
        }
        return s;
    }


    //*********************** MORPHOLOGY FUNCTIONS **************************//

    /**
     * The non-concatenative past-tense preference of TTEC (did instead of -ed)
     * @param s possible verb
     * @return de-bounded past tense morpheme + V.prs
     */
    private static String pastSeperation(String s) {
        if (irregularHashMap.containsKey(s)) {
            return "did " + irregularHashMap.get(s);
        } else if (dictionary.contains(s) && dictionary.getPOS(s).contains("verb")) {
            if (s.endsWith("ed")) {
                if (dictionary.contains(s.substring(0, s.length() - 2))
                        && dictionary.getPOS(s.substring(0, s.length() - 2)).contains("verb")) {
                    return "did " + s.substring(0, s.length() - 2);
                } else {
                    return "did " + s.substring(0, s.length() - 1);
                }
            } else if (s.endsWith("d")) {
                return "did " + s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    //*********************** SYNTAX FUNCTIONS **************************//

    /**
     * VP -> V, drop Aux
     *
     * @param s possible auxiliary
     * @return word or no-aux
     */
    private static String dropPresAux(String s) {
        if (dictionary.contains(s) && (dictionary.getPOS(s).contains("presaux"))) {
            return "";
        }
        return s;
    }

    /**
     * The uniform change of will to go in TTEC
     * @param s possible word
     * @return possible changed FUT free morpheme
     */
    private static String willReplacement(String s) {
        if (s.equals("will")) {
            return "go";
        }
        return s;
    }

    /**
     * Ongoing/Habitual does inseration, usually replaces habitual version
     * of verb, like dances -> does dance. Inflection occurs on the verb to do,
     * similar to the previous past-tense de-bounding
     * @param s possible word
     * @return de-bounded HAB morpheme + verb.prs
     */
    private static String doesInsertion(String s) {
        if (dictionary.contains(s)) {
            if (dictionary.getPOS(s).contains("verb")
                    && !dictionary.getPOS(s).contains("noun")
                    && !dictionary.getPOS(s).contains("pastaux")
                    && !dictionary.getPOS(s).contains("presaux")) {
                if (s.endsWith("es")) {
                    return "does " + s.substring(0, s.length() - 2);
                } else if (s.endsWith("s")) {
                    return "does " + s.substring(0, s.length() - 1);
                }
            }
        }
        return s;
    }

    // Questions

    /**
     * Yes-No Questions in TTEC uniformly begin with "Ent"
     * @param s possible marker
     * @param wordposn is this the start of the sentence? (relying on Std English Sub Aux switch)
     * @return Possible TTEC YNQuestion morpheme
     */
    private static String YNQuestion(String s, int wordposn) {
        if (dictionary.contains(s.toLowerCase()) && dictionary.getPOS(s.toLowerCase()).contains("aux")) {
            if (wordposn == 0) {
                return "Ent";
            }
        }
        return s;
    }

    //************************ REQUIRED IMPLEMENTATIONS FROM INTERFACE ************************//
    @Override
    public Boolean hasTriniEquivalent(String s) {
        return null;
    }


    //************************* TESTING AREA *********************//

    /**
     * Self Explanatory
     */
    private void setup() {
        populateAux();
        populateVerbs();
        populateIrregularVerbs();
        populateNouns();
    }

    /**
     * Determines if a ... self explanatory honestly.
     * @param s word
     * @return is it a proper noun?
     */
    private boolean isLexicallyAProperNoun(String s) {
        return !(s.substring(0, 1).toLowerCase().equals(s.substring(0, 1)));
    }

    @Override
    public String translate(String word) {
        setup();
        String[] words = word.split("\\W+");
        String newstring = "";
        int wordposn = 0;
        for (String s : words) {
            String tempnewstring = newstring;

            //Proper Noun Check
            if (!isLexicallyAProperNoun(s)) {

                //Phonology
                if (!ingShortening(s).equals(s)) {
                    newstring += ingShortening(s) + " ";
                }
                if (!erShortening(s).equals(s)) {
                    newstring += erShortening(s) + " ";
                }
                if (!toChange(s).equals(s)) {
                    newstring += toChange(s) + " ";
                }
                if (!thDeFrication(s).equals(s)) {
                    newstring += thDeFrication(s) + " ";
                }

                //Morphology
                if (!pastSeperation(s).equals(s)) {
                    newstring += pastSeperation(s) + " ";
                }

                //Syntax
                if (!doesInsertion(s).equals(s)) {
                    newstring += doesInsertion(s) + " ";
                }
                if (!willReplacement(s).equals(s)) {
                    newstring += willReplacement(s) + " ";
                }
                if (!dropPresAux(s).equals(s)) {
                    newstring += dropPresAux(s) + " ";
                }
                if (!YNQuestion(s, wordposn).equals(s)) {
                    newstring += YNQuestion(s, wordposn) + " ";
                }
            }

            //else
            if (tempnewstring.equals(newstring)) {
                newstring += s + " ";
            }
            wordposn++;
        }
        return newstring;
    }
}
