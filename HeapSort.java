package sortingAlgorithms;


public class HeapSort {
	
    private static int size;
    private static int leftSide;
    private static int rightSide;
    private static int max;

    
    public static <E extends Comparable<E>> void heap(E[] list) {
        size = list.length - 1;
        
        for(int i = size / 2 ; i >= 0 ; i--){
            maxHeap(list, i);
        }
    }
    
    public static <E extends Comparable<E>> void maxHeap(E[] list, int i) { 
        leftSide = 2 * i;
        rightSide = 2 * i + 1;
        
        if(leftSide <= size && list[leftSide].compareTo(list[i]) > 0) {
            max = leftSide;
        }
        else {
            max = i;
        }
        
        if(rightSide <= size && list[rightSide].compareTo(list[max]) > 0) {
            max = rightSide;
        }
        if(max != i){
            swap(list, i, max);
            maxHeap(list, max);
        }
    }
    
    public static <E> void swap(E[] list, int i, int j){
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp; 
    }
    
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        heap(list);
        
        for(int i = size ; i > 0; i--){
            swap(list, 0, i);
            size = size - 1;
            maxHeap(list, 0);
        }
    }
    
    public static <E> void print(E[] list) {
		for (E elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
    
    public static void main(String[] args) {
    	System.out.println("HeapSort: ");
    	
        Integer[] intList = {4, 1, 3, 2, 6, 9, 10, 5, 8, 7};
        System.out.print("\ninput: ");
		print(intList);
		
        heapSort(intList);
        System.out.print("output: ");
		print(intList);
             
        String[] stringList = {"c", "a", "r", "l", "s"};
        System.out.print("\ninput: ");
		print(stringList);
		
        heapSort(stringList);
        System.out.print("output: ");
		print(stringList);
        
    }
}
