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

	public static void main(String[] args) {
		   Integer[] list = {323, 122, 231, 145, 546, 144};
       radixSort(list);

       String[] list1 = {"ja", "ear", "gah", "ac", "am", "aa", "aaav"};
       radixSort(list1);

       for(int i = 0 ; i < list.length ; i++){
           System.out.print(list[i] + " ");
       }

       System.out.println();

       for(int i = 0 ; i < list1.length ; i++){
           System.out.print(list1[i] + " ");
        }	
   }

}
