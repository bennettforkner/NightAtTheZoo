import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
	private ButtonGroup creatureChoice = new ButtonGroup();
	private JPanel creatureBlock = new JPanel();
	private JPanel locationBlock = new JPanel();
	private JPanel actionBlock = new JPanel();
	
	public UserInterface() {
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setBackground(new Color(50,50,50));
        
        
        contentPane.setLayout(new BorderLayout());
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 1));
        
        
        screenPanel.setLayout(new GridLayout(1, 1));
        //screenPanel.setBorder(BorderFactory.createBevelBorder(1));
        screen = new JLabel();
        screen.setFont(new Font("Foop", 20, 20));
        screen.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2,true));
        //screen.setPreferredSize(new Dimension(900, 900));
        //screen.setLocation(0,0);
        
        screenPanel.add(screen);
        
        screenPanel.setMaximumSize(new Dimension(900, 900));
        screenPanel.setMinimumSize(new Dimension(900, 900));
        screenPanel.setSize(new Dimension(900, 900));
        center.add(screenPanel);
        center.setSize(new Dimension(900, 900));
        
        
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(1, 3));
        
        creatureBlock.setOpaque(true);
        creatureBlock.setVisible(true);
        creatureBlock.setSize(new Dimension(900, 900));
        radioButtons.add(locationBlock);
        
        locationBlock.setOpaque(true);
        locationBlock.setVisible(true);
        locationBlock.setSize(new Dimension(900, 900));
        radioButtons.add(creatureBlock);
        
        actionBlock.setOpaque(true);
        actionBlock.setVisible(true);
        actionBlock.setSize(new Dimension(900, 900));
        radioButtons.add(actionBlock);
        
        center.add(radioButtons);
        
        buttons.setOpaque(true);
        buttons.setVisible(true);
        buttons.setSize(new Dimension(900, 900));
        center.add(buttons);
        
        
        
        contentPane.add(center,BorderLayout.CENTER);
        
		window.setVisible(true);
	}
	
	public void setScreenText(String text) {
		screen.setText("<html><div style='padding:20px;'>" + text + "</div></html>");
	}
	
	public void displayButtons(ArrayList<Control> controls) {
		//butts = new String[] {"T", "^", "S", "<"};
		clearButtons();
        buttons.setLayout(new GridLayout(1,controls.size()));
        for (Control c : controls) {
	        	JButton button = new JButton(c.controlName);
	        	button.addActionListener(new ButtonListener(c));
	        	button.setVisible(true);
	        	button.setOpaque(true);
	        	buttons.add(button);
	        	buttonMap.put(c.controlName,button);
        }
	}
	
	public void displayCreatureChoice(ArrayList<Creature> creatures) {
		clearCreatures();
		creatureBlock.setLayout(new GridLayout(creatures.size(),1));
		for (Creature c : creatures) {
			JRadioButton choice = new JRadioButton(c.getName());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new CreatureChoiceListener(c));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	creatureBlock.add(choice);
		}
	}

	public void displayLocationChoice(ArrayList<Location> locations) {
		clearLocations();
		locationBlock.setLayout(new GridLayout(locations.size(),1));
		for (Location l : locations) {
			System.out.println(l.getLocationName());
			JRadioButton choice = new JRadioButton(l.getLocationName());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new LocationChoiceListener(l));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	locationBlock.add(choice);
		}
		
	}
	
	public void displayActionChoice(ArrayList<InteractionEvent> actions) {
		clearActions();
		locationBlock.setLayout(new GridLayout(actions.size(),1));
		for (InteractionEvent a : actions) {
			System.out.println(a.getTitle());
			JRadioButton choice = new JRadioButton(a.getTitle());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new ActionChoiceListener(a));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	actionBlock.add(choice);
		}
		
	}
	
	private void clearActions() {
		this.actionBlock.removeAll();
		
	}

	public void clearButtons() {
		this.buttons.removeAll();
	}
	
	public void clearCreatures() {
		this.creatureBlock.removeAll();
	}
	
	public void clearLocations() {
		this.locationBlock.removeAll();
	}
	
	public void setScreenColor(Color c) {
		screen.setForeground(c);
	}

	public void close() {
		this.window.dispose();
	}
}