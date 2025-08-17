	package com.easy;

public class LowerBound {

	public static void main(String[] args) {
		/*
		 * Given a sorted array of nums and an integer x, write a program to find the
		 * lower bound of x.
		 * 
		 * 
		 * The lower bound algorithm finds the first and smallest index in a sorted
		 * array where the value at that index is greater than or equal to a given key
		 * i.e. x.
		 * 
		 * 
		 * If no such index is found, return the size of the array.
		 */
		LowerBound bound = new LowerBound();

		int[] nums= {3,5,8,15,19};
		int x = 9;

		System.out.println(bound.lowerBound(nums, x));

		nums= new int[]{1,2,2,3};
		x = 2;

		System.out.println(bound.lowerBound(nums, x));
		System.out.println(bound.lowerBound(nums, 4));

		nums = new int[] {1, 3, 3, 5, 7};
		x = 3 ;
		System.out.println(bound.lowerBound(nums, x));
		
		nums = new int[] {3, 3, 3, 5, 7};
		x = 3 ;
		System.out.println(bound.lowerBound(nums, x));

	}

	public int lowerBound(int[] nums, int x) {
		int low = 0;
		int high = nums.length -1;
		int ans = high+1;

		while(low<=high) {
			int mid = low + (high-low)/2;
			
			if(nums[mid] >= x) {
				ans = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}

		return ans;
	}

}
