package restassured_bdd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		SuperHeroMoviesAndTVSeries heroMoviesAndTVSeries = new SuperHeroMoviesAndTVSeries();
		
		heroMoviesAndTVSeries.setCategory("Super Hero Movies & TV Series");
		
		List<String> acceptedFranchises = new ArrayList<String>();
		acceptedFranchises.add("DC");
		acceptedFranchises.add("Marvel");
		
		heroMoviesAndTVSeries.setAcceptedFranchises(acceptedFranchises);
		
		List<String> genres = new ArrayList<String>();
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Survival");
		genres.add("Dark");
		
		heroMoviesAndTVSeries.setGenres(genres);
		
		List<Movies> allMovies = new ArrayList<Movies>();
		List<TVSeries> allTVSeries = new ArrayList<TVSeries>();

		
		Movies batman = new Movies ();
		batman.setTitle("The Dark Night");
		batman.setYear(2008);
		
		allMovies.add(batman);
		
		List<String> batmanCast = new ArrayList<String>();
		batmanCast.add("Bale");
		batmanCast.add("Ledger");
		batman.setCast(batmanCast);
		
		Movies justiceLeague = new Movies ();
		justiceLeague.setTitle("Justice League");
		justiceLeague.setYear(2008);
		
		allMovies.add(justiceLeague);
		
		List<String> justiceLeagueCast = new ArrayList<String>();
		justiceLeagueCast.add("Gadot");
		justiceLeagueCast.add("Cavil");
		
		justiceLeague.setCast(justiceLeagueCast);
		
		Movies avengers = new Movies ();
		avengers.setTitle("Avengers: Endgame");
		avengers.setYear(2019);
		
		allMovies.add(avengers);
		
		List<String> avengersCast = new ArrayList<String>();
		avengersCast.add("Downey");
		avengersCast.add("Evans");
		
		avengers.setCast(avengersCast);
		
		TVSeries flash = new TVSeries();
		flash.setTitle("Flash");
		flash.setYear(2014);
		
		allTVSeries.add(flash);
		
		TVSeries gotham = new TVSeries();
		gotham.setTitle("Gotham");
		gotham.setYear(2014);
		
		allTVSeries.add(gotham);
		
		TVSeries superGirl = new TVSeries();
		superGirl.setTitle("Super Girl");
		superGirl.setYear(2015);
		
		allTVSeries.add(superGirl);
		
		OtherDetails details = new OtherDetails();
		details.setCountry("Only USA");
		details.setLanguage("Only English");
		
		heroMoviesAndTVSeries.setMovies(allMovies);
		heroMoviesAndTVSeries.setTvSeries(allTVSeries);
		heroMoviesAndTVSeries.setOtherDetails(details);
		
		ObjectMapper mapper = new ObjectMapper();
		
		File superJson = new File("complex.json");
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(superJson, heroMoviesAndTVSeries);
		
	}

}
