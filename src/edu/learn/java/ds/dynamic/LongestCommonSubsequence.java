package edu.learn.java.ds.dynamic;

import java.util.Scanner;

/**
 * Created by edwin on 10/09/16.
 */
public class LongestCommonSubsequence {

    private enum Arrow { L, U, D, N } ;

    class MatrixEntry {
        public int length;
        public Arrow direction;

        public MatrixEntry() {
            length=0;
            direction=Arrow.N;
        }
    }

    MatrixEntry[][] matrix=null;
    String rowChars=null;
    String colChars=null;


    public static void main(String ...args) {

        LongestCommonSubsequence lcs=new LongestCommonSubsequence();

        Scanner input=new Scanner(System.in);
        int row=0, col=0;


        System.out.print("Enter the first string e.g. (ABCDEFGH) : ");
        lcs.rowChars=input.next();

        System.out.print("Enter the second string e.g. (ABCDEFGH) : ");
        lcs.colChars=input.next();

        row=lcs.rowChars.length();
        col=lcs.colChars.length();

        System.out.println(" Length of the first string : "+row);
        System.out.println(" Length of the second string : "+col);

        lcs.matrix = new MatrixEntry[row+1][col+1];

        System.out.println("Length of matrix Rows : "+lcs.matrix.length);

        lcs.computeLength(lcs.matrix,lcs.rowChars,lcs.colChars);
        lcs.printLCS(lcs.matrix,lcs.rowChars.length(),lcs.colChars.length());

    }

    public void computeLength(MatrixEntry[][] matrix, String rows, String columns) {

        // Populate 1st column of all rows with 0
        for(int i=0;i<=rows.length();i++) {
            System.out.println("Row : "+i);
            matrix[i][0]=new MatrixEntry();
            matrix[i][0].length=0;
        }

        // Populate 1st row of all cols with 0
        for(int i=0;i<=columns.length();i++) {
            System.out.println("Column : "+i);
            matrix[0][i]=new MatrixEntry();
            matrix[0][i].length=0;
        }

        for(int i=1;i<=rows.length();i++) {
            for(int j=1;j<=columns.length();j++) {
                matrix[i][j]=new MatrixEntry();
                // If row and column character match, then take the low diagnol and add 1 to it.
                if(rows.charAt(i-1)==columns.charAt(j-1)) {
                    matrix[i][j].length = matrix[i-1][j-1].length+1;
                    matrix[i][j].direction = Arrow.D;
                }
                else if(matrix[i-1][j].length>=matrix[i][j-1].length) {

                    matrix[i][j].length = matrix[i-1][j].length;
                    matrix[i][j].direction = Arrow.U;
                }
                else {
                    matrix[i][j].length = matrix[i][j-1].length;
                    matrix[i][j].direction = Arrow.L;
                }
            }
        }

        for(int i=0;i<=rows.length();i++) {
            for (int j = 0; j<=columns.length(); j++) {

                //System.out.printf("%d=",i,j);
                System.out.printf("%d  ",matrix[i][j].length);
                /*
                System.out.printf("[%d][%d]=",i,j);
                System.out.printf("%d,%s",matrix[i][j].length,matrix[i][j].direction);
                */
            }
            System.out.println();
        }

    }

    public void printLCS(MatrixEntry[][] matrix, int r, int c) {
        if(r==0 || c==0) {
            return;
        }
        if(matrix[r][c].direction==Arrow.D) {
            printLCS(matrix,r-1,c-1);
            System.out.println(rowChars.charAt(r-1));
        }
        else if(matrix[r][c].direction == Arrow.U) {
            printLCS(matrix,r-1,c);
        }
        else {
            printLCS(matrix,r,c-1);
        }
    }
}


/*

Steps
1. Create a MatrixEntry with length & direction.
Compute Length Method.
2. Initialize the first row & column of array with 0 length & arrow Neutral
3. if(char in row & column matches ) then arrow is DOWN, length is previous row,col val + 1
4. if(prev row length > prev col length ) then  arrow is up current length is prev row length
5. if (prev col length > prev row length  then arrow is left & current length is prev col length.

PrintLCS Method.
printLCS(Matrix[][], int row, int col)
    if(matrix[row][col].direction==D)
        printLCS(matrix, row-1,col-1);
        print charAt row.
    else if(matrix[row][col].direction==UP)
        printLCS(matrix,row-1,col);
    else if(matrix[row][col].direction==LEFT)


 */