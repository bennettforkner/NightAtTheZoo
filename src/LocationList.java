import java.util.ArrayList;

/**
 * LocationList is an ArrayList that specifically applies to Locations
 * and can have Locations be referenced by name
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class LocationList extends ArrayList<Location> {

	/**
	 * The serialVersionUID of this class
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The method to get a Location in this list by its name
	 * 
	 * @param locationName The name of the location to find
	 * @return the found Location if found, else null
	 * 
	 */
	public Location get(String locationName) {
		
		// Loop over all locations in this list
		for (Location l : this) {
			
			// Conditional if the Location's name is the same as the passed name
			if (l.getLocationName().compareTo(locationName) == 0) {
				
				// Return this location
				return l;
				
			}
		}
		
		// Return null on no Location found
		return null;
	}

}
