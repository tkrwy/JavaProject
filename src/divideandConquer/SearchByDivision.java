package divideandConquer;

public class SearchByDivision {
	//µ›πÈ≤È—Ø
	public static int searchRecurse(int array[],int low,int high,int v ){
		if(low <= high){
			int middle = low + (high - low)/2;
			if(v == array[middle]){
				return middle;
			}else if(v > array[middle]){
				return searchRecurse(array,middle + 1,high,v);
			}else if(v < array[middle]){
				return searchRecurse(array, low, middle -1, v);
			}
		}
		return -1;
	}
	
	//µ¸¥˙≤È—Ø
	public static int search(int array[],int v){
		int low = 0;
		int high = array.length - 1;
		
		
		while(low <= high){
			int middle = low + (high - low)/2;
			if(array[middle] == v) return middle;
			else if(array[middle] > v){
				high = middle - 1;
			}else if(array[middle] < v){
				low = middle + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int array[] = {0,1,2,3,4,5,6,7,13,19};
		int value = 13;
		int index_recurse = searchRecurse(array,0,array.length -1,value);
		System.out.println("value " + value +" 's index is " +index_recurse);
		int index = search(array,value);
		System.out.println(index);
	}
}
