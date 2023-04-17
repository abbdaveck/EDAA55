package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.0;

	public static void main(String[] args) {
		FileReader f = new FileReader();
		
        Applicant[] gradesAndNames = f.readFromFile("./Lab07-rekrytering/applications_all.txt", 231);

		Applicant[] best = findBestCandidates(gradesAndNames);
		Arrays.sort(best);
		for (int i = 0; i < best.length; i++) {
			String testBest = best[i].toString();
			System.out.println("Passed: " + testBest);
		}

        
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		// try{
			
		int j = 0;
		System.out.println("applicants.length: " + applicants.length);
		for (int i = 0; i < applicants.length; i++) {
			try{
				
				double avg = applicants[i].getAvgGrade();
				// String str = applicants[i].toString();
				if (avg >= MIN_AVG_GRADE){
					j++;
					// System.out.println(str);
				}
			}
			catch(Exception e){
				;
			}

		}
		System.out.println("\n");
		Applicant[] bestCandidates = new Applicant[j];
		j = 0;
		for (int i = 0; i < applicants.length; i++) {
			try{

				double avg = applicants[i].getAvgGrade();
				String str = applicants[i].toString();
				if (avg >= MIN_AVG_GRADE){
					// System.out.println(str);
					String[] splt = str.split("\\[");
					String name = splt[0];
					String grades = splt[1].split("]")[0];
					// System.out.println("Chosen: " + name + " " + grades + " " + j);
					bestCandidates[j] = new Applicant(name, grades);
					j++;
				}
			}
			catch(Exception e){
				;
			}
		}
		return bestCandidates; //Byt ut denna rad mot hela din egen lösning
			
		// }
		// catch(Exception e){
		// 	return null;
		// }
	}
}
 