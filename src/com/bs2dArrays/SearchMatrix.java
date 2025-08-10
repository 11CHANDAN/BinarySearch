package com.bs2dArrays;

public class SearchMatrix {

	public static void main(String[] args) {

		/*
		 * You are given an m x n integer matrix matrix with the following two
		 * properties:
		 * 
		 * Each row is sorted in non-decreasing order. The first integer of each row is
		 * greater than the last integer of the previous row.
		 * 
		 * Given an integer target, return true if target is in matrix or false
		 * otherwise.
		 * 
		 * You must write a solution in O(log(m * n)) time complexity.
		 */

		SearchMatrix searchMatrix = new SearchMatrix();
		int[][] matrix = {{1}};
		System.out.println(searchMatrix.searchMatrix(matrix, 1));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;

		int low =0 , high = (m*n-1);

		while(low<=high) {
			int mid = (low+high)/2;

			int row = mid/m;
			int column = mid%m;

			if(matrix[row][column] == target) {
				return true;
			}else if(matrix[row][column]>target) {
				high = mid-1;
			}else {
				low =mid+1;
			}
		}
		return false;
	}

}
