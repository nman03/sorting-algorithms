package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static <E extends Comparable<E>> void bucketSort(E[] list) {
		final int BUCKET_COUNT = 5;
		E top = list[0];
		E bot = list[0];

		for (int i = 1; i < list.length; i++) { 
			if (list[i].compareTo(top) > 0) {
				top = list[i];
			}

			if (list[i].compareTo(bot) < 0) { 
				bot = list[i];
			}
		}

		int range = (list.length + 1) * BUCKET_COUNT; 

		@SuppressWarnings("unchecked")
		ArrayList<E> buckets[] = new ArrayList[BUCKET_COUNT];

		for (int i = 0; i < BUCKET_COUNT; i++) { 
			buckets[i] = new ArrayList<E>();
		}


		for (int i = 0 ; i < list.length ; i++) {
			buckets[((String.valueOf(list[i]).compareTo(String.valueOf(bot))) / range)].add(list[i]);
		}

		int pointer = 0;
		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]); 
			for (int j = 0; j < buckets[i].size(); j++) { 
				list[pointer] = (E) buckets[i].get(j);
				pointer++;
			}
		}
	}

	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("BucketSort: ");

		Integer[] intList = {3, 2, 1, 5, 6, 9};
		System.out.print("\ninput: ");
		print(intList);

		bucketSort(intList);
		System.out.print("output: ");
		print(intList);	

		String[] stringList = {"c", "b", "a", "e", "f", "d"};
		System.out.print("\ninput: ");
		print(stringList);
		
		bucketSort(stringList);
		System.out.print("output: ");
		print(stringList);
	}

}