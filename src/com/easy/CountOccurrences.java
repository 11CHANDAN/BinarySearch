package com.easy;

public class CountOccurrences {

	public static void main(String[] args) {
		
		/* Count occurrences of a number in a sorted array with duplicates */
		
		CountOccurrences countOccurrences = new CountOccurrences();
		
		int[] nums = {5, 7, 7, 8, 8, 10};
		int first = countOccurrences.firstOccurence(nums, 8);
		
		if(first == -1) {
			System.out.println(0);
		}
		
		System.out.println((countOccurrences.lastOccurence(nums, 8)-first)+1);
	}
	
	 public int firstOccurence(int[] nums,int target) {
			int low = 0, 
					high = nums.length-1, 
					ans = -1;

			while(low<=high) {
				int mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                ans = mid;
	                high = mid -1;
	            }else if(nums[mid] > target) {
					high = mid-1;
				}else{
					low = mid +1;
				}
			}
			return ans;
		}

		public int lastOccurence(int[] nums,int target) {
			int low = 0, 
					high = nums.length-1, 
					ans = -1;

			while(low<=high) {
				int mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                ans = mid;
	                low = mid+1;
	            }else if(nums[mid] > target) {
					high = mid-1;
				}else{
					low = mid +1;
				}
			}
			return ans;
		}

}
