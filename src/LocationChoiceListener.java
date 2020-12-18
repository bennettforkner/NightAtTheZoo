import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LocationChoiceListener implements ActionListener {

	private Location location;
	private JButton jbutt;

	public LocationChoiceListener(Location l,JButton butt) {
		this.location = l;
		this.jbutt = butt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this.jbutt.setBackground(new Color(110,110,110));
		CONTROLLER.SELECTEDLOCATION = this.location;
	}

}
