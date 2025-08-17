package com.easy;

public class HowManyTimesArrayIsRotated2 {

	public static void main(String[] args) {
		/*
		 * Given an integer array nums of size n, sorted in ascending order with
		 * duplicate values. The array has been right rotated an unknown number of times,
		 * between 0 and n-1 (including). Determine the number of rotations performed on
		 * the array.
		 */
		HowManyTimesArrayIsRotated2 arrayIsRotated2 = new HowManyTimesArrayIsRotated2();
		int[] nums = {3,1,2,3,3,3,3,3};
		System.out.println(arrayIsRotated2.findKRotation(nums));
		
		nums = new int[]{2, 2, 2, 0, 1};
		System.out.println(arrayIsRotated2.findKRotation(nums));
		
		nums = new int[]{3, 4, 5, 1, 2};
		System.out.println(arrayIsRotated2.findKRotation(nums));
		
		nums = new int[]{2, 2, 2, 2, 1, 2};
		System.out.println(arrayIsRotated2.findKRotation(nums));
	}
	
	public int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] < arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            } else if(arr[low] == arr[high]) {
            	if(arr[low] < ans) {
            		index = low;
            		ans = arr[low];
            	}
            	low += 1;
            	high -= 1;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

}
