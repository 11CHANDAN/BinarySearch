package com.easy;

public class BinarySearch {

	public static void main(String[] args) {
		
		/*
		 * Given a sorted array of integers nums with 0-based indexing, find the index
		 * of a specified target integer. If the target is found in the array, return
		 * its index. If the target is not found, return -1.
		 */
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(binarySearch(nums, 9));
		System.out.println(recussiveBS(nums, 9, 0, nums.length-1));
		
		System.out.println(binarySearch(nums, 2));
		System.out.println(recussiveBS(nums, 2, 0, nums.length-1));
		
		System.out.println(binarySearch(nums, 12));
		System.out.println(recussiveBS(nums, 12, 0, nums.length-1));
	}
	
	public static int binarySearch(int[] nums,int target) {
		int low = 0;
		int high = nums.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(target > nums[mid]) {
				low = mid+1;
			}else {
				high = mid -1;
			}
		}
		
		return -1;
	}
	
	public static int recussiveBS(int[] nums,int target,int low,int high) {
		if(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(target > nums[mid]) {
				return recussiveBS(nums, target, mid+1, high);
			}else {
				return recussiveBS(nums, target, low, mid-1);
			}
		}
		return -1;
	}

}
