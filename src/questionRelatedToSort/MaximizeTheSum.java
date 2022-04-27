package questionRelatedToSort;


public class MaximizeTheSum {
	/*
	 given an array of N integers
	 you are allowed to rerrange the element the element of the array 
	 the task is to find the max value of £Uarr[i]*i, where i = 0, 1, 2,¡K., n ¡V 1.
	 
	 
	 */
	public static void main(String [] args) {
		int data [] = {3,5,6,1};
		CountSort cs = new CountSort(data);
		cs.start();
		int [] sortedArray = cs.returnSortedArray();
		int sum =0;
		for(int i =0; i<sortedArray.length; i++) {
			sum = sum + sortedArray[i]*i;
		}
		System.out.println();
		System.out.println(sum);
		
		int data2 [] = {19,20};
		CountSort cs2 = new CountSort(21, data2);
		cs2.start();
		sortedArray  = cs2.returnSortedArray();
		sum =0;
		for(int i =0; i<sortedArray.length; i++) {
			sum = sum + sortedArray[i]*i;
		}
		System.out.println();
		System.out.println(sum);
		
	}
}
