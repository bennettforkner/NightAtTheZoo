import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CreatureChoiceListener implements ActionListener {

	private Creature creature;
	private JButton jbutt;

	public CreatureChoiceListener(Creature c,JButton butt) {
		this.creature = c;
		this.jbutt = butt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this.jbutt.setBackground(new Color(110,110,110));
		CONTROLLER.SELECTEDCREATURE = this.creature;
	}

}
