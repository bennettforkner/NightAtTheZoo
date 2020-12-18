
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	
	private Control event;

	public ButtonListener(Control ev) {
		this.event = ev;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		event.run();
		CONTROLLER.WAIT = false;
	}

}
