package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String back = "./Lab08-memory/back.jpg";
        String[] fronts = {
			"./Lab08-memory/can.jpg",
			"./Lab08-memory/flopsy_mopsy_cottontail.jpg",
			"./Lab08-memory/friends.jpg",
			"./Lab08-memory/mother_ladybird.jpg",
			"./Lab08-memory/mr_mcgregor.jpg",
			"./Lab08-memory/mrs_rabbit.jpg",
			"./Lab08-memory/mrs_tittlemouse.jpg",
			"./Lab08-memory/radishes.jpg"
    	};

		int size = 4;
		MemoryBoard mb = new MemoryBoard(size, back, fronts);
		MemoryWindow mw = new MemoryWindow(mb);

		mw.drawBoard();
		Boolean[][] turnedMatrix;
		Boolean[][] finishedCards = new Boolean[size][size];
		int lastRow = 0;
		int lastCol = 0;

		for (int i = 0; i < finishedCards.length; i++) {		//Skapar matrisen med avklarade kort och sätter alla till false
			for (int j = 0; j < finishedCards.length; j++) {
				finishedCards[i][j] = false;
			}
		}
		Boolean winner = false;
		int tries = 1;

		while (!winner){
			// do {
			// 	mw.waitForMouseClick();
			// 	int x = mw.getClickedX();
			// 	int y = mw.getClickedY();
			// }
			// while(mb.frontUp(x, y));

			int i = 0;
			tries++;
			mw.waitForMouseClick();
			turnedMatrix = mb.frontOrBack;
			for (int j = 0; j < turnedMatrix.length; j++) {			//Funktion för att kolla hur många kort som är vända
				for (int j2 = 0; j2 < turnedMatrix.length; j2++) {
					if (turnedMatrix[j][j2] == true && finishedCards[j][j2] != true){		//Bortser från paren
						i++;
					}
				}
			}
			if (i>1){												//Om två kort redan är vända vänder den tillbaka alla
				hideCards(mb, turnedMatrix, finishedCards);
				mw.drawBoard();
				lastCol = 0;
				lastRow = 0;
			}

			int clickRow = mw.getMouseRow();
			int clickCol = mw.getMouseCol();
			if (!finishedCards[clickRow][clickCol]){				//Gör så du inte kan vända par som redan har blivit hittade
				mb.turnCard(clickRow, clickCol);
				mw.drawCard(clickRow, clickCol);
			}
			
			if (mb.same(clickRow, clickCol, lastRow, lastCol)){		//Om korten är samma ändrar jag matrisen med avklarade kort för att inkluder de nya korten

				if(!(clickRow == lastRow && clickCol == lastCol)){
					finishedCards[clickRow][clickCol] = true;
					finishedCards[lastRow][lastCol] = true;
				}
			}
			lastRow = mw.getMouseRow();								//Gör så koden kommer senaste kortet jag klickade på
			lastCol = mw.getMouseCol();
			if (mb.hasWon(finishedCards)){							//Om jag vinner bryter den loopen
				System.out.println("You won" + "\n" + "Number of tries: " + tries);
				winner = true;
			}
			
		}
	}

	public static void hideCards(MemoryBoard mem, Boolean[][] matrix, Boolean[][] finished){		//Funktion för att gömma kort
		for (int j = 0; j < matrix.length; j++) {
			for (int j2 = 0; j2 < matrix.length; j2++) {
				if (finished[j][j2] != true){			//Vänder tillbaka alla kort förutom paren
					mem.frontOrBack[j][j2] = false;
				}
			}
		}
	}
}
