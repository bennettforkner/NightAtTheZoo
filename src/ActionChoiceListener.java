import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionChoiceListener implements ActionListener {

	private GameEvent event;

	public ActionChoiceListener(GameEvent ge) {
		this.event = ge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new Thread(() -> {
			event.doEvent();
			CONTROLLER.WAIT = false;
        }).start();
		
	}

}
