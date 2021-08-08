import java.io.IOException;

public class DataScrapeMain {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		DataScrape s = new DataScrape();
		
		// Popular Vote for Main Candidates
		String popular = String.valueOf(s.mainCandidatePopVote("Donald John Trump"));
		System.out.println(popular);
		
		// Popular Vote for Other Candidates
		String others = String.valueOf(s.otherPopVote());
		System.out.println(others);
		
		
		// Votes for Trump by Gender
		String trumpGender = String.valueOf(s.trumpByGender("Men"));
		System.out.println(trumpGender);
		
		// Votes for Clinton by Gender
		String clintonGender = String.valueOf(s.clintonByGender("Women"));
		System.out.println(clintonGender);
		
		// Votes for Others by Gender
		String othersGender = String.valueOf(s.othersByGender("Men"));
		System.out.println(othersGender);
		
		// Votes for Trump by Ideology
		String trumpIdeology = String.valueOf(s.trumpByIdeology("Moderates"));
		System.out.println(trumpIdeology);
		
		// Votes for Clinton by Ideology
		String clintonIdeology = String.valueOf(s.clintonByIdeology("Liberals"));
		System.out.println(clintonIdeology);
		
		// Votes for Others by Ideology
		String othersIdeology = String.valueOf(s.othersByIdeology("Conservatives"));
		System.out.println(othersIdeology);
		
		// Votes for Trump by Age
		String trumpAge = String.valueOf(s.trumpByAge("25–29 years old")); 
		System.out.println(trumpAge);
		
		// Votes for Clinton by Age
		String clintonAge = String.valueOf(s.clintonByAge("65 and older")); 
		System.out.println(clintonAge);
		
		// Votes for Others by Age
		String othersAge = String.valueOf(s.othersByAge("40–49 years old")); 
		System.out.println(othersAge);
		
	}
	
	

}
