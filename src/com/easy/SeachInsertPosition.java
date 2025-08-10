package com.easy;

public class SeachInsertPosition {

	public static void main(String[] args) {
		/*
		 * Given a sorted array of nums consisting of distinct integers and a target
		 * value, return the index if the target is found. If not, return the index
		 * where it would be if it were inserted in order.
		 */
		SeachInsertPosition position = new SeachInsertPosition();
		int[] nums = {1, 3, 5, 6};
		int target = 5;
		System.out.println(position.insertPosition(nums, target));
		//Output: 2
		
		nums = new int[] {1, 3, 5, 6};
		target = 2;
		System.out.println(position.insertPosition(nums, target));
		//Output: 1
		
		nums = new int[] {};
		target = 5;
		System.out.println(position.insertPosition(nums, target));
		
		//output: 0
		
		nums = new int[]{10, 20, 30};
		target = 5;
		System.out.println(position.insertPosition(nums, target));
		//output: 0
	}

	public int insertPosition(int[] nums,int target) {
		
		if(nums.length >0 && target > nums[nums.length-1]) {
			return nums.length;
		}
		
		int low =0,
			high = nums.length-1,
			ans =0;

		while(low<=high) {
			int mid = low + (high-low)/2;
			if(nums[mid]>=target) {
				ans = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}

		}
		
		return low;
	}

}
