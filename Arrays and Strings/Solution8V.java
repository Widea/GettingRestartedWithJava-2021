import java.util.Arrays;

/**
 * Problem statement:
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */

public class Solution8V {
    private static Integer[][] setZero(Integer[][] input) {

        if(input == null ) {
            return null;
        }

        int m = input.length;
        int n = input[0].length;

        Boolean[] rows = new Boolean[m];
        Boolean[] columns = new Boolean[n];

        Arrays.fill(rows, false);
        Arrays.fill(columns, false);

        if(input == null) {
            return null;
        }

        for(int i = 0; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(input[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(rows[i] || columns[j]) {
                    input[i][j] = 0;
                }
            }
        }

        return input;
    }

    private static void printOutput(Integer[][] input) {
        if(input == null) {
            System.out.println("Invalid input");
            return;
        }
        int m = input.length; int n = input[0].length;
        printMatrix("Given input: ", input, m, n);
        printMatrix("Output: ", setZero(input), m, n);
    }

    private static void printMatrix(String statement, Integer[][] input, int m, int n) {
        System.out.print('\n' + statement);
        for(int i = 0; i < m ; i++) {
            System.out.println();
            for(int j = 0; j < n ; j++) {
                System.out.print(input[i][j] + "   ");
            }
        }
    }

    public static void main(String args[]) {
        Integer[][] inputArr = {{1, 2, 3, 46, 3}, {0,5,6, 56, 8}, {7, 8, 0, 4, 9}};
        printOutput(inputArr);
    }
}
