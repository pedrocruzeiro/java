/* Online Java Compiler and Editor */
import java.util.*;
public class Main{

    public static void main(String []args){
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } , {7,8,9} };
        List<Integer> list = Arrays.asList(1, 4, 8);
        System.out.println(checkContainsList(matrix,list));
    }

    public static boolean checkContainsList(int[][] matrix, List<Integer> list){

        int dimension = matrix.length;

        List<Integer> tempRow;
        List<Integer> tempColumn;

        for (int i = 0; i < dimension; i++) {
            tempRow = new ArrayList<>();
            tempColumn = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                tempRow.add(matrix[i][j]);
                tempColumn.add(matrix[j][i]);
            }
            System.out.println(tempRow);
            System.out.println(tempColumn);

            if(tempRow.containsAll(list)) return true;
            if(tempColumn.containsAll(list)) return true;

        }

        return false;
    }

}