package divideandConquer;

public class QuickSort {
	static int[] a = {65,70,75,80,85,60,55,50,45};
	public static void quickSort(int i,int j){
		if(i < j){
			int k = partition(i, j);
			quickSort(i,k-1);
			quickSort(k+1,j);
		}
		
	}
	public static int partition(int m,int n){
		int i = m;
		int j = n + 1;
		int x = a[i]; //a[i]为划分元素
		while(i < j){
			do{
				i++;
			}while(a[i] < x && i < j - 1);
			
			do{
				j--;
			}while(a[j] > x && j > i - 1);
			
			if(i<j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}else break;
		}
		
		a[m] = a[j];
		a[j] = x;
		return j;
	}
	public static void main(String[] args){
		quickSort(0,a.length-1);
		for(int i = 0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
