package com.easy;

public class UpperBound {

	public static void main(String[] args) {
		/*
		 * Given a sorted array of nums and an integer x, write a program to find the
		 * upper bound of x.
		 * 
		 * 
		 * The upper bound algorithm finds the first and smallest index in a sorted
		 * array where the value at that index is greater than a given key i.e. x.
		 * 
		 * 
		 * If no such index is found, return the size of the array.
		 */
		UpperBound bound = new UpperBound();
		int[] nums = {1,2,2,3};
		int x = 2;
		System.out.println(bound.upperBound(nums, x));
		
		nums = new int[] {3,5,8,15,19};
		x = 9;
		System.out.println(bound.upperBound(nums, x));
	}
	
	public int upperBound(int[] nums,int x) {
		int low =0;
		int high = nums.length-1;
		int ans = nums.length;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]>x) {
				ans = mid;
				high = mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return ans;
	}

}
