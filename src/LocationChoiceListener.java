import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationChoiceListener implements ActionListener {

	private Location location;

	public LocationChoiceListener(Location l) {
		this.location = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CONTROLLER.SELECTEDLOCATION = this.location;
	}

}
