package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}

		Applicant[] fileData = new Applicant[nbrOfRows];
		int i = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (!line.isEmpty()){
				// System.out.println("line " + line);
				String[] split = line.split(" ");
				
				String name = split[0] + " " + split[1];
				String grades = split[2];
				// System.out.println("Test: " + name + " " + grades);
	
				fileData[i] = new Applicant(name, grades);
				i++;
			}
		}
		return fileData; //Byt ut denna rad mot hela lösningen
	}
}
 

// • betyg1 är betyget i Programmering grundkurs
// • betyg2 är betyget i Programmering fördjupningskurs
// • betyg3 är betyget i Databasteknik
// • betyg4 är betyget i Objektorienterad Modellering och Design
// • betyg5 är betyget i Realtidsprogrammering
