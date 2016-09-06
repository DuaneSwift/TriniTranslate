/**
 * Created by duane on 8/8/2016.
 */
public enum PARTOFSPEECH {
  N, N_PRO,
  V, V_TRANS, V_INTRANS, AUX,
  POSSESSIVE_CONTRACTION, REGULAR_CONTRACTION,
  ADJ, ADV,
  CONJ,
  MODAL, PREP, DET;

  public static PARTOFSPEECH reversePOS(String s) {
    if (s.equals("N")) {
      return N;
    } else if (s.equals("V")) {
      return V;
    } else if (s.equals("AUX")) {
      return AUX;
    } else if (s.equals("PREP")) {
      return PREP;
    } else if (s.equals("DET")) {
      return DET;
    } else if (s.equals("ADJ")) {
      return ADJ;
    } else if (s.equals("ADV")) {
      return ADV;
    }
    return null;
  }
}
