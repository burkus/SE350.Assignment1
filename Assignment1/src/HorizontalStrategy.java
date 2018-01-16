
public class HorizontalStrategy extends SearchStrategy {

	@Override
	public void search(int[][] grid) {
		// TODO Auto-generated method stub
		for(int i = 0; i < grid.length && !coordsAreFound(); i++) {
			for(int j = 0; j < grid[i].length; j++) {
				numberOfCellsSearched += 1;
				int value = grid[i][j];
				if(value > 0) {
					String coords = consCoordString(i, j);
					if(contains(coords)) continue;
					
					if(value == 1) {
						carrierCoords.add(coords);
					}
					else {
						submarineCoords.add(coords);
					}
				}
				else continue;
			}
		}
	}
	
	public String getName() {
		return "Horizontal Search";
	}
}
