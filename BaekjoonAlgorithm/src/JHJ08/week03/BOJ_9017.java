package BaekjoonAlgorithm.src.JHJ08.week03;

import java.io.*;
import java.util.*;

public class BOJ_9017 {

	// 백준 - 크로스 컨트리

	public static class TeamInfo
	{
		int cnt;
		int total;
		int fifth;

		public TeamInfo(int cnt, int total,int fifth)
		{
			this.cnt = cnt;
			this.total = total;
			this.fifth = fifth;
		}
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int inputCnt = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> cntMap = new HashMap<>();
		List<Integer> infoList = new ArrayList<>();
		HashMap<Integer, TeamInfo> teamInfoMap = new HashMap<>();

		// 1. 입력 정보 받고 저장 (개수, 입력 순서대로 입력받은 정보 저장)
		for(int i=0; i<inputCnt; i++)
		{
			cntMap.clear();
			infoList.clear();
			teamInfoMap.clear();

			StringTokenizer st = new StringTokenizer(br.readLine());

			int rankCnt = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for(int j=1; j<=rankCnt; j++)
			{
				int teamNum = Integer.parseInt(st.nextToken());

				if(cntMap.containsKey(teamNum))
				{
					int prevCnt = cntMap.get(teamNum);
					cntMap.put(teamNum, prevCnt+1);
				}
				else
				{
					cntMap.put(teamNum, 1);
				}

				infoList.add(teamNum);
			}

			// 2. 점수 계산
			int tmpRank = 1;
			for (int j = 0; j < infoList.size(); j++) {

				int teamNum = infoList.get(j);

				if(cntMap.get(teamNum) == 6)
				{
					if(teamInfoMap.containsKey(teamNum))
					{
						TeamInfo prev = teamInfoMap.get(teamNum);

						if(prev.cnt < 4)
						{
							teamInfoMap.put(teamNum, new TeamInfo(prev.cnt+1, prev.total+tmpRank, 0));
						}
						else if(prev.cnt == 4)
						{
							teamInfoMap.put(teamNum, new TeamInfo(prev.cnt+1, prev.total, tmpRank));
						}

					}
					else
					{
						teamInfoMap.put(teamNum,new TeamInfo(1,tmpRank,0));
					}

					tmpRank++;
				}
			}

			// 3. 우선순위에 따라 정렬하기
			int minTotal = 99999;
			int winTeam = -1;
			int minFifth = 99999;
			for (Map.Entry<Integer, TeamInfo> entry : teamInfoMap.entrySet()) {

				int teamNum = entry.getKey();
				TeamInfo info = entry.getValue();

				if(minTotal > info.total)
				{
					minTotal = info.total;
					minFifth = info.fifth;
					winTeam = teamNum;
				}
				else if(minTotal == info.total)
				{
					if(minFifth > info.fifth)
					{
						minTotal = info.total;
						minFifth = info.fifth;
						winTeam = teamNum;
					}
				}
			}

			// 결과값 출력
			System.out.println(winTeam);

		}
	}
}

