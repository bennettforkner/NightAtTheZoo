import java.util.ArrayList;

public class LocationList extends ArrayList<Location> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Location get(String locationName) {
		for (Location l : this) {
			if (l.getLocationName().compareTo(locationName) == 0) {
				return l;
			}
		}
		return null;
	}

}
