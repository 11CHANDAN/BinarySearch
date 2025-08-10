package com.medium;

import java.util.Arrays;

public class BookAllocationProblem {

	public static void main(String[] args) {
		/*
		 * Given an array nums of n integers, where nums[i] represents the number of
		 * pages in the i-th book, and an integer m representing the number of students,
		 * allocate all the books to the students so that each student gets at least one
		 * book, each book is allocated to only one student, and the allocation is
		 * contiguous.
		 * 
		 * 
		 * Allocate the books to m students in such a way that the maximum number of
		 * pages assigned to a student is minimized. If the allocation of books is not
		 * possible, return -1.
		 */
		BookAllocationProblem bookAllocationProblem = new BookAllocationProblem();
		
		int[] nums = {12, 34, 67, 90};  
		System.out.println(bookAllocationProblem.findPages(nums, 2));
		
		nums = new int[] {25, 46, 28, 49, 24};
		System.out.println(bookAllocationProblem.findPages(nums, 4));
	}
	
	public int findPages(int[] nums, int m) {
		
		if(nums.length < m) {
			return -1;
		}
		
		int[] maxAndSum = findSumAndMax(nums);
		int low = maxAndSum[0], high = maxAndSum[1];
		
//		//linear search
//		for(int i=low;i<=high;i++) {
//			int students = allocatePages(nums, i);
//			if(students == m) {
//				return i;
//			}
//		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			int students = allocatePages(nums, mid);
			if(students <= m) {
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		
		return low;
    }
	
	public int allocatePages(int[] nums,int pages) {
		int students = 1;
		int pageStudent = 0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]+pageStudent <= pages) {
				pageStudent += nums[i];
			}else {
				students++;
				pageStudent = nums[i];
			}
		}
		return students;
	}
	
	public int[] findSumAndMax(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			max = Math.max(nums[i], max);
		}
		
		return new int[] {max, sum};
	}

}
