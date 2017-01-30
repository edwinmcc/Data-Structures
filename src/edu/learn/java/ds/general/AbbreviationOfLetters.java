package edu.learn.java.ds.general;

import java.util.Scanner;

/**
 * Created by edwin on 29/01/17.
 */
public class AbbreviationOfLetters {

    /*

    Abbreviation
You	can	perform	the	following	operation	on	some	string,	 :
1.	 Capitalize	zero	or	more	of	 's	lowercase	letters	at	some	index	i	(i.e.,	make	them	uppercase).
2.	 Delete	all	of	the	remaining	lowercase	letters	in	 .
Given	 	queries	in	the	form	of	two	strings,	 	and	 ,	determine	if	it's	possible	to	make	 	equal	to	 	by
performing	the	above	operation	on	 .	If	 	can	be	transformed	into	 ,	print	 YES 	on	a	new	line;	otherwise,
print	 NO .
Input	Format
The	first	line	contains	a	single	integer,	 ,	denoting	the	number	of	queries.	The
each	query	in	the	following	format:
	subsequent	lines	describe
1.	 The	first	line	of	each	query	contains	a	single	string,	 .
2.	 The	second	line	of	each	query	contains	a	single	string,	 .
Constraints
String	 	consists	only	of	uppercase	and	lowercase	English	letters.
String	 	consists	only	of	uppercase	English	letters.
Output	Format
For	each	query,	print	 YES 	on	a	new	line	if	it's	possible	to	make	string	 	equal	to	string	 	by	performing	the
operation	specified	above;	otherwise,	print	 NO .
Sample	Input
1
daBcd
ABC
Sample	Output
YES
Explanation
We	have
	 daBcd 	and
	 ABC .	We	perform	the	following	operation:
1.	 Capitalize	the	letters	 a 	and	 c 	in	 	so	that
	 dABCd .
2.	 Delete	all	the	remaining	lowercase	letters	in	 	so	that
	 ABC .
Because	we	were	able	to	successfully	convert	 	to	 ,	we	print	 YES 	on	a	new	line.
     */


    public static boolean isStringFound(String s1, String s2) {

        boolean found=false;
        for(int i=0;i<s2.length();i++) {
            char c=s2.toLowerCase().charAt(i);
            if(!found) {
                for (int j = 0; j < s1.length(); j++) {
                    if(s1.charAt(j) ==c) {
                        found = true;
                    }
                }
            }
        }
        return found && s1.toUpperCase().contains(s2);
    }

    public static void main(String ...args) {
        Scanner scanner=new Scanner(System.in);
        int q = scanner.nextInt();

        String s1[] = new String[q];
        String s2[] = new String[q];

        for(int i=0;i<q;i++) {
            s1[i] = scanner.next();
            s2[i] = scanner.next();
        }

        for(int i=0;i<q;i++) {
            System.out.println((isStringFound(s1[i],s2[i]))?"YES":"NO");
        }

    }

}
