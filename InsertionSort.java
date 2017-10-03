package sortingAlgorithms;

public class InsertionSort {

	public static <E extends Comparable<E>> void insertionSort(E[] list){		
		for (int i = 1 ; i < list.length ; i++) {
			E temp = list[i];
			int k; 
			
			for (k = i - 1 ; k >= 0 && list[k].compareTo(temp) > 0 ; k--) {
				list[k+1] = list[k];
			}
			
			list[k+1] = temp;
		}

	}
	
	public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] intList= {2, 5, 4, 3, 1};
		System.out.println("input: ");
		print(intList);
		
		insertionSort(intList);
		System.out.println("output: ");
		print(intList);
		
		String[] stringList = {"b", "j", "k", "e"};
		System.out.println("input: ");
		print(stringList);
		
		insertionSort(stringList);
		System.out.println("output: ");
		print(stringList);
	}
}
