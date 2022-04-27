       

// go through the whole table next time 

// hash class
class HashTable{
    	   int [] table = new int [5];
    	   int r = 7;
    	   private int count = 0;
    	   
    	   
    	   
    	   public int size() {
    		   return table.length;
    	   }
    	   
    	   public int getsize() {
    		   return count;
    	   }
    	   
    	   private int hash(int k) {	
    		   return k%size();
    	   }
    	   
    	   private int hash2(int k, int r) {
    		   return r-(k%r);
    	   }
    	   
    	   public boolean isFull() {
    		   
    		   if(count == table.length) {
    			   return true;
    		   }else 
    			   return false;
    		   
    	   }
    	   
    	   void insert(int data) {
    		   
    		   if(isFull()== true){
    			   return;
    		   }
    		   
    		   int index, hk, collision =0;
    		   
    		   index = hk = hash(data);
    		   int hk2 = hash2(data, r);
    		   
    		   while(table [index]!= 0) {
    			   collision ++;
    			   index = hash(hk+ collision * hk2);
    		   }
    		   
    		   System.out.println("the index inserting in Tier2 is " + index);
    		   table [index] = data;
    		   count++;
    		   System.out.println();
    	   }
    	   
    	   void print() {
    		   
    		   for(int i=0; i<table.length; i++){
    			   System.out.print(table[i]+", ");
    		   }
    		   
    	   }
    	   
    	   void clear() {
    		   for(int i=0; i<table.length; i++){
    			  table[i]=0;
    		   }
    		   count =0;
    	   }
	
		}
       
       
 // heap class 
       class Heap{
    	   int maxsize;
    	   int [] list;
    	   int count =0;
    	   
    	   Heap(int [] data){
    		   this.maxsize = data.length;
    		   this.list = new int [data.length];
    		   
    	   }
    	   
    	   private int getParent(int x) {
    		   return (x+1/2)-1;
    	   }
    	   
    	   private int getLeftChild(int x) {
    		   return getRightChild(x)-1;
    	   }
    	   
    	   private int getRightChild(int x) {
    		   return (x+1)*2;
    	   }
    	   
    	   boolean isFull() {
    		   if(count == maxsize) {
    			   return true;
    		   }else {
    			   return false;
    		   }
    	   }
    	   
    	   void insert(int index, int data) {
    		   if(isFull()==false) {
    			   System.out.println("inserting "+ data +" in index "+ index);
    			   list[index] = data;
    		   }
    		   
    		   bubbleUp(count);
    		   count++;
    	   }
    	   
    	   void bubbleUp(int current) {
    		   int c = list [current];
    		   int p = current;
    		   
    		   while (current >0 && list[p]>=c) {
    			   list[current]= list [p];
    			   current = p;
    			   
    			   p = getParent(p);
    		   }
    		   list[current] = c;
    		   
    	   }
    	   
    	   boolean isEmpty() {
    			if(count ==0) {
    				return true;
    			}else 
    				return false;
    		}
    		int delMin() {
    			if(isEmpty()==true)
    				return -1;
    			int k= list[0];   // return the last element
    			list [0] = list[count-1];  // put the last element into the top
    			count --;
    			bubbleDown(0);  // and then bubble down
    			return k;
    		}
    		
    	   void bubbleDown(int current) {
    		   int c = list[current]; // current data
    		   
    		   int p = current, leftchild, rightchild; // index
    		   
    		   while (p<= count && list[p]<= c) {
    			   list[current] = list [p];
    			   current = p;
    			   leftchild = getLeftChild(p);
    			   rightchild = getRightChild(p);
    			   
    			   if(p <= count) {
    				   if(leftchild < maxsize && rightchild < maxsize) {
    					   if(list[leftchild] < list[rightchild]) {
    						   p = leftchild;
    					   }else {
    						   p = rightchild;
    					   }
    				   }else if(leftchild> maxsize && rightchild <= maxsize) {
    					   p= rightchild;
    				   }else {
    					   p = leftchild;
    				   }
    			   }
    			   list [current] = c;
    		   }
    	   }
    	   
    	   void print () {
    			for(int i = 0; i<list.length; i++) {
    				System.out.print(list[i]+" ");
    			}
    		}
    	   
    	   
       }
       
       
 // main class
public class DorisHashTable { 
	HashTable [] table = new HashTable [7];
	private static int count=0;
//	
	
	DorisHashTable(){
		table[0] = new HashTable();
		table[1] = new HashTable();
		table[2] = new HashTable();
		table[3] = new HashTable();
		table[4] = new HashTable();
		table[5] = new HashTable();
		table[6] = new HashTable();
	}
	
	public int getSize() { // time complexity O(1)
		return count;
	}
	
	public int size() {
		return table.length;
	}
	
	public int totalSize() {
		return table.length*table[0].table.length;
	}
	private int hash(int k) {
		return k%size();
	}
	
	void insert(int key) {  // time Complexity O(H)
		
		int index , hk , collision=0;
		
		index = hk = hash(key);
		
		if(table[index].isFull()==false) {
			
			collision ++;
			index = hash(hk+collision);
			
		}
		
		System.out.println("the index inserting in Tier1 is " + index);
		
		table[index].insert(key);
		count++;
		System.out.println();
	}
	
	void print() {   // time complexity O(N*M)
		
		for(int i=0; i<table.length; i++) {
			if(table[i] != null) {
			table[i].print();
			System.out.println();
			}
		}
	}
	
//	int [] sort() {
//		
//		
//	}
	
	int [] toArray() {  // time complexity O(N*N)
		int [] list = new int [count];
		int k=0;
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].size(); j++) {
				if(table[i].table[j]!=0) {
					list[k] = table[i].table[j];
					k++;
				}
			}
		}
		return list;
	}
	
	public int [] sort() {
		int [] list = toArray();
		int [] sortedList = sort(list, 0, list.length-1);
		return sortedList;
		
	}
	
	private int [] sort(int [] data, int first, int last) {  // time Complexity O(n log n)
		
		if(first >= last) 
			return data;
		
//		System.out.println("the first one is " +first+" the last one is "+ last);
//		if(first>=last) 
//			return null;
		
		
		int pivotindex = choosePivot(data, first, last);
//		System.out.println("the index of pivot is "+ pivotindex);
		
		int pivot = data[pivotindex];
//		System.out.println("the pivot is "+pivot);
		
		if(pivotindex != last ) {
			System.out.println("swap the pivot ");
			swap(data, pivotindex, last);
			pivotindex = last;
//			System.out.println("pivot index is "+ pivotindex+" the element is "+ data [pivotindex]);
			
			for(int l=0; l<data.length ; l++) {
				System.out.print(data[l]+", ");
			}
			System.out.println();
		}
		int i =first; int j=last-1;
//		System.out.println("the first index is "+ i);
//		System.out.println("the second last index is "+ j);
		while (true) {
			
			while (data[i] <= pivot && i< last) i++;
//			System.out.println("the i stop at index "+i+" the element is "+ data[i]);
			while (data[j] > pivot && j>first ) j--;
//			System.out.println("the j stop at index "+j+" the element is "+ data[j]);
//			System.out.println();
			
			if(i>= j) break;
			
			swap(data,i, j);
			sort(data, first, i-1);
		}
		
		System.out.println("swap the i and pivot");
		swap(data,i, pivotindex);
		
		for(int k=0; k<data.length ; k++ ) {
			System.out.print(data[k]+", ");
		}
		System.out.println();
		
		System.out.println("sort s1 part");
		sort(data, first, i-1);
		
		System.out.println("sort s2 part");
		sort(data, i+1, last);
		
		return data;
	}
	
	void  swap(int [] data, int i, int j){
		int a = data [i];
		data [i]= data [j];
		data [j] = a;
//		System.out.println("index " +i +" data is "+ data [i]);
//		System.out.println("index " +j +" data is "+ data [j]);
//		System.out.println();
	}
	
	int choosePivot(int [] data,int  first,int last) {
		int median = (first+(last))/2;
		if(data[first]<data[median] && data[median]<data[last]) {
			return median;
		}else if(data[median] < data[first] && data[first]<data[last]) {
			return first;
		}else {
			return last;
		}
	}
	
	//Time complexity O(n log n)
	int [] toHeap() { 
		int [] list = toArray();

		System.out.println();
		int [] newlist = toHeap(list);
		
//		System.out.println("new list element");
//		for (int i =0; i<newlist.length; i++) {
//			System.out.print(newlist[i]+" ");
//		}
		return newlist ;
	}
	
	private int [] toHeap(int [] data) {  //Time complexity O(N)
		Heap h = new Heap(data);
		int [] newlist = new int[data.length];
		for (int i =0; i<data.length; i++) {
			h.insert(i, data[i]);
		}
		
		h.print();
		
		System.out.println();
		
		for(int j=0; j<data.length; j++) {
			newlist[j] = h.delMin();
//			System.out.print(newlist[j]+", ");
		}
		return newlist;
	}
	
	//O(N*N)
	void clear () { 
		for (int i=0; i<table.length; i++) {
			table[i].clear();
		}
		this.count = 0;
	}
	
	public static void main(String [] args) {
		DorisHashTable d = new DorisHashTable();
		d.insert(35);
		d.insert(40);
		d.insert(36);
		d.insert(8);
		d.insert(2);
		d.insert(12);
		d.insert(5);
		d.insert(96);
		d.insert(62);
		d.insert(83);
		System.out.println(d.getSize());
		System.out.println();
//		System.out.println(d.table[0].getsize());
		System.out.println();
		
		d.print();
		System.out.println();
		
		System.out.println(d.totalSize());
		
		int [] list = d.toArray();
		
		for(int i=0; i<d.toArray().length; i++) {
			System.out.print(list[i] +", ");
		}
		System.out.println();
		
		d.sort();
		 
		System.out.println();
		int [] heap = d.toHeap();
		for(int j=0; j<heap.length; j++) {
			System.out.print(heap[j] +", ");
		}
		System.out.println();
		
		d.clear();
		d.print();
	}
	
	// toHeap needs to use the zero index to store the data
}
