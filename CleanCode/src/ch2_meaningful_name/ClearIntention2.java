package ch2_meaningful_name;

import java.util.ArrayList;
import java.util.List;

public class ClearIntention2 {
	
	public List<int[]> getFlaggedCells() {
		List<int[]> flaggedCells = new ArrayList<int[]>();
		
		for (int[] cell : gameBoard)  // gameBoard: 게임판
			if (cell[STATUS_VALUE] == FLAGGED)
				flaggedCells.add(cell);
		return flaggedCells;
	}

}