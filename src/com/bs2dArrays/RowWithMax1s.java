package com.bs2dArrays;

import java.util.ArrayList;

public class RowWithMax1s {

	public static void main(String[] args) {
		/*
		 * Given a non-empty grid mat consisting of only 0s and 1s, where all the rows
		 * are sorted in ascending order, find the index of the row with the maximum
		 * number of ones.
		 * 
		 * If two rows have the same number of ones, consider the one with a smaller
		 * index. If no 1 exists in the matrix, return -1.
		 */
		RowWithMax1s max1s = new RowWithMax1s();
		int[][] mat = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
		
		System.out.println(max1s.rowWithMax1s(mat,3,3));
	}

	public int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
	
    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }



}
