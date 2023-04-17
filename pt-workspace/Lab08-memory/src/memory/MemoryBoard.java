package memory;
import java.util.concurrent.ThreadLocalRandom;


public class MemoryBoard {

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	private int size;
	private String backFileName;
	public String[][] boardMatrix;
	public Boolean[][] frontOrBack;
	

	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		this.backFileName = backFileName;
		createCards(backFileName, frontFileNames);
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		boardMatrix = new String[size][size];
		frontOrBack = new Boolean[size][size];
		for (int i = 0; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix.length; j++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, 8);		 //Random nummer
				int exist = checkIfDoubble(boardMatrix, frontFileNames[randomNum]);				//Kollar om jag redan ritat ut två av de kortet
				frontOrBack[i][j] = false;														//Alla kort börjar med baksidan mot spelaren
			if (exist != 2){																	//Om kortet inte ritats ut två gånger gör jag det här
					boardMatrix[i][j] = frontFileNames[randomNum];
				}
				else {																			//Annars gör jag om det tills jag hittat ett kort som inte ritats ut två gånger
					while (exist > 1){
						randomNum = ThreadLocalRandom.current().nextInt(0, 8);
						exist = checkIfDoubble(boardMatrix, frontFileNames[randomNum]);
						boardMatrix[i][j] = frontFileNames[randomNum];
					}
				}
			}
		}
	}

	private int checkIfDoubble(String[][] matix, String card){				//Räknar antalet gånger jag ritat ut ett kort
		int i = 0;
		for (int l = 0; l < matix.length; l++) {
			for (int l2 = 0; l2 < matix.length; l2++) {
				if (matix[l][l2] == card){
					i++;
				}
			}
		}
		return i;
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		MemoryCardImage mc = new MemoryCardImage(boardMatrix[r][c], backFileName);
		return mc;
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		frontOrBack[r][c] = !frontOrBack[r][c];
		
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return frontOrBack[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (boardMatrix[r1][c1] == boardMatrix[r2][c2]){
			return true;
		}
		else{
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon(Boolean[][] matrix) {
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == true){
					k++;
				}
			}
		}
		if (k==16){
			return true;
		}
		else {
			return false;
		}
	}	
}
