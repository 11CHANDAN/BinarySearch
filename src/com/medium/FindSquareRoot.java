package com.medium;

public class FindSquareRoot {

	public static void main(String[] args) {
		/*
		 * Given a positive integer n. Find and return its square root. If n is not a
		 * perfect square, then return the floor value of sqrt(n).
		 */
		
		FindSquareRoot findSquareRoot = new FindSquareRoot();
		
		System.out.println(findSquareRoot.floorSqrt(36));
		System.out.println(findSquareRoot.floorSqrt(29));
		System.out.println(findSquareRoot.floorSqrt(9));
		
	}
	
	// Linear search
//	public long floorSqrt(long n) {
//		long sqrt = 1;
//		
//		while(sqrt * sqrt <=n) {
//			sqrt++;
//		}
//		
//		return sqrt -1;
//	}
	// Binary Search
	public long floorSqrt(long n) {
		long low =1,high = n;
		long ans = 0;
		while(low<=high) {
			long mid = (low + high)/2;
			if(mid*mid<=n) {
				ans = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return ans;
	}

}
