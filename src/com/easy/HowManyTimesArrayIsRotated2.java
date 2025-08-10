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
	
	public int findKRotation(int[] nums) {
		int low =0;
		int high =nums.length-1;
		int minIdx = 0;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if(nums[low] == nums[mid] && nums[mid]==nums[high]) {
				if(nums[low]<nums[minIdx]) {
					minIdx = low;
				}
				low+=1;
				high-=1;
			}else if(nums[low]<=nums[mid]) {
				if(nums[low]<nums[minIdx]) {
					minIdx = low;
				}
				low=mid+1;
			}else {
				if(nums[mid]<nums[minIdx]) {
					minIdx = mid;
				}
				high=mid-1;
			}
		}
		
		return minIdx;
		
	}

}
