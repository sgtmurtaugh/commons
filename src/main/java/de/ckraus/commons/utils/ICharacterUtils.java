package de.ckraus.commons.utils;

@SuppressWarnings({"javadoc"})
public interface ICharacterUtils
    extends IUtils<Character> {

  /**
  * ASCII Code a
  */
  int ASCII_CODE_A_LOWER_CASE = 97;
  /**
  * ASCII Code z
  */
  int ASCII_CODE_Z_LOWER_CASE = 122;
  /**
  * ASCII Code A
  */
  int ASCII_CODE_A_UPPER_CASE = 65;
  /**
  * ASCII Code Z
  */
  int ASCII_CODE_Z_UPPER_CASE = 90;


  /**
   * positionInAlphabet
   * @param c
   * @return
   * TODO
   */
  default int positionInAlphabet( char c ) {
    int positionInAlphabet = -1;

    if ( c >= ASCII_CODE_A_LOWER_CASE && c <= ASCII_CODE_Z_LOWER_CASE ) {
      positionInAlphabet = ((int)c) - (ASCII_CODE_A_LOWER_CASE - 1);
    }
    else
    if ( c >= ASCII_CODE_A_UPPER_CASE && c <= ASCII_CODE_Z_UPPER_CASE ) {
      positionInAlphabet = ((int)c) - (ASCII_CODE_A_UPPER_CASE - 1);
    }
    else {
      // NOOP
    }
    return positionInAlphabet;
  }

  /**
   * positionInAlphabet
   * @param c
   * @return
   * TODO
   */
  default int positionInAlphabet( Character c ) {
    int positionInAlphabet = -1;

    if ( null != c ) {
      positionInAlphabet = this.positionInAlphabet( c.charValue() );
    }
    else {
      // NOOP
    }
    return positionInAlphabet;
  }

}
