package edu.learn.java.ds.general;

import java.sql.Time;
import java.util.Scanner;

/**
 * Created by egnanasigamony on 20/09/2016.
 */

interface UniqueCharactersFinder {
    public boolean isCharactersUnique(String input);
}

class TimeSavingUniqueCharactersFinder implements  UniqueCharactersFinder {

    boolean[] node=new boolean[127];

    @Override
    public boolean isCharactersUnique(String input) {
        for(int i=0;i<input.length();i++) {
            if(node[input.charAt(i)] ==  true) {
                System.out.println("The repeated character is : "+input.charAt(i));
                return false;
            }
            node[input.charAt(i)]=true;
        }
        return true;
    }
}

class SpaceSavingUniqueCharactersFinder implements  UniqueCharactersFinder {

    @Override
    public boolean isCharactersUnique(String input) {
        for(int i=0;i<input.length();i++) {
            for(int j=i+1;j<input.length();j++) {
                if(input.charAt(i)==input.charAt(j)) {
                    System.out.println("The repeated char is : "+input.charAt(i));
                    return false;
                }
            }
        }
        return true;
    }
}


public class UniqueCharacterString {

    UniqueCharactersFinder timeSavinvUniqueCharactersFinder=null;
    UniqueCharactersFinder spaceSavinvUniqueCharactersFinder=null;

    public void setTimeSavinvUniqueCharactersFinder(UniqueCharactersFinder uniqueCharactersFinder) {
        this.timeSavinvUniqueCharactersFinder = uniqueCharactersFinder;
    }

    public void setSpaceSavingUniqueCharactersFinder(UniqueCharactersFinder uniqueCharactersFinder) {
        this.spaceSavinvUniqueCharactersFinder = uniqueCharactersFinder;
    }

    public UniqueCharactersFinder getTimeSavinvUniqueCharactersFinder() {
        return timeSavinvUniqueCharactersFinder;
    }

    public UniqueCharactersFinder getSpaceSavinvUniqueCharactersFinder() {
        return spaceSavinvUniqueCharactersFinder;
    }

    public static void main(String ...args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Please enter the string : ");
        String input=sc.nextLine();
        UniqueCharacterString usc=new UniqueCharacterString();
        SpaceSavingUniqueCharactersFinder spaceSavingUniqueCharactersFinder=new SpaceSavingUniqueCharactersFinder();
        TimeSavingUniqueCharactersFinder timeSavingUniqueCharactersFinder = new TimeSavingUniqueCharactersFinder();

        usc.setSpaceSavingUniqueCharactersFinder(spaceSavingUniqueCharactersFinder);
        usc.setTimeSavinvUniqueCharactersFinder(timeSavingUniqueCharactersFinder);

        System.out.println("TimeSaving Unique : "+usc.getTimeSavinvUniqueCharactersFinder().isCharactersUnique(input));
        System.out.println("SpaceSaving Unique : "+usc.getSpaceSavinvUniqueCharactersFinder().isCharactersUnique(input));

    }
}
