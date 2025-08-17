	package com.easy;

public class SearchInRotatedSortedArray1 {

	public static void main(String[] args) {
		/*
		 * Given an integer array nums, sorted in ascending order (with distinct values)
		 * and a target value k. The array is rotated at some pivot point that is
		 * unknown. Find the index at which k is present and if k is not present return
		 * -1
		 */
		SearchInRotatedSortedArray1 searchInRotatedSortedArray = new SearchInRotatedSortedArray1();
		
		int[] nums = {43,45,50,51,62,66,86,89,90,92,98,-96,-95,-88,-86,-84,-79,-73,-34,-32,-13,-7,-1,6,16,31,38,42};
		
		System.out.println(searchInRotatedSortedArray.search(nums, -32));
		
	}

	public int search(int[] nums, int target) {
		int low =0, high =nums.length-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			
			if(nums[mid]==target) {
				return mid;
			}
			
			if(nums[low]<=nums[mid]) {
				if(nums[low]<=target && target<=nums[mid]) {
					high = mid-1;
				}else {
					low = mid+1;
				}
			}else {
				if(nums[mid]<=target && target<=nums[high]) {
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
		}
		return -1;
	}

}
