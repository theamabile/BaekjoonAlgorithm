package theamabile.bronze.bruteforce.p2798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Number 
 *
 */
public class Main {
	private static int n = 0;	 		// ī�� ����
	private static int m = 0;   		// ���ذ�
	private static int[] cards = null;	// �Է� ���� ī�� ����
	private static int result = 0;
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		boolean lastInput = false;
		
		while( (input = br.readLine()) != null ) {
			if( !lastInput ) {
				String[] inputs = input.split(" ");
				n = Integer.parseInt(inputs[0]);
				m = Integer.parseInt(inputs[1]);
				lastInput = true;
			} else {
				String[] inputs = input.split(" ");					
				cards = new int[n];
				int i=0;
				for( String str : inputs ) {
					cards[i++] = Integer.parseInt(str);						
				}					
				break;
			}	
		}
		
		if( br != null)  br.close();
	}	
	
	public static void calc() {
		int num = 0;		// �ݺ� �� �� ���� ��
		
		for( int i=0 ; i<n-2 ; i++ ) {   // ù��°ī��
			for( int j=i+1 ; j<n-1 ; j++ ) {    // �ι�°ī��
				for( int k=j+1 ; k<n ; k++ ) {   // ����°ī��
					num = cards[i] + cards[j] + cards[k];
					
					// ������� : ù° �ٿ� M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ����Ѵ�.
					if( num > m) {
						continue;
					} else {
						if( Math.abs(m-result) > Math.abs(m-num) ) {
							result = num;
						}
					}					
				}
			}
		}	
	}
	
	public static void main(String[] args) throws Exception {

		// 1. �Է°� �ʱ�ȭ
		init();

		// 2. ���� Ž������ ã��
		calc();
	
		// 3. ���
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		bw.write( String.valueOf(result) );
		bw.flush();
		if( bw != null)  bw.close();
	}
}
