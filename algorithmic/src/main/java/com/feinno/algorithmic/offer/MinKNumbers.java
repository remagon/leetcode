package com.feinno.algorithmic.offer;

public class MinKNumbers {

	public int[] getMinKNum(int[] arr, int k) {
		if (arr == null || arr.length < k)
			return null;
		
		int[] min = new int[k];
		

		for (int i = 0; i < k; i++) {
			insertMaxHeap(min, i, arr[i]);
		}
		
		for (int i = k; i < arr.length; i++) {
			casMaxHeap(min, arr[i]);
		}
		return min;
	}
	
	private void insertMaxHeap(int[] arr, int pos, int value) {
		if (arr.length <= pos) {
			return;
		}
		arr[pos] = value;
		while (true) {
			int parent = (pos - 1) / 2;
			if (parent == pos)
				break;
			if (arr[pos] > arr[parent]) {
				swapArr(arr, pos, parent);
				pos = parent;
			} else {
				break;
			}
		}
	}
	
	private void casMaxHeap(int[] arr, int value) {
		if (arr[0] < value)
			return;
		arr[0] = value;
		int pos = 0;
		while (true) {
			int child1 = pos * 2 + 1;
			if (child1 >= arr.length)
				break;
			int child2 = pos * 2 + 2;
			int maxChild = child1;
			if (child2 < arr.length && arr[child2] > arr[child1]) {
				maxChild = child2;
			}
			if (arr[maxChild] > arr[pos]) {
				swapArr(arr, pos, maxChild);
				pos = maxChild;
			} else {
				break;
			}
		}
	}
	
	private void swapArr(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public static void main(String[] args) {
		MinKNumbers solution = new MinKNumbers();
		System.out.println(solution.getMinKNum(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
	}
}
