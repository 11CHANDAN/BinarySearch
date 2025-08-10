package com.medium;

public class CapacityToShipPackages {

	public static void main(String[] args) {
		/*
		 * You are given an array weights where weights[i] represents the weight of the
		 * i-th package on a conveyor belt. All the packages must be shipped in the
		 * order given from one port to another within days days.
		 * 
		 * 
		 * Each day, the ship can carry a contiguous sequence of packages, as long as
		 * the total weight does not exceed its maximum capacity.
		 * 
		 * 
		 * Your task is to find the minimum possible capacity of the ship so that all
		 * packages can be shipped within the given number of days.
		 */
		
		CapacityToShipPackages shipPackages = new CapacityToShipPackages();
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(shipPackages.shipWithinDays(nums, 5));
		
		nums = new int[]{3, 2, 2, 4, 1, 4};
		System.out.println(shipPackages.shipWithinDays(nums, 3));
	}

	public int shipWithinDays(int[] weights, int days) {
		int[] arr = findSumAndMax(weights);
		
		int low = arr[0];
		int high = arr[1];
		
		while(low<=high) {
			int mid = (low + high)/2;

			if(findDays(weights, days, mid)) {
				high = mid -1;
			}else {
				low = mid +1;
			}
		}
		return low;
	}
	
	public boolean findDays(int[] weights,int days,int cap) {
		int d = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                d += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
		
        if(d<=days) {
        	return true;
        }
        return false;
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
