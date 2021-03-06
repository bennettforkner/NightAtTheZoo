import java.util.ArrayList;
/**
 * data_names is the class to store data for getting random names,
 * downloaded from a name generator
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class data_names {
	
	/**
	 * Name is a subclass that allows the connection of a first name with a last name
	 * @author Bennett Forkner
	 *
	 */
	public static class Name {
		
		/**
		 * The first name
		 */
		public String first;
		
		/**
		 * The last name
		 */
		public String last;
		
		/**
		 * The constructor for a Name Object
		 * 
		 * @param first The first name
		 * @param last The last name
		 */
		public Name(String first,String last) {
			
			// Set instance variables to passed parameters
			this.first = first;
			this.last = last;
			
		}
		
		/**
		 * The method to set the default way of turning this object to a String
		 */
		public String toString() {
			
			return first + " " + last;
			
		}
	}
	
	/**
	 * The static ArrayList of names that can be used
	 */
	private static ArrayList<Name> names = new ArrayList<Name>();
	
	/**
	 * The method to get a random name from the list of names
	 * @return a random name
	 */
	public static Name getRandomName() {
		
		// Conditional if the names list is initialized with data
		if (names.size() <= 0) {
			
			// Add names to list
			names.add(new Name("Diamanda","Underhill"));
			names.add(new Name("Dinodas","Gaukrogers"));
			names.add(new Name("Marmaduc","Brown"));
			names.add(new Name("Asphodel","Smallburrow"));
			names.add(new Name("Banazir","Hornblower"));
			names.add(new Name("Nina","Smallburrow"));
			names.add(new Name("Pansy","Oldbuck"));
			names.add(new Name("Filibert","Hayward"));
			names.add(new Name("Mentha","Goodbody"));
			names.add(new Name("Maxima","Bunce"));
			names.add(new Name("Mantissa","Grubb"));
			names.add(new Name("Belladonna","Banks"));
			names.add(new Name("Theodoric","Tunnelly"));
			names.add(new Name("Peregrin","Sackville"));
			names.add(new Name("Bell","Took-Took"));
			names.add(new Name("Reginard","Galbassi"));
			names.add(new Name("Wilibald","Proudfoot"));
			names.add(new Name("Hob","Bolger-Baggins"));
			names.add(new Name("Athanaric","Bolger-Baggins"));
			names.add(new Name("Moro","Lightfoot"));
			names.add(new Name("Otho","Bracegirdle"));
			names.add(new Name("Alaric","Twofoot"));
			names.add(new Name("Ruby","Brockhouse"));
			names.add(new Name("Adelgrim","Goodbody"));
			names.add(new Name("Bellisima","Lightfoot"));
			names.add(new Name("Robinia","Brockhouse"));
			names.add(new Name("Isengar","Oldbuck"));
			names.add(new Name("Maxima","Fairbairn"));
			names.add(new Name("Hildibrand","Hogpen"));
			names.add(new Name("Adaldrida","Bolger"));
			names.add(new Name("Olo","Bolger-Baggins"));
			names.add(new Name("Ferumbras","Goodchild"));
			names.add(new Name("Lamorac","Puddifoot"));
			names.add(new Name("Sago","Burrowes"));
			names.add(new Name("Daisy","Took-Brandybuck"));
			names.add(new Name("Gloriana","Gawkroger"));
			names.add(new Name("Seredic","Tunnelly"));
			names.add(new Name("Marigold","Brockhouse"));
			names.add(new Name("Moro","Maggot"));
			names.add(new Name("Alberic","Banks"));
			names.add(new Name("Marmaduc","Tunnelly"));
			names.add(new Name("Habaccuc","Smallburrow"));
			names.add(new Name("Vigo","Boffin"));
			names.add(new Name("Flambard","Chubb-Baggins"));
			names.add(new Name("Hilda","Brandybuck"));
			names.add(new Name("Alaric","Gaukrogers"));
			names.add(new Name("Habaccuc","Button"));
			names.add(new Name("Prospero","Whitfoot"));
			names.add(new Name("Smeagol","Proudfoot"));
			names.add(new Name("Pamphila","Lothran"));
			names.add(new Name("Lalia","Proudfoot"));
			names.add(new Name("Marroc","Brown"));
			names.add(new Name("Selina","Headstrong"));
			names.add(new Name("Merry","Button"));
			names.add(new Name("Maura","Proudfoot"));
			names.add(new Name("Scudamor","Smallburrow"));
			names.add(new Name("Goldilocks","Lothran"));
			names.add(new Name("Isembold","Gawkroger"));
			names.add(new Name("Basso","Lothran"));
			names.add(new Name("Robur","Brown"));
			names.add(new Name("Regina","Gammidge"));
			names.add(new Name("Rufus","Roper"));
			names.add(new Name("Halfred","Sandheaver"));
			names.add(new Name("Rhoda","Bolger"));
			names.add(new Name("Fosco","Goldworthy"));
			names.add(new Name("Ruby","Smallburrow"));
			names.add(new Name("Amalda","Sandyman"));
			names.add(new Name("Faramir","Sackville"));
			names.add(new Name("Saradas","Noakes"));
			names.add(new Name("Gundabald","Brown"));
			names.add(new Name("Caradoc","Baggins"));
			names.add(new Name("Otho","Diggle"));
			names.add(new Name("Briffo","Proudfoot"));
			names.add(new Name("Hob","Gammidge"));
			names.add(new Name("Flavus","Boffin"));
			names.add(new Name("Hildigard","Hogpen"));
			names.add(new Name("GivenName","Surname"));
			names.add(new Name("Darrick","Colby"));
			names.add(new Name("John","Crivello"));
			names.add(new Name("Joseph","Tweed"));
			names.add(new Name("Nellie","Dill"));
			names.add(new Name("Cynthia","Richey"));
			names.add(new Name("Ted","Greene"));
			names.add(new Name("Emilia","Hart"));
			names.add(new Name("George","Eichner"));
			names.add(new Name("Charles","Miller"));
			names.add(new Name("Charles","Lehman"));
			names.add(new Name("Catherine","Kearney"));
			names.add(new Name("Arthur","Gooden"));
			names.add(new Name("Thomas","Harris"));
			names.add(new Name("George","Loya"));
			names.add(new Name("Terry","Lau"));
			names.add(new Name("Rodney","Polson"));
			names.add(new Name("Brian","Peralta"));
			names.add(new Name("Susan","Kujawski"));
			names.add(new Name("Robert","Floyd"));
			names.add(new Name("Angel","Napoleon"));
			names.add(new Name("Kenneth","Dwyer"));
			names.add(new Name("Danny","Weir"));
			names.add(new Name("Shannon","Stevens"));
			names.add(new Name("Brian","McGuire"));
			names.add(new Name("Jack","Wilton"));
			names.add(new Name("Lakiesha","Sullivan"));
			names.add(new Name("Allan","Regalado"));
			names.add(new Name("Larry","Naples"));
			names.add(new Name("Robert","Haynes"));
			names.add(new Name("William","Saldana"));
			names.add(new Name("Patricia","Warner"));
			names.add(new Name("Louis","Pearlman"));
			names.add(new Name("Dennis","Squire"));
			names.add(new Name("Arthur","Ashworth"));
			names.add(new Name("Ralph","Sevilla"));
			names.add(new Name("Donald","Kane"));
			names.add(new Name("Renee","Weyant"));
			names.add(new Name("Daniel","Middleton"));
			names.add(new Name("Eric","Connors"));
			names.add(new Name("Chris","Wilson"));
			names.add(new Name("Constance","Hoover"));
			names.add(new Name("David","Lee"));
			names.add(new Name("Michelle","Ratner"));
			names.add(new Name("Pablo","Kinney"));
			names.add(new Name("Jeffery","Emanuel"));
			names.add(new Name("James","Bracken"));
			names.add(new Name("John","Wyant"));
			names.add(new Name("John","Magnusson"));
			names.add(new Name("Richard","Lopez"));
			names.add(new Name("Richard","Hensley"));
			names.add(new Name("Milton","Batz"));
			names.add(new Name("Stacey","Baker"));
			names.add(new Name("Stewart","Kim"));
			names.add(new Name("Laura","Wilson"));
			names.add(new Name("Frank","Wolcott"));
			names.add(new Name("William","Perry"));
			names.add(new Name("Mohamed","Newsome"));
			names.add(new Name("Donna","Martin"));
			names.add(new Name("Isidro","Rapp"));
			names.add(new Name("Derrick","Satchell"));
			names.add(new Name("Herbert","Bradley"));
			names.add(new Name("Paul","Pena"));
			names.add(new Name("Leslie","Smith"));
			names.add(new Name("Lavonne","Easterling"));
			names.add(new Name("Chris","Blackburn"));
			names.add(new Name("Myron","Studer"));
			names.add(new Name("Arlette","Verdin"));
			names.add(new Name("James","Wren"));
			names.add(new Name("Jason","Bennett"));
			names.add(new Name("Percy","Burmeister"));
			names.add(new Name("Cory","Anderson"));
			names.add(new Name("Brandie","Jones"));
			names.add(new Name("William","Ungar"));
			names.add(new Name("Elizabeth","Herren"));
			names.add(new Name("Corey","McGahey"));
			names.add(new Name("Alton","Portillo"));
			names.add(new Name("Reginald","Debord"));
			names.add(new Name("Justine","Hucks"));
			names.add(new Name("Dolores","Shook"));
			names.add(new Name("Sidney","Ramirez"));
			names.add(new Name("Christopher","Holmes"));
			names.add(new Name("Marlon","Roseberry"));
			names.add(new Name("Mildred","Blevins"));
			names.add(new Name("Kenneth","Miller"));
			names.add(new Name("James","Larson"));
			names.add(new Name("Blair","Convery"));
			names.add(new Name("Mary","Crumley"));
			names.add(new Name("Steven","McWilliams"));
			names.add(new Name("Betty","Dostie"));
			names.add(new Name("Thomas","Burns"));
			names.add(new Name("Kevin","Foster"));
			names.add(new Name("Kimberly","Taylor"));
			names.add(new Name("Linda","Hopson"));
			names.add(new Name("Harvey","Westfall"));
			names.add(new Name("Pamala","Kennedy"));
			names.add(new Name("Nelson","Mendoza"));
			names.add(new Name("Eric","Weakley"));
			names.add(new Name("Kristy","Sommers"));
			names.add(new Name("Eddie","Hill"));
			names.add(new Name("Fred","Dolan"));
			names.add(new Name("Donna","Lambert"));
			names.add(new Name("Alan","Garner"));
			names.add(new Name("Melvin","Ramsey"));
			names.add(new Name("Michael","Garcia"));
			names.add(new Name("James","Brewer"));
			names.add(new Name("Brad","Gossage"));
			names.add(new Name("Dennis","Matthews"));
			names.add(new Name("Shannon","Westhoff"));
			names.add(new Name("Ricky","Rudnick"));
			names.add(new Name("Stephen","Slavin"));
			names.add(new Name("Robert","Pope"));
			names.add(new Name("Marco","Romero"));
			names.add(new Name("Jeffrey","Matheson"));
			names.add(new Name("Jeffrey","Riggins"));
			names.add(new Name("Brandon","Hicks"));
			names.add(new Name("Matthew","Santos"));
			names.add(new Name("John","Bryson"));
			names.add(new Name("Chris","Garon"));
			names.add(new Name("Tim","Owings"));
			names.add(new Name("Beverly","Decker"));
			names.add(new Name("Robert","Byers"));
			names.add(new Name("Adam","Curtis"));
			names.add(new Name("Michael","Vaughn"));
			names.add(new Name("Barbara","Ramirez"));
			names.add(new Name("Bradford","Gentry"));
			names.add(new Name("William","Brennan"));
			names.add(new Name("Elmer","Winters"));
			names.add(new Name("Elizabeth","Soule"));
			names.add(new Name("Rebecca","Rosenthal"));
			names.add(new Name("Robert","Weller"));
			names.add(new Name("Edward","Anderson"));
			names.add(new Name("Danny","Storer"));
			names.add(new Name("John","Rogers"));
			names.add(new Name("Tracy","Salmon"));
			names.add(new Name("Bobby","Banuelos"));
			names.add(new Name("John","Caudill"));
			names.add(new Name("Jerome","Fontenot"));
			names.add(new Name("Lilian","Mendez"));
			names.add(new Name("Kathy","Quintero"));
			names.add(new Name("Steven","Reilly"));
			names.add(new Name("Byron","Dwyer"));
			names.add(new Name("Chuck","Markley"));
			names.add(new Name("Walter","Lenhardt"));
			names.add(new Name("Kenneth","Millsap"));
			names.add(new Name("Herman","Vang"));
			names.add(new Name("Susan","Sanchez"));
			names.add(new Name("Kristine","McCullers"));
			names.add(new Name("Nancy","Bryner"));
			names.add(new Name("Wanda","Livingston"));
			names.add(new Name("Christina","Alfaro"));
			names.add(new Name("Nicholas","Hay"));
			names.add(new Name("Craig","Levine"));
			names.add(new Name("James","Beach"));
			names.add(new Name("Vonnie","Starrett"));
			names.add(new Name("Harold","Cuneo"));
			names.add(new Name("Arthur","Nichols"));
			names.add(new Name("George","Potter"));
			names.add(new Name("Walter","Dieter"));
			names.add(new Name("Matthew","Vinson"));
			names.add(new Name("Brenda","Barrette"));
			names.add(new Name("William","Cowie"));
			names.add(new Name("Rosa","White"));
			names.add(new Name("Howard","Smith"));
			names.add(new Name("Alice","Ettinger"));
			names.add(new Name("Timothy","Hanley"));
			names.add(new Name("Pamela","Gonzalez"));
			names.add(new Name("William","Mar"));
			names.add(new Name("Joseph","Hooker"));
			names.add(new Name("Justin","Brown"));
			names.add(new Name("David","Millen"));
			names.add(new Name("Lynn","Labelle"));
			names.add(new Name("Rodney","Milligan"));
			names.add(new Name("Joseph","Madden"));
			names.add(new Name("Carl","Gonzales"));
			names.add(new Name("Lucia","Carey"));
			names.add(new Name("Roberta","Drewes"));
			names.add(new Name("Darrell","Harris"));
			names.add(new Name("Ian","McClure"));
			names.add(new Name("Bettie","Newton"));
			names.add(new Name("Justin","Bonnet"));
			names.add(new Name("Lisa","Dillion"));
			names.add(new Name("Vernon","Dunn"));
			names.add(new Name("David","Ross"));
			names.add(new Name("Christopher","Deal"));
			names.add(new Name("Michael","Foreman"));
			names.add(new Name("John","Burritt"));
			names.add(new Name("Leroy","Randle"));
			names.add(new Name("Larry","Turner"));
			names.add(new Name("Barry","Rhem"));
			names.add(new Name("Michael","Henderson"));
			names.add(new Name("Fredrick","Pearson"));
			names.add(new Name("Gary","Baca"));
			names.add(new Name("Anthony","Nolette"));
			names.add(new Name("Andres","Zuniga"));
			names.add(new Name("Elizabeth","Duda"));
			names.add(new Name("Leonard","Dorsey"));
			names.add(new Name("Paul","Perryman"));
			names.add(new Name("Nathaniel","Cromartie"));
			names.add(new Name("Tammy","Harms"));
			names.add(new Name("Thomas","Rivas"));
			names.add(new Name("Glenn","Johnson"));
			names.add(new Name("Joseph","Dahl"));
			names.add(new Name("James","Hernandez"));
			names.add(new Name("Erick","Rich"));
			names.add(new Name("Kelly","Hurley"));
			names.add(new Name("David","Bayless"));
			names.add(new Name("Terri","Dibble"));
			names.add(new Name("Beverly","McKenzie"));
			names.add(new Name("Charles","Woodard"));
			names.add(new Name("Sharon","Coates"));
			names.add(new Name("Vivian","Brown"));
			names.add(new Name("Lloyd","Obrien"));
			names.add(new Name("William","Mahon"));
			names.add(new Name("Lester","Mullins"));
			names.add(new Name("Desiree","Threet"));
			names.add(new Name("Micah","Lynn"));
			names.add(new Name("Daniel","King"));
			names.add(new Name("Jeffrey","Wilkerson"));
			names.add(new Name("Philip","Lee"));
			names.add(new Name("Tomas","Rice"));
			names.add(new Name("David","Owens"));
			names.add(new Name("Terrence","Shultz"));
			names.add(new Name("Armando","Li"));
			names.add(new Name("Phyllis","Templeton"));
			names.add(new Name("Michael","Looney"));
			names.add(new Name("Lucile","Lafrance"));
			names.add(new Name("Joanne","Hakes"));
			names.add(new Name("Scott","Eaton"));
			names.add(new Name("Harold","Bailey"));
			names.add(new Name("Larry","Rice"));
			names.add(new Name("Vickie","Armstrong"));
			names.add(new Name("Brenda","Salinas"));
			names.add(new Name("Karl","Davis"));
			names.add(new Name("John","Currie"));
			names.add(new Name("Ralph","Wolff"));
			names.add(new Name("Victor","Lupton"));
			names.add(new Name("Vanessa","Linke"));
			names.add(new Name("Trenton","Morrison"));
			names.add(new Name("Donald","Bobo"));
			names.add(new Name("Pablo","Glenn"));
			names.add(new Name("Earl","Flynn"));
			names.add(new Name("Steven","Overturf"));
			names.add(new Name("Latonya","Esquivel"));
			names.add(new Name("Christina","Arndt"));
			names.add(new Name("Kyle","Rivers"));
			names.add(new Name("Augustus","Garcia"));
			names.add(new Name("August","Scruggs"));
			names.add(new Name("Hattie","Hampton"));
			names.add(new Name("Christine","Hurley"));
			names.add(new Name("Louis","Wood"));
			names.add(new Name("Esta","Tribble"));
			names.add(new Name("Glen","Garcia"));
			names.add(new Name("Luz","Mendez"));
			names.add(new Name("Richard","Henry"));
			names.add(new Name("David","Yang"));
			names.add(new Name("June","Lawrence"));
			names.add(new Name("Jeffrey","Looney"));
			names.add(new Name("Steve","Rosales"));
			names.add(new Name("John","Leary"));
			names.add(new Name("James","Powell"));
			names.add(new Name("Julius","Kravitz"));
			names.add(new Name("Russell","Tierney"));
			names.add(new Name("Joseph","Nguyen"));
			names.add(new Name("Charles","Eaton"));
			names.add(new Name("Patricia","Rouse"));
			names.add(new Name("Samuel","White"));
			names.add(new Name("Todd","Holmes"));
			names.add(new Name("Joshua","Billings"));
			names.add(new Name("Howard","Dickerson"));
			names.add(new Name("Lisa","Robles"));
			names.add(new Name("Stephanie","Taylor"));
			names.add(new Name("Eric","Beaty"));
			names.add(new Name("Robert","Connell"));
			names.add(new Name("Melanie","Grace"));
			names.add(new Name("Floyd","Cook"));
			names.add(new Name("John","Dowdy"));
			names.add(new Name("Van","Whitley"));
			names.add(new Name("Helen","Lightle"));
			names.add(new Name("William","Thomas"));
			names.add(new Name("Johnny","Carter"));
			names.add(new Name("Donald","Shea"));
			names.add(new Name("William","Orem"));
			names.add(new Name("Robert","Schwartz"));
			names.add(new Name("Brett","Norton"));
			names.add(new Name("Daniel","Fredericks"));
			names.add(new Name("John","Newell"));
			names.add(new Name("Thomas","McGee"));
			names.add(new Name("Jacob","Burger"));
			names.add(new Name("Jimmy","Ward"));
			names.add(new Name("Laurence","Caskey"));
			names.add(new Name("Javier","Jackson"));
			names.add(new Name("Conrad","Long"));
			names.add(new Name("Leonard","Cassell"));
			names.add(new Name("Fred","Duff"));
			names.add(new Name("Mai","Scott"));
			names.add(new Name("Charles","Singer"));
			names.add(new Name("Ernesto","Daniel"));
			names.add(new Name("Robert","Borges"));
			names.add(new Name("Eric","Peeler"));
			names.add(new Name("Donald","Hernandez"));
		}
		
		// Get random name from list
		Name name = names.get((int)(Math.random() * names.size()));
		
		// Remove that name so that it is not used again
		names.remove(name);
		
		// Return the random name
		return name;
		
	}
}
