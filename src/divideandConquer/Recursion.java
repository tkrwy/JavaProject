package divideandConquer;

public class Recursion {
	public static int fab(int n){
		if(n <= 2){
			return 1;
		}else{
			return fab(n-1) + fab(n-2);
		}
	}
	//�жϻ�����
	public static boolean huiWen(char[] str, int from, int to){
		if (from  >= to) return true;//�ݹ��������
		if(str[from++] == str[to--]) return huiWen(str,from,to);
		return false;
	}
	public static void main(String[] args){
		System.out.println(fab(5));
		//����
		String str = "abcdedcba";
		char[] stra = str.toCharArray();
		System.out.println(huiWen(stra,0,stra.length - 1));
	}
}
