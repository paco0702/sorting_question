package questionRelatedToSort;

public class CountSort {
	int [] countArray;
	int [] data;
	int [] resultArray;
	
	CountSort(int arrange, int [] data){
		this.countArray = new int [arrange];
		this.data = data;
		this.resultArray = new int [data.length];
	}
	
	CountSort(int [] data){
		this(10, data);
	}
	
	void start() {
		count(this.data);
		cumulateCount();
		sort();
		printSortedArray();
	}
	
	private void count(int [] data) {
		for(int i=0; i<data.length; i++) {
			this.countArray[data[i]] = this.countArray[data[i]] + 1;
		}
	}
	
	private void cumulateCount() {
		for(int i=1; i<this.countArray.length; i++) {
			this.countArray[i] = this.countArray[i] + this.countArray[(i-1)];
			
		}
		//System.out.println(countArray[countArray.length-1]);
	}
	
	private void sort() {
		int lastElementIndex = data.length-1;
		for(int i =0; i<this.data.length; i++) {
			int element = this.data[lastElementIndex];
			int index = this.countArray[element]-1;
			this.countArray[element]--;
			this.resultArray[index] = element;
			lastElementIndex--;
		}
	}
	
	private void printSortedArray() {
		for(int i=0; i<this.resultArray.length; i++) {
			System.out.printf("%d ",resultArray[i]);
		}
	}
	
	public int [] returnSortedArray() {
		if(resultArray!=null) {
		return this.resultArray;
		}else 
			return null;
	}

}
