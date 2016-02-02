package divideandConquer;

public class MaxMin {
	public static int[] maxMin(int[] a,int i,int j){
		int max = 0,min = 0;
		if(i == j) {
			max = min = a[i];
		}else if(i < j){
			int mid = (i + j)/2;
			
			int[] g = maxMin(a,i,mid);
			int[] h = maxMin(a,mid + 1,j);
			if(g[0] >= h[0]){
				max = g[0];
			}else{
				max = h[0];
			}
			
			if(g[1] <= h[1]){
				min = g[1];
			}else{
				min = h[1];
			}
		}
		int[] m = {max,min};
		return m;
	}
	
	public static void main(String[] args){
		int[] a = {22,13,-5,-8,15,60,17,79,47};
		int max = 0,min = 0;
		int[] m = maxMin(a,0,8);
		System.out.println("max=" + m[0]);
		System.out.println("min=" + m[1]);
		
	}
}
