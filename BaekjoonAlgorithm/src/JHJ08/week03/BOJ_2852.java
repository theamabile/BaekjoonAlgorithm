package BaekjoonAlgorithm.src.JHJ08.week03;

import java.io.*;
import java.util.*;

public class BOJ_2852 {

	// 백준 - NBA 농구

	static class ScoreInfo
	{
		int start;
		int end;
		int score1;
		int score2;

		public ScoreInfo(int start, int end, int score1, int score2)
		{
			this.start = start;
			this.end = end;
			this.score1=score1;
			this.score2=score2;
		}
	}
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<ScoreInfo> scoreInfoList = new ArrayList<>();

		int currentTime = 0;
		int score1 = 0;
		int score2 = 0;
		for(int i=1; i<=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String timeStr = st.nextToken();

			String [] minSec = timeStr.split(":");

			int min = Integer.parseInt(minSec[0]) * 60;
			int sec = Integer.parseInt(minSec[1]);

			if(team == 1)
			{
				scoreInfoList.add(new ScoreInfo(currentTime, min+sec,score1,score2));
				score1++;
				currentTime=min+sec;
			}

			if(team == 2)
			{
				scoreInfoList.add(new ScoreInfo(currentTime, min+sec,score1,score2));
				score2++;
				currentTime=min+sec;
			}
		}

		scoreInfoList.add(new ScoreInfo(currentTime, 2880, score1,score2));


		int winTime1 = 0;
		int winTime2 = 0;
		for(int i=1; i<scoreInfoList.size(); i++)
		{
			ScoreInfo info = scoreInfoList.get(i);

			if(info.score1 > info.score2)
			{
				winTime1 += (info.end - info.start);
				//System.out.println(info.start + " ~ " + info.end + " : " + info.score1 + "/" + info.score2);
			}
			else if(info.score1 < info.score2)
			{
				winTime2 += (info.end - info.start);
			}
		}

		int min1=0, sec1=0;
		int min2=0, sec2=0;

		sec1 = winTime1%60;
		min1 = (winTime1-sec1)/60;

		sec2 = winTime2%60;
		min2 = (winTime2-sec2)/60;

		System.out.println(String.format("%02d:%02d", min1, sec1));
		System.out.println(String.format("%02d:%02d", min2, sec2));
	}
}
