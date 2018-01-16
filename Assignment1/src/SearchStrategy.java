import java.util.List;
import java.util.LinkedList;

public abstract class SearchStrategy {
	List<String> carrierCoords = new LinkedList<String>();
	List<String> submarineCoords = new LinkedList<String>();
	int numberOfCellsSearched = 0;
	
	public abstract void search(int grid[][]);
	
	public String consCoordString(int row, int col) {
		return "(" + col + "," + row + ")";
	}
	
	public int getNumberOfCellsSearched() {
		return numberOfCellsSearched;
	}
	
	public String getCarrierCoords() {
		String concatCoords = "";
		for(String s : carrierCoords) concatCoords += s;
		return concatCoords;
	}
	
	public String getSubmarineCoords() {
		String concatCoords = "";
		for(String s : submarineCoords) concatCoords += s;
		return concatCoords;
	}
	
	public boolean coordsAreFound() {
		return submarineCoords.size() + carrierCoords.size() == 8;
	}
	
	public boolean contains(String coords) {
		return carrierCoords.contains(coords) ||
				submarineCoords.contains(coords);
	}
	
	public abstract String getName();
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "\n");
		sb.append("Carrier Coordinates: ");
		sb.append(getCarrierCoords() + "\n");
		sb.append("Submarine Coordindates: ");
		sb.append(getSubmarineCoords() + "\n");
		sb.append("Number of Cells Searched: " + getNumberOfCellsSearched());
		return sb.toString();
	}
	
	public void reset() {
		numberOfCellsSearched = 0;
		carrierCoords.clear();
		submarineCoords.clear();
	}
}
