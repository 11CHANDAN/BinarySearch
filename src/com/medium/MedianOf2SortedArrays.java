package com.medium;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		/*
		 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
		 * the median of the two sorted arrays.
		 * 
		 * The overall run time complexity should be O(log (m+n)).
		 */
		
		MedianOf2SortedArrays medianOf2SortedArrays = new MedianOf2SortedArrays();
		
		int[] nums1 = {1 ,3 ,4 ,7 ,10 ,12};
		int[] nums2 = {2 ,3, 6, 15};
		
		System.out.println(medianOf2SortedArrays.findMedianSortedArrays(nums1, nums2));
	}
	
	//optimal approach binary search
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int left = (n1+n2+1)/2;
        int low =0,high = n1;

        while(low<=high){
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;

            int l1 = (mid1>0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2>0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1<n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2<n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1){
                    return Math.max(l1,l2);
                }else{
                    return (double) (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
	}
	
//	// better approach
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		int n1 = nums1.length;
//		int n2 = nums2.length;
//		
//		int idx1 = ((n1+n2)/2)-1;
//		int idx2 = (n1+n2)/2;
//		
//		int ele1 = -1;
//		int ele2 = -1;
//		
//		int cnt = 0;
//		int i =0;
//		int j =0;
//		
//		while(i<nums1.length && j<nums2.length && ele2==-1) {
//			if(nums1[i]<=nums2[j]) {
//				if(cnt == idx1) ele1 = nums1[i];
//				if(cnt == idx2) ele2 = nums1[i];
//				i++;
//			}else {
//				if(cnt == idx1) ele1 = nums2[j];
//				if(cnt == idx2) ele2 = nums2[j];
//				j++;
//			}
//			cnt++;
//		}
//		
//		while(i<nums1.length) {
//			if(cnt == idx1) ele1 = nums1[i];
//			if(cnt == idx2) ele2 = nums1[i];
//			i++;
//			cnt++;
//		}
//		
//		while(j<nums2.length) {
//			if(cnt == idx1) ele1 = nums2[j];
//			if(cnt == idx2) ele2 = nums2[j];
//			j++;
//			cnt++;
//		}
//		
//		if(cnt%2==0) {
//			return (double) (ele1 + ele2)/2;
//		}else {
//			return ele2;
//		}
//	}
	
//	brute force
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		int[] nums3 = new int[nums1.length + nums2.length];
//
//		int a = 0;
//		int b = 0;
//		int k =0;
//
//		while(a<=nums1.length-1 && b<=nums2.length-1) {
//			if(nums1[a]<=nums2[b]) {
//				nums3[k++] = nums1[a++];
//			}else {
//				nums3[k++] = nums2[b++];
//			}
//		}
//
//		while(a<=nums1.length-1) {
//			nums3[k++] = nums1[a++];
//		}
//		
//		while(b<=nums2.length-1) {
//			nums3[k++] = nums2[b++];
//		}
//		
//		if(nums3.length%2 == 0) {
//			return (nums3[(nums3.length/2)-1] + nums3[nums3.length/2])/2;
//		}else {
//			return nums3[nums3.length/2];
//		}
//		
//	}

}
