package com.medium;

public class KokoEatingBananas {

	public static void main(String[] args) {
		
		/*
		 * A monkey is given n piles of bananas, where the 'ith' pile has nums[i]
		 * bananas. An integer h represents the total time in hours to eat all the
		 * bananas.
		 * 
		 * 
		 * Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
		 * If the pile contains fewer than k bananas, the monkey eats all the bananas in
		 * that pile and does not consume any more bananas in that hour.
		 * 
		 * 
		 * Determine the minimum number of bananas the monkey must eat per hour to
		 * finish all the bananas within h hours.
		 */
		KokoEatingBananas eatingBananas = new KokoEatingBananas();
		
		int[] nums = {7, 15, 6, 3};
		System.out.println(eatingBananas.minimumRateToEatBananas(nums, 8));
		
		nums = new int[]{25, 12, 8, 14, 19};
		System.out.println(eatingBananas.minimumRateToEatBananas(nums, 5));
		
	}
	
//	public int minimumRateToEatBananas(int[] nums, int h) {
//		int max = findMax(nums);
//		for(int i=1;i<max;i++) {
//			int totalHrs = calculateTotatHours(nums,i);
//			if(totalHrs<=h) {
//				return totalHrs;
//			}
//		}
//		return max;
//    }
	
	public int minimumRateToEatBananas(int[] nums, int h) {
		int low = 1;
		int high = findMax(nums);
		
		while(low <= high) {
			int mid = (low + high)/2;
			int totalH = calculateTotatHours(nums, mid);
			
			if(totalH <=h) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return low;
		
	}
	
	public int calculateTotatHours(int[] nums,int hourly) {
		int totalH = 0;
		for(int i=0;i<nums.length;i++) {
			totalH += Math.ceil((double)nums[i]/(double)hourly);
		}
		return totalH;
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
