package com.medium;

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
		/*
		 * Given an array nums of size n, which denotes the positions of stalls, and an
		 * integer k, which denotes the number of aggressive cows, assign stalls to k
		 * cows such that the minimum distance between any two cows is the maximum
		 * possible. Find the maximum possible minimum distance.
		 */
		AggressiveCows cows = new AggressiveCows();
		int[] nums = {0, 3, 4, 7, 10, 9};
		System.out.println(cows.aggressiveCows(nums, 4));
		
		nums = new int[] {4, 2, 1, 3, 6};
		System.out.println(cows.aggressiveCows(nums, 2));
	}

//	public int aggressiveCows(int[] nums, int k) {
//		Arrays.sort(nums);
//		// this will be max distance between 2 cows
//		int limit = nums[nums.length-1] - nums[0];
//		
//		for(int i=1;i<=limit;i++) {
//			if(!canWePlace(nums, i, k)) {
//				return i-1;
//			}
//		}
//		
//		return limit;
//	}
	
	public int aggressiveCows(int[] nums, int k) {
		Arrays.sort(nums);
		int low = 1,high = nums[nums.length-1];
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(!canWePlace(nums, mid, k)) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return high;
	}
	
	public boolean canWePlace(int[] stalls, int dist, int cows) {
		int cntCows = 1;
		int last = stalls[0];
		
		for(int i=1;i<stalls.length;i++) {
			if(stalls[i]-last >= dist) {
				last = stalls[i];
				cntCows +=1;
				if(cntCows>=cows) {
					return true;
				}
			}
		}
		
		return false;
	}

}
