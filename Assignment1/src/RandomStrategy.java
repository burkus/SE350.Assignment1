import java.util.Random;

public class RandomStrategy extends SearchStrategy {
	Random random = new Random();
	@Override
	public void search(int[][] grid) {
		// TODO Auto-generated method stub
		
		while(!coordsAreFound()) {
			int row = random.nextInt(25);
			int col = random.nextInt(25);
			int value = grid[row][col];
			
			numberOfCellsSearched += 1;
			
			if(value > 0) {
				String coords = consCoordString(row, col);
				if(contains(coords)) continue;
				
				if(value == 1) {
					// is a carrier cell
					carrierCoords.add(coords);
				}
				else {
					// is a submarine cell
					submarineCoords.add(coords);
				}
			}
			else continue;
		}
	}

}
