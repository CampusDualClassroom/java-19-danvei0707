package com.campusdual.classroom;

import com.campusdual.util.Utils;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }
//
    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri); //  Array is being flatten
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        // Para sacar las profundidades de las otras dimensiones usar lo siguiente
        //      intArrayTri.length  ---> Depth
        //      intArrayTri[0].length  ---> Rows
        //      intArrayTri[0][0].length  ---> Columns
        // (Según la estructura de este array)
        int[][] flattenedArray = new int[intArrayTri[0].length][intArrayTri[0][0].length];
        for (int i = 0; i < intArrayTri[0].length; i++) { // For each row
            for (int j = 0; j < intArrayTri[0][0].length; j++) { // For each column
                for (int k = 0; k < intArrayTri.length; k++) { // For each layer (depth)
                    // Sum all the values for the same position in terms of rows/columns
                    flattenedArray[i][j] += intArrayTri[k][i][j];
                }
            }
        }
        return flattenedArray;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        // BidimensionalArray.length devuelve el número de filas (rows)
        for (int i = 0; i < intArrayBi.length; i++) {
            if (i != 0) sb.append("\n");
            sb.append(stringFlatMatrixRow(intArrayBi, i));
        }
        return sb.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if (i != 0) sb.append(" ");
            sb.append(uniArray[i]);
        }
        return sb.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] randomArray = new int[columns];
        int testValue = 0;
        for (int i = 0; i < columns; i++) {
            randomArray[i] = ++testValue;
        }
        return randomArray;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] randomArray = new int[rows][columns];
        int testValue = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomArray[i][j] = ++testValue;
            }
        }
        return randomArray;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int [][][] randomArray = new int[depth][rows][columns];
        int testValue = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    randomArray[i][j][k] = ++testValue;
                }
            }
        }
        return randomArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 4, 5);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
