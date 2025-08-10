package com.medium;

public class FindTheSmallestDivisor {

	public static void main(String[] args) {
		
		/*
		 * Given an array of integers nums and an integer limit as the threshold value,
		 * find the smallest positive integer divisor such that upon dividing all the
		 * elements of the array by this divisor, the sum of the division results is
		 * less than or equal to the threshold value.
		 * 
		 * Each result of the division is rounded up to the nearest integer greater than
		 * or equal to that element.
		 */
		
		FindTheSmallestDivisor smallestDivisor = new FindTheSmallestDivisor();
		
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(smallestDivisor.smallestDivisor(nums, 8));
	}
	
	public int smallestDivisor(int[] nums, int limit) {
		int low = 1;
		int high = findMax(nums);
		
		while(low<=high) {
			int mid = (low + high)/2;
			if(calculateTotalHrs(nums, limit, mid)) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return low;
    }
	
	public boolean calculateTotalHrs(int[] nums,int limit,int divisor) {
		int total =0;
		for(int i=0;i<nums.length;i++) {
			 total += nums[i]/divisor;
			 if(nums[i]%divisor!=0) {
				 total++;
			 }
		}
		
		if(total<=limit) {
			return true;
		}
		return false;
	}
	
	public int findMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max) {
				max = nums[i];
			}
		}
		return max;
	}

}
