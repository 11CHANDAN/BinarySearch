package com.medium;

public class FindNthRoot {

	public static void main(String[] args) {
		/*
		 * Given two numbers N and M, find the Nth root of M. The Nth root of a number M
		 * is defined as a number X such that when X is raised to the power of N, it
		 * equals M. If the Nth root is not an integer, return -1.
		 */
		FindNthRoot findNthRoot = new FindNthRoot();
		
		System.out.println(findNthRoot.NthRoot(3, 27));
		System.out.println(findNthRoot.NthRoot(7, 69));
		System.out.println(findNthRoot.NthRoot(4, 16));
		System.out.println(findNthRoot.NthRoot(4, 81));
		System.out.println(findNthRoot.NthRoot(5, 32));
		System.out.println(findNthRoot.NthRoot(1, 10));
		System.out.println(findNthRoot.NthRoot(2, 0));
	}

//	public int NthRoot(int N, int M) {
//		if(M==1) return 1;
//		for(int i=2;i<=M;i++) {
//			int ans = 1;
//			for(int j=1;j<=N;j++) {
//				ans *= i;
//			}
//			if(ans==M) {
//				return i;
//			}else if(ans>M) {
//				return -1;
//			}
//		}
//		return -1;
//	}
	
	public int NthRoot(int N, int M) {
		int low =1,high = M;
		
		while(low<=high) {
			int mid = (low+high)/2;
			int ans = prodNnums(mid, N, M);
			
			if(ans==1) {
				return mid;
			}else if(ans==2) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
	
	//for large number if we keep multiply we will get integer overflow so follow below rules
	// if mid == m return 1
	// if mid < m return 0
	// if mid > m return 2
	public int prodNnums(int mid,int n,int m) {
		int ans = 1;
		for(int i=1;i<=n;i++) {
			ans *= mid;
			if(ans>m) {
				return 2;
			}
		}
		
		if(ans == m) {
			return 1;
		}
		return 0;
	}
	
}
