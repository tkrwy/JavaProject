package Pattern;

public class TestPrint {
	public static void main(String[] args){
		//确定最长一行的长度
		int n = 7;
		//确定最长一行的中间位置，即*******这行的中间位置是4，也是该行的行号
		int mid = (int)(n+1)/2;
		//打印上三角
		for(int i = 1; i <= mid; i++){
			int j = 0;
			//确定空格数
			int blank = mid - i;
			for (j = 0; j < blank; j++){
				System.out.print(" ");
			}
			//确定字符数
			int nch = 2*i -1;
			for(j = 0; j < nch; j++){
				System.out.print("*");
			}
			//回车
			System.out.println();
		}
		
		//打印下三角
		for (int i = 1; i < mid; i++){
			//确定空格数
			int blank = i;
			for(int j = 0; j < blank;j++){
				System.out.print(" ");
			}
			//确定字符数
			int nch = n - 2*blank;
			for(int j = 0; j < nch;j++){
				System.out.print("*");
			}
			//回车
			System.out.println();
		}
	}
}
