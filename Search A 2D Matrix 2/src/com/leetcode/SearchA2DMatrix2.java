package com.leetcode;

public class SearchA2DMatrix2 {
	
	/*Write an efficient algorithm that searches for a value target in 
	 * an m x n integer matrix matrix. This matrix has the following 
	 * properties:Integers in each row are sorted in ascending from left 
	 * to right.Integers in each column are sorted in ascending from top to bottom.
	 */

	public static void main(String[] args) {
		int[][] a = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int tar = 5;
		
		System.out.println(searchMatrix(a, tar));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i<matrix.length; i++){ //Iterates through both levels of the array
            
            for (int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == target){ //If the target is found returns true
                    return true;
                }
            }
        }
        return false;
    }

}
