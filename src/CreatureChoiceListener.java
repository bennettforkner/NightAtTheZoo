import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatureChoiceListener implements ActionListener {

	private Creature creature;

	public CreatureChoiceListener(Creature c) {
		this.creature = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CONTROLLER.SELECTEDCREATURE = this.creature;
	}

}
