package de.ckraus.commons.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public interface IStringUtils
    extends IUtils<String> {

    /**
     * Alphabet Characters a-z and A-Z
     */
    int REGEX_ALPHABET = "^[a-zA-Z]+$";


    /**
     * positionsInAlphabet
     * @param s
     * @return
     */
    default public int[] positionsInAlphabet( String s ) {
        int[] iaPositionInAlphabet = null;

        if ( StringUtils.isNotEmpty( s )
                && s.matches( REGEX_ALPHABET ) ) {

        char[] ac = s.toCharArray();
        iaPositionInAlphabet = new int[ac.length];

        for ( int i=0; i<ac.length; i++ ) {
            int iPositionInAlphabet = CharacterUtils.positionInAlphabet( ac[i] );

            if ( iPositionInAlphabet < 0 )
                throw new IllegalArgumentException( "Non alphabetical char. Only chars a-z and A-Z are allowed." );

                iaPositionInAlphabet[i] = iPositionInAlphabet;
            }
        }
        return iaPositionInAlphabet;
    }

    /**
     * positionsInAlphabet
     * @param s
     * @return
     */
    default String positionsInAlphabetAsString( String s ) {
        return positionsInAlphabetAsString( s, false );
    }

    /**
     * positionsInAlphabet
     * @param s
     * @param bLeadingZero
     * @return
     */
    default String positionsInAlphabetAsString( String s, boolean bLeadingZero ) {
        StringBuilder sbPositionsInAlphabet = null;

        int[] iaPositionInAlphabet = this.positionsInAlphabet( s );

        if ( ArrayUtils.isNotEmpty( iaPositionInAlphabet ) ) {
            sbPositionsInAlphabet = new StringBuilder();

            for ( int iPositionInAlphabet : iaPositionInAlphabet ) {
                if ( bLeadingZero
                        && iPositionInAlphabet < 10 ) {
                    sbPositionsInAlphabet.append( 0 );
                }
                sbPositionsInAlphabet.append( iPositionInAlphabet );
            }
        }

        return ( null != sbPositionsInAlphabet
                ? sbPositionsInAlphabet.toString()
                : null
        );
    }

}
