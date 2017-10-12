package sortingAlgorithms;

public class RadixSort {

	public static <E extends Comparable<E>> void radixSort(E[] list) {
		int m = maxIndex(list);

		for (int i = 0, n = String.valueOf(list[i]).length() - 1 ; i < m ; i++, n--) {
			sort(list, n);
		}

	}

	public static <E> void sort(E[] list, int n) {
		for (int i = 1 ; i < list.length ; i++) {
			E temp = list[i];
			int k; 
			for (k = i - 1 ; k >= 0 && getValue(list[k], n) > getValue(temp, n) ; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = temp;
		}
	}

	public static <E> int maxIndex(E[] list) {
		int max = 0;

		for (E element : list) {
			if (max <= String.valueOf(element).length()) {
				max = String.valueOf(element).length();
			}
		}

		return max;

	}

	public static <E> char getValue(E element, int n) {
		if (n < 0) {
			return '0';
		}
		else {
			return String.valueOf(element).charAt(n);
		}
	}

	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("RadixSort: ");

		Integer[] intList = {323, 122, 231, 145, 546, 144};
		System.out.print("\ninput: ");
		print(intList);

		radixSort(intList);
		System.out.print("output: ");
		print(intList);

		String[] stringList = {"ja", "ear", "gah", "ac", "am", "aa", "aaav"};
		System.out.print("\ninput: ");
		print(stringList);

		radixSort(stringList);
		System.out.print("output: ");
		print(stringList);
	}	

}
