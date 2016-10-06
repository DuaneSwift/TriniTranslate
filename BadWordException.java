/**
 * Throws an exception if a word is given that isn't
  */
class BadWordException extends Exception {

  public BadWordException() {}

  public BadWordException(String message) {
    super(message);
  }
}
