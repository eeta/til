package ch2_meaningful_name;

import java.util.ArrayList;
import java.util.List;

public class ClearIntention3 {
	
	public List<Cell> getFlaggedCells() {  // in 배열 대신, 칸을 간단한 클래스로 만듦
		List<Cell> flaggedCells = new ArrayList<Cell>();

		for (Cell cell : gameBoard)
			if (cell.isFlagged())  // isFlagged라는 명시적인 함수 사용
				flaggedCells.add(cell);
		return flaggedCells;
	}

}