package edu.learn.java.ds.permutations;

/**
 * Created by egnanasigamony on 23/02/2017.
 */
public class TelephoneNumbers
{
    private static final int PHONE_NUMBER_LENGTH = 7;
    private final int [] phoneNum;
    private char[] result = new char[ PHONE_NUMBER_LENGTH ];
    public TelephoneNumbers ( int[] n ) { phoneNum = n; }
    public void printWords(){ printWords( 0 ); }

    String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public char getCharKey(int key, int index) {
        key = key - 2;
        return letters[key].charAt(index);
    }

    private void printWords(int curDigit ) {
        //System.out.println("printWords : "+curDigit);
        if( curDigit == PHONE_NUMBER_LENGTH ) {
            System.out.println( new String( result ) );
            return;
        }

        for( int i = 0; i < letters[curDigit].length(); ++i ) {
            result[ curDigit ] = getCharKey( phoneNum[curDigit], i );
            printWords( curDigit + 1 );
            if( phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1) return;
        }
    }

    public static void main(String ...args) {
        int[] numbers = { 7,2,4,5,3,8,9};
        TelephoneNumbers tn=new TelephoneNumbers(numbers);
        tn.printWords();
    }

}
