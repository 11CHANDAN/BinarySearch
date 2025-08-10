package com.easy;

public class FindPeakElement {
	
	public static void main(String[] args) {
		
		/*
		 * Given an array arr of integers. A peak element is defined as an element
		 * greater than both of its neighbors.
		 * 
		 * Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] <
		 * arr[i].
		 * 
		 * Find the index(0-based) of a peak element in the array. If there are multiple
		 * peak numbers, return the index of any peak number.
		 * 
		 * Note:
		 * 
		 * As there can be many peak values, 1 is given as output if the returned index
		 * is a peak number, otherwise 0.
		 */
		
		FindPeakElement findPeakElement = new FindPeakElement();
		
		int[] nums = {1,2,3,1};
		System.out.println(findPeakElement.findPeakElement(nums));
	}
	
	 public int findPeakElement(int[] nums) {
	        int n = nums.length;

	        if(n==1) return 0;
	        if(nums[0]>nums[1]) return 0;
	        if(nums[n-1]>nums[n-2]) return n-1;

	        int low = 1,high = n-2;

	        while(low<=high){
	            int mid = (low + high)/2;
	            if(nums[mid-1]<nums[mid]
	                    && nums[mid]>nums[mid+1]){
	                return mid;
	            }else if(nums[mid-1]<nums[mid]){
	                low = mid+1;
	            }else{
	                high = mid-1;
	            }
	        }

	        return -1;
	    }

}
