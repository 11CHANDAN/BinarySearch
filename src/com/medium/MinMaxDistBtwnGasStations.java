package com.medium;

import java.util.PriorityQueue;

public class MinMaxDistBtwnGasStations {

	public static void main(String[] args) {
		/*
		 * Given a sorted array arr of size n, containing integer positions of n gas
		 * stations on the X-axis, and an integer k, place k new gas stations on the
		 * X-axis.
		 * 
		 * The new gas stations can be placed anywhere on the non-negative side of the
		 * X-axis, including non-integer positions.
		 * 
		 * Let dist be the maximum distance between adjacent gas stations after adding
		 * the k new gas stations.
		 * 
		 * Find the minimum value of dist.
		 */
		MinMaxDistBtwnGasStations btwnGasStations = new MinMaxDistBtwnGasStations();
		
		int[] nums = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
		System.out.println(btwnGasStations.minimiseMaxDistance(nums, 2));
		
		nums = new int[] {1, 13, 17, 23};
		System.out.println(btwnGasStations.minimiseMaxDistance(nums, 5));
	}

//	// brute force
//	public double minimiseMaxDistance(int[] nums, int k) {
//		int n = nums.length;
//		int[] howMany = new int[n-1];
//		
//		for(int gasStations = 1 ; gasStations <= k ; gasStations++) {
//			double maxSection = -1;
//			int maxInd = -1;
//			
//			for(int i=0;i<n-1;i++) {
//				int diff = nums[i+1] - nums[i];
//				double sectionLength = diff / (howMany[i]+1);
//				if(sectionLength > maxSection) {
//					maxSection = sectionLength;
//					maxInd = i;
//				}
//			}
//			howMany[maxInd]++;
//		}
//		
//		double maxAns = -1;
//		for(int i=0; i<n-1; i++) {
//			int diff = nums[i+1] - nums[i];
//			double sectionLength = diff / (howMany[i]+1);
//			maxAns = Math.max(maxAns,sectionLength);
//		}
//		return maxAns;
//	}
	
	public class Pair{
		double first;
		int second;
		
		Pair(double first, int second){
			this.first = first;
			this.second = second;
		}
	}
	
	public double minimiseMaxDistance(int[] nums, int k) {
		int n = nums.length;
		int[] howMany = new int[n-1];
		
		PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>((a,b) -> (Double.compare(b.first, a.first)));
		
		for (int i = 0; i < n - 1; i++) {
			priorityQueue.add(new Pair(nums[i + 1] - nums[i], i));
        }
		
		for(int gasStations=1;gasStations<=k;gasStations++) {
			//fetch the top element and delete from priority queue
			Pair p = priorityQueue.poll();
			howMany[p.second]++;
			
			double diff = nums[p.second + 1] - nums[p.second];
			double sectionLength = diff / (howMany[p.second] + 1);
			priorityQueue.add(new Pair(sectionLength,p.second));
		}
		
		return priorityQueue.peek().first;
	}

}
