package theamabile.bronze.math.p11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt( br.readLine() );	
		
		int sqrt = (int)(Math.sqrt(n));
		int num = n;  
		
		for( int i=2 ; i<=sqrt ; i++)  {		
			//System.out.println( num+"/"+i+"="+(num/i)+".."+(num%i) );
			while( num%i == 0 ) { 
				System.out.println( i ); 
				num = num/i; // 3
			}
		}
		
		// �����ٱ����� ��ȸ�ؼ� ���� ���, ������ ���� ū �Ҽ��� �����ϴ� ��찡 ����  (�̶��� ������ �������� �ʾҴ� ���)
		if( num != 1) {
			System.out.println(num);
		}
	}

}
