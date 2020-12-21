import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameControlButton extends JButton {

	public GameControlButton() {
		this("");
	}

	public GameControlButton(String text) {
		super(text);
		this.setVisible(true);
		this.setOpaque(true);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setContentAreaFilled(false);
		this.setForeground(Color.WHITE);
    	
		this.addMouseListener(new java.awt.event.MouseAdapter() {
    	    public void mouseEntered(java.awt.event.MouseEvent evt) {
    	    	setBackground(Color.GREEN);
    	    }

    	    public void mouseExited(java.awt.event.MouseEvent evt) {
    	    	setBackground(UIManager.getColor("control"));
    	    }
    	});
		
    	this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                	setBackground(Color.GREEN);
                } else if (getModel().isRollover()) {
                	setBackground(Color.PINK);
                } else {
                	setBackground(UIManager.getColor("control"));
                }
            }
        });
	}

}
