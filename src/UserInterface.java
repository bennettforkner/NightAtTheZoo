import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInterface {
	
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final double width = screenSize.getWidth();
	private static final double height = screenSize.getHeight();
	
	private static final int WINDOW_HEIGHT = 600;
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_Y_POSITION = (int)(height / 2) - (WINDOW_HEIGHT / 2);
	private static final int WINDOW_X_POSITION = (int)(width / 2) - (WINDOW_WIDTH / 2);
	private JFrame window = new JFrame();
	public JPanel buttons = new JPanel();
	public JLabel screen;
	public HashMap<String, JButton> buttonMap = new HashMap<>();
	public JPanel screenPanel = new JPanel();
	private Container contentPane = window.getContentPane();
	
	public UserInterface() {
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setBackground(new Color(250, 248, 239));
        
        
        contentPane.setLayout(new BorderLayout());
        
        //buttons.setSize(new Dimension(10,5));
        buttons.setOpaque(true);
        buttons.setVisible(true);
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        bottom.add(buttons);
        
        screenPanel.setLayout(new GridLayout(1, 1));
        screenPanel.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2,true));
        //screenPanel.setBorder(BorderFactory.createBevelBorder(1));
        screen = new JLabel();
        screen.setFont(new Font("Foop", 20, 20));
        //screen.setPreferredSize(new Dimension(900, 900));
        //screen.setLocation(0,0);
        
        screenPanel.add(screen);
        screenPanel.setMaximumSize(new Dimension(900, 900));
        
        screenPanel.setSize(new Dimension(900, 900));
        JPanel top = new JPanel();
        top.add(screenPanel);
        top.setSize(new Dimension(900, 900));
        
        contentPane.add(bottom,BorderLayout.CENTER);
        contentPane.add(top,BorderLayout.NORTH);
        
		window.setVisible(true);
	}
	
	public void setScreenText(String text) {
		screen.setText("<html><div style='padding:20px;'>" + text + "</div></html>");
	}
	
	public void displayButtons(String[] butts) {
		//butts = new String[] {"T", "^", "S", "<"};
        buttons.setLayout(new GridLayout(1,butts.length));
        for (int i = 0; i < butts.length; i++) {
	        	JButton button = new JButton(butts[i]);
	        	button.setVisible(true);
	        	button.setOpaque(true);
	        	buttons.add(button);
	        	buttonMap.put(butts[i],button);
        }
	}
	
	public void setScreenColor(Color c) {
		screen.setForeground(c);
	}

	public void close() {
		this.window.dispose();
		
	}
}