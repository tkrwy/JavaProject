package Pattern;

public class TestPrint {
	public static void main(String[] args){
		//ȷ���һ�еĳ���
		int n = 7;
		//ȷ���һ�е��м�λ�ã���*******���е��м�λ����4��Ҳ�Ǹ��е��к�
		int mid = (int)(n+1)/2;
		//��ӡ������
		for(int i = 1; i <= mid; i++){
			int j = 0;
			//ȷ���ո���
			int blank = mid - i;
			for (j = 0; j < blank; j++){
				System.out.print(" ");
			}
			//ȷ���ַ���
			int nch = 2*i -1;
			for(j = 0; j < nch; j++){
				System.out.print("*");
			}
			//�س�
			System.out.println();
		}
		
		//��ӡ������
		for (int i = 1; i < mid; i++){
			//ȷ���ո���
			int blank = i;
			for(int j = 0; j < blank;j++){
				System.out.print(" ");
			}
			//ȷ���ַ���
			int nch = n - 2*blank;
			for(int j = 0; j < nch;j++){
				System.out.print("*");
			}
			//�س�
			System.out.println();
		}
	}
}
