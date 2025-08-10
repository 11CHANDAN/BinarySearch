package com.easy;

public class HowManyTimesArrayIsRotated1 {

	public static void main(String[] args) {

		/*
		 * Given an integer array nums of size n, sorted in ascending order with
		 * distinct values. The array has been right rotated an unknown number of times,
		 * between 0 and n-1 (including). Determine the number of rotations performed on
		 * the array.
		 */
		HowManyTimesArrayIsRotated1 arrayIsRotated = new HowManyTimesArrayIsRotated1();

		int[] nums = {4, 5, 6, 7, 0, 1, 2, 3}; //Output: 4
		System.out.println(arrayIsRotated.findKRotation(nums));

		nums = new int[]{3, 4, 5, 1, 2}; //Output: 3
		System.out.println(arrayIsRotated.findKRotation(nums));

		nums = new int[] {7,8,1,2,3,4,5,6}; //Output: 2
		System.out.println(arrayIsRotated.findKRotation(nums));
	}

	public int findKRotation(int[] nums) {
		int low = 0;
		int high = nums.length -1;
		int minIdx = -1;

		while(low<=high) {
			int mid = low+(high-low)/2;

			if(nums[low]<=nums[high]) {
				return low;
			}else if(nums[low]<=nums[mid]) {
				minIdx = low;
				low = mid+1;
			}else {
				minIdx = mid;
				high = mid-1;
			}
		}

		return minIdx;

	}

}
