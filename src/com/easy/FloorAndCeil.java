package com.easy;

import java.util.Arrays;

public class FloorAndCeil {

	public static void main(String[] args) {
		
		/*
		 * Given a sorted array nums and an integer x. Find the floor and ceil of x in
		 * nums. The floor of x is the largest element in the array which is smaller
		 * than or equal to x. The ceiling of x is the smallest element in the array
		 * greater than or equal to x. If no floor or ceil exists, output -1.
		 */
		FloorAndCeil fc = new FloorAndCeil();
		int[] nums = {3, 4, 4, 7, 8, 10}; 
		int x= 5;
		System.out.println(Arrays.toString(fc.floorAndCeil(nums, x)));// Output: 4 7
		
		nums = new int[] {3, 3, 3, 3, 3, 3, 3};
		x = 4;
		System.out.println(Arrays.toString(fc.floorAndCeil(nums, x)));// Output: 3 -1
		
		nums = new int[] {3, 4, 4, 7, 8, 10};
		x = 8;
		System.out.println(Arrays.toString(fc.floorAndCeil(nums, x)));// Output: 8 8
		
		nums = new int[] {10, 20, 30, 40, 50};
		x = 25;
		System.out.println(Arrays.toString(fc.floorAndCeil(nums, x)));// Output: 20 30
		
	}
	
	public int[] floorAndCeil(int[] nums,int x) {
		int low = 0, high = nums.length-1;
		int floor = -1, ceil =-1;
		
		while(low<=high) {
			int mid = low + (high - low)/2;
			if(nums[mid]==x) {
				floor = nums[mid];
				ceil = nums[mid];
				break;
			}else if(nums[mid]>=x){
				ceil = nums[mid];
				high = mid -1;
			}else {
				floor = nums[mid];
				low = mid + 1;
			}
		}
		
		return new int[] {floor,ceil};
	}

}
