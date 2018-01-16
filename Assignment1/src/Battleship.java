import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Battleship {
	int boards[][][] = new int[3][25][25];
	SearchStrategy searchStrategy;
	
	public void readBoards(String fileName) {
		initializeBoards();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			int i = 0;
			int j = 0;
			while((line = reader.readLine()) != null) {
				int currentBoard[][] = boards[i];
				StringTokenizer tokenizer = new StringTokenizer(line, "(,)");
				int firstDigit, secondDigit;
				while(tokenizer.hasMoreTokens()) {
					firstDigit  = Integer.parseInt(tokenizer.nextToken());
					secondDigit = Integer.parseInt(tokenizer.nextToken());
					// carrier cells are of value 1
					// sub cells are of value 2
					if(j < 5) currentBoard[secondDigit][firstDigit] = 1;
					else currentBoard[secondDigit][firstDigit] = 2;
					j++;
				}
				i++;
				j = 0;
			}
			reader.close();
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initializeBoards() {
		for(int [][] i : boards) {
			for(int [] j : i) {
				for(int k = 0; k < j.length; k++) {
					j[k] = 0;
				}
			}
		}
	}
	
	public void printBoards() {
		for(int i = 0; i < boards.length; i++) {
			for(int j = 0; j < boards[i].length; j++) {
				for(int k = 0; k < boards[i][j].length; k++) {
					System.out.println("[" + i + "]" + "[" + j + "]" +
							"[" + k + "]" + "=" + boards[i][j][k]);
				}
			}
		}
	}
	
	public void setStrategy(SearchStrategy ss) {
		searchStrategy = ss;
	}
	
	public void runStrategy(int[][] grid) {
		searchStrategy.search(grid);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battleship bs = new Battleship();
		bs.readBoards("src/input.txt");
		bs.setStrategy(new HorizontalStrategy());
		bs.runStrategy(bs.boards[0]);
		System.out.println(bs.searchStrategy.getNumberOfCellsSearched());
		System.out.println(bs.searchStrategy.getCarrierCoords());
		System.out.println(bs.searchStrategy.getSubmarineCoords());
	}

}
