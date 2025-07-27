package com.easy;

public class FindMinimumInRotatedSortetArray1 {

	public static void main(String[] args) {

		/*
		 * Given an integer array nums of size N, sorted in ascending order with
		 * distinct values, and then rotated an unknown number of times (between 1 and
		 * N), find the minimum element in the array.
		 */
		FindMinimumInRotatedSortetArray1 rotatedSortetArray = new FindMinimumInRotatedSortetArray1();
		int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
		System.out.println(rotatedSortetArray.findMin(nums));//Output: 0

		nums = new int[] {3,4,5,1,2};
		System.out.println(rotatedSortetArray.findMin(nums));//Output: 1

		nums = new int[] {7,8,1,2,3,4,5,6};
		System.out.println(rotatedSortetArray.findMin(nums));//Output: 1

	}

	public int findMin(int[] nums) {
		int low =0, high =nums.length-1;
		int ans = Integer.MAX_VALUE;

		while(low<=high) {
			int mid = low + (high-low)/2;

			if(nums[low]<=nums[high]){
				ans = Math.min(ans, nums[low]);
				break;
			}else if(nums[low]<nums[mid]) {
				ans = Math.min(ans, nums[low]);
				low = mid+1;
			}else {
				ans =  Math.min(ans, nums[mid]);
				high = mid -1;
			}
		}
		return ans;
	}

}
