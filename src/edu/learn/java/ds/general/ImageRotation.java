package edu.learn.java.ds.general;

import java.util.Scanner;

public class ImageRotation
{

    //Number of layers = n / 2; number of boxes

    private void rotate(int[][] matrix, int n)
    {
        for (int layer = 0; layer < (n / 2); layer++)
        {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++)
            {
                int offset = i - first;
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }

    private void printMatrix(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        ImageRotation ir = new ImageRotation();
        int row,col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        row = scanner.nextInt();
        System.out.println("Enter the number of columns : ");
        col = scanner.nextInt();

        int[][] matrix = new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.println("Enter value for ["+i+"]["+j+"]");
                matrix[i][j] = scanner.nextInt();
            }
        }
        ir.printMatrix(matrix);
        ir.rotate(matrix, 2);
        ir.printMatrix(matrix);
    }
}