import org.jsoup.Jsoup;
import java.util.Map;
import java.util.HashMap;
import org.jsoup.nodes.Document; 
import java.io.IOException; 
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Response; 


public class DataScrape {
	private String baseURL;
	Document doc;
	Map<String, String> articleMap; 
	
	public DataScrape() {
		this.baseURL = "https://en.wikipedia.org/wiki/2016_United_States_presidential_election"; 
		try {
			this.doc = Jsoup.connect(this.baseURL).get();
		} catch (IOException e) {
		}
	}
	
	
    /**
     * Gets percentage of popular vote for either of the 
     * two main candidates - Trump or Clinton. 
     * @throws IO Exception
     * @param  Enter the name of the main candidate as a String.
     * Please enter their full name: Either "Donald John Trump"
     * or "Hillary Diane Rodham Clinton".
     * @returns Prints the percentage of the popular vote 
     */
	public double mainCandidatePopVote(String candidate) {
		Document mainCandidate = null;
        try {
            mainCandidate = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: mainCandidate.getElementsByTag("td")) {
	    	   if(td.text().contains(candidate)==true) {
	    		   String pop = td.nextElementSibling().nextElementSibling().nextElementSibling()
	    				   .nextElementSibling().text();
	    		   String adjusted = removeLastChar(pop, 1);
	    		   double number = Double.parseDouble(adjusted);
	    		   return number;		   
	    		   
	    		   
	    	   }
	       }
		return 0;
	}
	
	
	/*
	 *  Helper function to truncate string, will be used to remove 
	 *  percentage sign from data 
	 */
    public static String removeLastChar(String str, int charLast) {
        return str.substring(0, str.length() - charLast);
    }
	
	
	
    /**
     * Gets percentage of popular vote for all of the
     * Other candidates (Not Trump or Clinton)
     * @throws IO Exception
     * @param None
     * @returns double of the percentage of popular vote
     * for other candidates
     */
	
	public double otherPopVote() {
		double other = 100 - (mainCandidatePopVote("Donald John Trump")) - 
				(mainCandidatePopVote("Hillary Diane Rodham Clinton"));
		return other;
	}
	
	
    /**
     * Votes for Trump by Gender
     * @throws IO Exception
     * @param Enter Gender as a String
     * Enter either "Men" or "Women"
     * @returns percentage of chosen gender that voted
     * for Trump as an integer
     */
	public int trumpByGender(String gender) {
		Document trumpGender = null;
        try {
            trumpGender = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: trumpGender.getElementsByTag("td")) {
	    	   if(td.text().equals(gender)==true) {
	    		   String trump = td.nextElementSibling().nextElementSibling().text();
	    		   int number = Integer.parseInt(trump);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	}
	
	
	
    /**
     * Votes for Clinton by Gender
     * @throws IO Exception
     * @param Enter Gender as a String
     * Enter either "Men" or "Women"
     * @returns percentage of chosen gender that voted
     * for Clinton as an integer
     */
	public int clintonByGender(String gender) {
		Document clintonGender = null;
        try {
           clintonGender = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: clintonGender.getElementsByTag("td")) {
	    	   if(td.text().equals(gender)==true) {
	    		   String clinton = td.nextElementSibling().text();
	    		   int number = Integer.parseInt(clinton);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	}
	
	
	
    /**
     * Votes for Other Candidates (NOT Trump or Clinton)
     * by Gender
     * @throws IO Exception
     * @param Enter Gender as a String
     * Enter either "Men" or "Women"
     * @returns percentage of chosen gender that voted
     * for Other candidates as an integer
     */
	public int othersByGender(String gender) {
		return 100 - trumpByGender(gender) - clintonByGender(gender);
	}
	
	
    /**
     * Votes for Trump by Ideology
     * @throws IO Exception
     * @param Enter Ideology as a String
     * Enter either "Liberals" or "Moderates" or 
     * "Conservatives
     * @returns percentage of chosen ideology that voted
     * for Trump as an integer
     */
	public int trumpByIdeology(String ideology) {
		Document trumpIdeology = null;
        try {
            trumpIdeology = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: trumpIdeology.getElementsByTag("td")) {
	    	   if(td.text().equals(ideology)==true) {
	    		   String trump = td.nextElementSibling().nextElementSibling().text();
	    		   int number = Integer.parseInt(trump);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	
	}

        
	
    /**
     * Votes for Clinton by Ideology
     * @throws IO Exception
     * @param Enter Ideology as a String
     * Enter either "Liberals" or "Moderates" or 
     * "Conservatives
     * @returns percentage of chosen ideology that voted
     * for Clinton as an integer
     */
	public int clintonByIdeology(String ideology) {
		Document clintonIdeology = null;
        try {
           clintonIdeology = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: clintonIdeology.getElementsByTag("td")) {
	    	   if(td.text().equals(ideology)==true) {
	    		   String clinton = td.nextElementSibling().text();
	    		   int number = Integer.parseInt(clinton);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	}
	

    /**
     * Votes for Other Candidates (NOT Trump or Clinton)
     * by Ideology
     * @throws IO Exception
     * @param Enter Ideology as a String
     * Enter either "Liberals" or "Moderates" or 
     * "Conservatives
     * @returns percentage of chosen ideology that voted
     * for Other candidates as an integer
     */
	public int othersByIdeology(String ideology) {
		return 100 - trumpByIdeology(ideology) - clintonByIdeology(ideology);
	}
	
	
    /**
     * Votes for Trump by Age
     * @throws IO Exception
     * @param Enter Age as a String
     * Enter either "18–24 years old" or "25–29 years old" or "30–39 years old"
     * or "40–49 years old" or "50–64 years old" or "65 and older"
     * Make sure you are using an en dash, not a regular dash. On a Mac,
     * you can type this using Option + Dash(-). You MUST use an en dash
     * for this function to work.
     * @returns percentage of chosen age group that voted
     * for Trump as an integer
     */
	public int trumpByAge(String age) {
		Document trumpAge = null;
        try {
            trumpAge = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: trumpAge.getElementsByTag("td")) {
	    	   if(td.text().equals(age)==true) {
	    		   String trump = td.nextElementSibling().nextElementSibling().text();
	    		   int number = Integer.parseInt(trump);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	
	}
	
	
	
	
    /**
     * Votes for Clinton by Age
     * @throws IO Exception
     * @param Enter Age as a String
     * Enter either "18–24 years old" or "25–29 years old" or "30–39 years old"
     * or "40–49 years old" or "50–64 years old" or "65 and older"
     * Make sure you are using an en dash, not a regular dash. On a Mac,
     * you can type this using Option + Dash(-). You MUST use an en dash
     * for this function to work.
     * @returns percentage of chosen age group that voted
     * for Clinton as an integer
     */
	public int clintonByAge(String age) {
		Document clintonIdeology = null;
        try {
           clintonIdeology = Jsoup.connect(baseURL).get();
            
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        
		for (Element td: clintonIdeology.getElementsByTag("td")) {
	    	   if(td.text().equals(age)==true) {
	    		   String clinton = td.nextElementSibling().text();
	    		   int number = Integer.parseInt(clinton);
	    		   return number;		   	    		   
	    		   
	    	   }
	       }
		return 0;
	}
	
	
	
	
    /**
     * Votes for Other candidates (NOT Trump or Clinton) by Age
     * @throws IO Exception
     * @param Enter Age as a String
     * Enter either "18–24 years old" or "25–29 years old" or "30–39 years old"
     * or "40–49 years old" or "50–64 years old" or "65 and older"
     * Make sure you are using an en dash, not a regular dash. On a Mac,
     * you can type this using Option + Dash(-). You MUST use an en dash
     * for this function to work.
     * @returns percentage of chosen age group that voted
     * for Other candidates as an integer
     */
	public int othersByAge(String age) {
		return 100 - trumpByIdeology(age) - clintonByIdeology(age);
	}
	
	
		

		    	  
		    	  
	
		

	
}
