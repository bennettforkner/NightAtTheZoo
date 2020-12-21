
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlListener implements ActionListener {
	
	private Control event;

	public ControlListener(Control ev) {
		this.event = ev;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(() -> {
			event.run();
			CONTROLLER.WAIT = false;
        }).start();
	}

}
