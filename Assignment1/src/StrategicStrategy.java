
public class StrategicStrategy extends SearchStrategy {

	@Override
	public void search(int[][] grid) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean continuesDownward(int row, int col, int[][] grid) {
		return grid[row + 1][col] > 0;
	}
	
	public boolean continuesRight(int row, int col, int[][] grid) {
		return grid[row][col + 1] > 0;
	}

}
