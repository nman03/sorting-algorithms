package sortingAlgorithms;

public class RandomizedQuickSort {
	
	public static <E extends Comparable<E>> void randomizedQuickSort(E[] A, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(A, p, r);
			randomizedQuickSort(A, p, q - 1);
			randomizedQuickSort(A, q + 1, r);
		}
	}
	
	public static <E extends Comparable<E>> int randomizedPartition(E[] A, int p, int r) {
		int randomInd = (int) Math.random() * (r + 1) + p;
		E tmp = A[randomInd];
		A[randomInd] = A[r];
		A[r] = tmp;
			
		return partition(A, p, r);	
	}
		
	public static <E extends Comparable<E>> int partition(E[] A, int p, int r) {
		E x = A[r];
		E tmp;
		int i = p - 1;
			
		for (int j =  p ; j < r ; j++) {
			if (A[j].compareTo(x) <= 0) {
				i = i + 1;
				tmp = A[j];
				A[j] = A[i];
				A[i] = tmp;
			}
		}
		
		tmp = A[r];
		A[r] = A[i+1];
		A[i+1] = tmp;
		
		return i + 1;	
	}
	
	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] intList = {1,4,9,6,5,7,2,0};
		System.out.println("input: ");
		print(intList);
					
		randomizedQuickSort(intList, 0, intList.length - 1);
		System.out.println("output: ");
		print(intList);
		
		String[] stringList = {"t", "d", "h", "a"};
		System.out.println("input: ");
		print(stringList);

		randomizedQuickSort(stringList, 0, stringList.length - 1);;
		System.out.println("output: ");
		print(stringList);
	}
}
