package edu.learn.java.ds.dynamic;

public class ZeroOneKnapSack
{
    public int[][] compute(int[] values, int[] weight, int maxWeight)
    {
        int result[][] = new int[values.length+1][maxWeight+1];
        for(int i=0;i<=values.length;i++)
        {
            for(int j=0;j<=maxWeight;j++)
            {
                if(i==0 || j==0)
                {
                    result[i][j] = 0;
                    continue;
                }
                if(j - weight[i-1] >=0)
                {
                    result[i][j] = Math.max(result[i-1][j], result[i-1][j-weight[i-1]] + values[i-1]);
                }
                else
                {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        printMatrix(result);

        return result;
    }

    private void printMatrix(int[][] result)
    {
        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<result[0].length;j++)
            {
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private void findCombinations(int[][] matrix, int[] values, int[] weight, int maxWeight)
    {
        int result = matrix[matrix.length-1][maxWeight];
        System.out.println("Value of Result : "+result+" maxWeight - "+maxWeight);
        int w = maxWeight;
        for(int i=values.length;i>0 && w>0; i--)
        {
            if(result==matrix[i-1][w])
            {
                continue;
            }
            else
            {
                System.out.println("Item with weight included : "+weight[i-1]);
                result = result - values[i-1];
                w = w - weight[i-1];
            }
        }
    }

    public static void main(String ...args)
    {
        ZeroOneKnapSack zoks = new ZeroOneKnapSack();
        int[] values = {1,2,5,6};
        int[] weight = {2,3,4,5};
        int[][] matrix = zoks.compute(values, weight, 8);
        zoks.findCombinations(matrix, values, weight, 8);
    }
}