package sortingAlgorithms;

public class BubbleSort {

	public static <E extends Comparable<E>> void bubbleSort(E[] list){
		int k = list.length - 1;

		for (int i = 0 ; i < list.length ; i++, k--) {
			for (int j = 0 ; j < k ; j++) {
				if (list[j].compareTo(list[j+1]) > 0) {
					E temp = list[j];            
					list[j] = list[j+1];
					list[j+1] = temp;
				}
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
		System.out.println("BubbleSort: ");
		
		Integer[] intList = {5, 1, 7, 4, 9};
		System.out.print("\ninput: ");
		print(intList);

		bubbleSort(intList);
		System.out.print("output: ");
		print(intList);

		String[] stringList = {"t", "r", "c", "a"};
		System.out.print("\ninput: ");
		print(stringList);

		bubbleSort(stringList);
		System.out.print("output: ");
		print(stringList);
	}
}