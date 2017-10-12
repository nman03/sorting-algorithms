package sortingAlgorithms;

public class MergeSort {

	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		mergeSort(list, 0, list.length-1);
	}

	private static <E extends Comparable<E>> void mergeSort (E[] list, int p, int r) {
		if (r - p < 1) return;
		int q = (p + r) / 2;
		mergeSort(list, p, q);
		mergeSort(list, q + 1, r);
		merge(list, p, q, r);
	}


	@SuppressWarnings("unchecked") 
	private static <E extends Comparable<E>> void  merge(E[] list, int p, int q, int r) {

		Object[] tmp = new Object[r-p+1]; 
		int i = p;
		int j = q + 1;
		int k = 0;
		
		while (i <= q && j <= r) {
			if (list[i].compareTo(list[j])<=0)
				tmp[k] = list[i++];
			else
				tmp[k] = list[j++];
			k++;
		}
		if (i <= q && j > r) {
			while (i <= q) 
				tmp[k++] = list[i++];
		} else {
			while (j <= r)
				tmp[k++] = list[j++];
		}
		for (k = 0 ; k < tmp.length ; k++) {
			list[k+p] = (E)(tmp[k]); 
		}
	}
	
	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("MergeSort: ");
		
		Integer[] intList = {6, 7, 3, 2, 4};
		System.out.print("\ninput: ");
		print(intList);

		mergeSort(intList);
		System.out.print("output: ");
		print(intList);

		String[] stringList = {"z", "e", "q", "b"};
		System.out.print("\ninput: ");
		print(stringList);

		mergeSort(stringList);
		System.out.print("output: ");
		print(stringList);
	}
}
