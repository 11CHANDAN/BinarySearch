package com.medium;

public class MinimumDaysToMakeMBouquets {

	public static void main(String[] args) {
		/*
		 * Given n roses and an array nums where nums[i] denotes that the 'ith' rose
		 * will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to
		 * make a bouquet. Exactly k adjacent bloomed roses are required to make a
		 * single bouquet. Find the minimum number of days required to make at least m
		 * bouquets, each containing k roses. Return -1 if it is not possible.
		 */		
		MinimumDaysToMakeMBouquets bouquets = new MinimumDaysToMakeMBouquets();
		
		int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
		System.out.println(bouquets.roseGarden(nums.length, nums, 3, 2));
		
	}

	// k means consecutive roses
	// m means minimum roses
	public int roseGarden(int n, int[] nums, int k, int m) {
		long val = (long) m * k;
		if(val > n) {
			return -1;
		}
		
		int[] minMax = findMinMax(nums);
		
		int low = minMax[0];
		int high = minMax[1];
		
		while(low<=high) {
			int mid = (low+high)/2;
			int noOfB = findTotalBlooms(nums, k, mid);
			
			if(noOfB>=m) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return low;
	}
	
	public int findTotalBlooms(int[] nums,int k,int mid) {
		int cnt = 0;
		int noOfB = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=mid) {
				cnt++;
			}else {
				noOfB += (cnt / k);
				cnt=0;
			}
		}
		
		noOfB += (cnt/k);
		return noOfB;
	}
	
	public int[] findMinMax(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		return new int[] {min,max};
	}
}
