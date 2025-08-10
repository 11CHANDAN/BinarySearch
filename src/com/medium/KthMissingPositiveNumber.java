package com.medium;

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		/*
		 * Given an array arr of positive integers sorted in a strictly increasing
		 * order, and an integer k.
		 * 
		 * Return the kth positive integer that is missing from this array.
		 */
		KthMissingPositiveNumber missingPositiveNumber = new KthMissingPositiveNumber();
//		int[] nums = {2,3,4,7,11};
		int[] nums = {1,2,3,4};
		System.out.println(missingPositiveNumber.findKthPositive(nums, 2));
		
	}

	public int findKthPositive(int[] arr, int k) {
		int low =0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			
			int missing = arr[mid] - (mid+1);
			if(missing<k) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return low + k;
	}

}
