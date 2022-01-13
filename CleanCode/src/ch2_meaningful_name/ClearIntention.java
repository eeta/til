package ch2_meaningful_name;

import java.util.ArrayList;
import java.util.List;

public class ClearIntention {
	
	public List<int[]> getThem() {
		List<int[]> list1 = new ArrayList<int[]>();
		
		for (int[] x : theList)  // theList: 게임판
			// 게임판의 각 칸은 단순 배열로 표현. 0번째 값은 칸 상태. 값 4는 깃발이 꽂힌 상태
			if (x[0] == 4)
				list1.add(x);
		return list1;
	}
	
}