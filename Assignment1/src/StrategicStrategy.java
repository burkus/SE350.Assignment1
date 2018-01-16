import java.util.Random;

public class StrategicStrategy extends SearchStrategy {
	Random random = new Random();
	@Override
	public void search(int[][] grid) {
		// TODO Auto-generated method stub
		
		while(!coordsAreFound()) {
			int row = randomEvenInteger();
			int col = randomEvenInteger();
			exploreCell(row, col, grid);
		}
	}
	
	private void exploreCell(int row, int col, int[][] grid) {
		numberOfCellsSearched += 1;
		int value = grid[row][col];
		
		if(value > 0) {
			String coords = consCoordString(row, col);
			if(contains(coords)) return;
			else if(value == 1) {
				carrierCoords.add(coords);
			}
			else {
				submarineCoords.add(coords);
			}
			// check other cells
			if(continuesDownward(row, col, grid)) {
				exploreCell(row + 1, col, grid);
			}
			if(continuesUpward(row, col, grid)) {
				exploreCell(row - 1, col, grid);
			}
			if(continuesRight(row, col, grid)) {
				exploreCell(row, col + 1, grid);
			}
			if(continuesLeft(row, col, grid)) {
				exploreCell(row, col - 1, grid);
			}
		}
	}
	
	private int randomEvenInteger() {
		return random.nextInt(25);
	}
	
	private boolean continuesDownward(int row, int col, int[][] grid) {
		return row + 1 < grid.length && grid[row + 1][col] > 0;
	}
	
	private boolean continuesRight(int row, int col, int[][] grid) {
		return col + 1 < grid[row].length && grid[row][col + 1] > 0;
	}

	private boolean continuesLeft(int row, int col, int[][] grid) {
		return col - 1 >= 0 && grid[row][col - 1] > 0;
	}
	
	private boolean continuesUpward(int row, int col, int[][] grid) {
		return row - 1 >= 0 && grid[row - 1][col] > 0;
	}
	
	public String getName() {
		return "Strategic Search";
	}
}
