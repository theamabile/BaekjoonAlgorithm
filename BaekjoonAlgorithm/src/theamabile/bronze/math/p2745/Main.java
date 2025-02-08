package theamabile.bronze.math.p2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String input = st.nextToken();			// 10�������� ��ȯ�� ����
		double beforeFormat = Double.parseDouble(st.nextToken());	// ��ȯ �� ����
				
		char num;
		int sum = 0;
		double value = 0;	// �ڸ��� ������ ���� ����
		
		int digit = 0;
		for( int i=0 ; i<input.length() ; i++) {
			num = input.charAt(input.length()-1-i);
			if( Character.isDigit(num) ) {		
				digit = Integer.parseInt( String.valueOf(num) ); // ���ڰ� �Էµ�
			} else {	
				digit = (int)num - 55;  // ���ڰ� �Էµ�. ������ �ƽ�Ű�ڵ忡��=12=55�� �����	
			}
			
			value = Math.pow(beforeFormat, i);		// �ڸ��� ������			
			sum += (int)(digit * value);
		}
		System.out.println( sum );
		
		if(br != null) br.close();
	}

}