package com.easy;

public class FindMinimumInRotatedSortetArray2 {

	public static void main(String[] args) {
		
		/*
		 * Suppose an array of length n sorted in ascending order is rotated between 1
		 * and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
		 * 
		 * [4,5,6,7,0,1,4] if it was rotated 4 times. [0,1,4,4,5,6,7] if it was rotated
		 * 7 times.
		 * 
		 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
		 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
		 * 
		 * Given the sorted rotated array nums that may contain duplicates, return the
		 * minimum element of this array.
		 * 
		 * You must decrease the overall operation steps as much as possible.
		 */
		
		FindMinimumInRotatedSortetArray2 rotatedSortetArray2 = new FindMinimumInRotatedSortetArray2();
		
		int[] nums = {3,1,2,3,3,3,3,3};
		System.out.println(rotatedSortetArray2.findMin(nums));

	}
	
	public int findMin(int[] nums) {
		int low = 0,high = nums.length-1;
		int ans = Integer.MAX_VALUE;
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			
			if(nums[low] == nums[high]) {
				ans = Math.min(ans, nums[low]);
				low +=1;
				high -=1;
			}else if(nums[low]<=nums[mid]) {
				ans = Math.min(ans, nums[low]);
				low = mid+1;
			}else {
				ans = Math.min(ans, nums[mid]);
				high = mid-1;
			}
		}
		return ans;
	}

}
