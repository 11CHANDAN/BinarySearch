 package com.easy;

import java.util.Arrays;

public class FirstAndLastOccurence {

	public static void main(String[] args) {
		
		/*
		 * Given an array of integers nums sorted in non-decreasing order, find the
		 * starting and ending position of a given target value. If the target is not
		 * found in the array, return [-1, -1].
		 */
		FirstAndLastOccurence occurence = new FirstAndLastOccurence();
		
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] ans = {occurence.firstOccurence(nums, 8),occurence.lastOccurence(nums, 8)};
		System.out.println(Arrays.toString(ans));
	}

	 public int firstOccurence(int[] nums,int target) {
			int low = 0, 
					high = nums.length-1, 
					ans = -1;

			while(low<=high) {
				int mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                ans = mid;
	                high = mid -1;
	            }else if(nums[mid] > target) {
					high = mid-1;
				}else{
					low = mid +1;
				}
			}
			return ans;
		}

		public int lastOccurence(int[] nums,int target) {
			int low = 0, 
					high = nums.length-1, 
					ans = -1;

			while(low<=high) {
				int mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                ans = mid;
	                low = mid+1;
	            }else if(nums[mid] > target) {
					high = mid-1;
				}else{
					low = mid +1;
				}
			}
			return ans;
		}


}
