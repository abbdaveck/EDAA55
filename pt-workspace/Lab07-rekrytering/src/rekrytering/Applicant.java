package rekrytering;

public class Applicant implements Comparable<Applicant> {
	//Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;
	private String gradesAsString;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		this.gradesAsString = gradesAsString;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		// System.out.println(name + " " + gradesAsString + " Applicant.java");
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal
		for (int i = 0; i < g.length; i++) {
			
			if (g[i].contains("U")) {
				// Om underkänd så räknar vi det som en nolla
				grades[i] = 0;
			} else if (Character.isDigit(g[i].charAt(0))){
				grades[i] = Integer.parseInt(g[i]);;
			}
			else {
				grades[i] = 0;
			}
		}
	}

	public double getAvgGrade() {
		// System.out.println(name);
		double total = 0;
		for (int i=0; i<grades.length; i++){
			total += grades[i];
		}
		return total/grades.length; 
	}

	
	//   Implementera denna när labbeskrivningen kräver det 
	  public String toString() {
		String tempS = name + "[" + gradesAsString + "]" + "(avg: " + getAvgGrade() + ")";
	    //   Fyll i kod här 
		// System.out.println(tempS);
		return tempS;
	  }
	 

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar något < 0 om other är störst och returnerar 0 om objekten är lika.
	 * Används av javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
