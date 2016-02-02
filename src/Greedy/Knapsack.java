package Greedy;
//m,n,p[],w[],x[]
public class Knapsack {
//sort
//cu
	public static float[] greedyKnap(int m,int n,float[] p,float[] w){
		//calcute value
		float[] v = new float[n];
		for(int i = 0;i < n;i++){
			v[i] = p[i]/w[i];
		}
		for(int i = 0;i< n;i++){
			System.out.println(v[i]);
		}
		//sort v
		float cu = m;
		float[] x = new float[n];
		
		//local×îÓÅ
		int i;
		for(i = 0;i < n;i++){
			
			if(w[i] <= cu){
				cu = cu - w[i];
				x[i] = 1;
			}else if (w[i] > cu) break;		
		}
		if(cu > 0){
			x[i] = cu/w[i];
		}
		return x;
	}
	public static void main(String[] args){
		int m = 20;
		int n = 3;
		float[] p = {24,15,25};
		float[] w = {15,10,18};
		float[] x = greedyKnap(m,n,p,w);
		for(int i = 0;i< n;i++){
			System.out.println(x[i]);
		}
	}
}
