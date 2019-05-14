package edu.learn.java.ds.common;

import java.util.Scanner;

/**
 * Created by edwin on 13/09/16.
 */
public class Matrix {

    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    private int[][] data;

    public Matrix(int row, int col) {
        this.row=row;
        this.col=col;
        this.data = new int[row][col];
    }

    public void setCellData(int row,int col, int value) {
        data[row][col] = value;
    }

    public int getCellData(int row, int col) {
        return data[row][col];
    }

    public void getDataFromConsole() {
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.printf("\nPlease enter value of data[%d][%d] :",i,j);
                data[i][j]=sc.nextInt();
            }
        }
    }

    private String getSpace(int value)
    {
        if(value>=0 && value<10)
        {
            return "    ";
        }
        else if(value>=10 && value<=99)
        {
            return "   ";
        }
        else if(value>=100 && value<=999)
        {
            return "  ";
        }
        return " ";
    }

    public void printMatrix() {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.printf("%d"+getSpace(data[i][j]),data[i][j]);
            }
            System.out.println();
        }
    }
}
