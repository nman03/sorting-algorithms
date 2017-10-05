package sortingAlgorithms;

public class QuickSort {
	
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E extends Comparable<E>> void quickSort(E[] list, int x, int y) {
		if (x < y) {
			int i = x, j = y;
			int midIndex = (i + j ) / 2;
			E mid = list[midIndex];

			do {
				while (list[i].compareTo(mid) < 0) { 
					i++;
				}
				while (mid.compareTo(list[j]) < 0) {
					j--;
				}

				if ( i <= j) {
					E temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					i++;
					j--;
				}

			} while (i <= j);

			quickSort(list, x, j);
			quickSort(list, i, y);
		}
	}
	
	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] intList = {3, 2, 1, 5, 6, 4};

		System.out.println("input: ");
		print(intList);

		quickSort(intList);
		System.out.println("output: ");
		print(intList);
		
		String[] stringList = {"j", "r", "h", "a", "m"};
		
		System.out.println("input: ");
		print(stringList);
		
        	quickSort(stringList);
        	System.out.println("output: ");
		print(stringList);
		

	}
}
