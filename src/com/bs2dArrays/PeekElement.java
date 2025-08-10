package com.bs2dArrays;

import java.util.Arrays;

public class PeekElement {

	public static void main(String[] args) {
		/*
		 * A peak element in a 2D grid is an element that is strictly greater than all
		 * of its adjacent neighbors to the left, right, top, and bottom.
		 * 
		 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal,
		 * find any peak element mat[i][j] and return the length 2 array [i,j].
		 * 
		 * You may assume that the entire matrix is surrounded by an outer perimeter
		 * with the value -1 in each cell.
		 * 
		 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
		 */
		PeekElement element = new PeekElement();
		int[][] mat = {{1,4},{3,2}};
		System.out.println(Arrays.toString(element.findPeakGrid(mat)));
	}
	
	public int[] findPeakGrid(int[][] mat) {
        int m =  mat[0].length;

        int low = 0;
        int high = m-1;

        while(low<=high){
            int mid = (low+high)/2;
            int row = maxRow(mat,mid);

            int left = mid-1>=0 ? mat[row][mid-1] : -1;
            int right = mid+1<m ? mat[row][mid+1] : -1;

            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[] {row,mid};
            }else if(mat[row][mid]<left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[] {-1,-1};
    }

    public int maxRow(int[][] mat, int col){
        int maxValRow = -1;
        int maxRow = -1;
        int row = 0;

        while(row<mat.length){
            if(mat[row][col] > maxValRow){
                maxValRow = mat[row][col];
                maxRow = row;
            }
            row++;
        }
        return maxRow;
    }
	
	

}
