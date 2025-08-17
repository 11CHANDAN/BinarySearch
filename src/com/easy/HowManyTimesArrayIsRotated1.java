package com.easy;

public class HowManyTimesArrayIsRotated1 {

	public static void main(String[] args) {

		/*
		 * Given an integer array nums of size n, sorted in ascending order with
		 * distinct values. The array has been right rotated an unknown number of times,
		 * between 0 and n-1 (including). Determine the number of rotations performed on
		 * the array.
		 */
		HowManyTimesArrayIsRotated1 arrayIsRotated = new HowManyTimesArrayIsRotated1();

		int[] nums = {4, 5, 6, 7, 0, 1, 2, 3}; //Output: 4
		System.out.println(arrayIsRotated.findKRotation(nums));

		nums = new int[]{3, 4, 5, 1, 2}; //Output: 3
		System.out.println(arrayIsRotated.findKRotation(nums));

		nums = new int[] {7,8,1,2,3,4,5,6}; //Output: 2
		System.out.println(arrayIsRotated.findKRotation(nums));
		
		nums = new int[] {90,-87,-78,-65,-49,-29,-28,-23,-2,7,12,14,24,40,46,55,76,77,80,83};
		System.out.println(arrayIsRotated.findKRotation(nums)); //Output 1
	}

	public int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

}
