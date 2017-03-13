import SimpleRuleReplacement.BlindTranslate;
import SimpleRuleReplacement.BlindTranslateImpl;


public class Main {

    public static void main(String[] args) {
        BlindTranslate bt = new BlindTranslateImpl();
        String original = "I used several books to compile this list, the most useful was ‘Cambridge Grammar of English’ by Carter and McCarthy";
        String translated  = bt.translate(original);
        System.out.println("Original: " + original);
        System.out.println("Translated: " + translated);
    }
}
