package BaekjoonAlgorithm.src.JHJ08.week03;

import java.util.*;
import java.io.*;

public class BOJ_2745 {

	// 백준 - 진법 변환

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String n = st.nextToken();
		long b = Long.parseLong(st.nextToken());

		long res = 0;
		for(int i=0; i<n.length(); i++)
		{
			int tmp = n.length() - (i+1);

			if(n.charAt(i) >= '0' && n.charAt(i) <= '9')
			{
				int value = n.charAt(i) - '0'; // 숫자는 그대로 변환
				res += value*Math.pow(b,tmp);
			}
			else if(n.charAt(i) >= 'A' && n.charAt(i) <= 'Z')
			{
				int value = n.charAt(i) - 'A' + 10; // 'A'는 10, 'B'는 11, ..., 'Z'는 35
				res += value*Math.pow(b,tmp);
			}
		}

		System.out.println(res);
	}
}

