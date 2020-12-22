import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
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
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GameInterface is the class to manage the interface of a NightAtTheZoo game
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class GameInterface {
	
	/**
	 * The screen size of the device that this game is running on
	 */
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * The height of the screen of the device that this game is running on
	 */
	private static final double screenHeight = screenSize.getHeight();
	
	/**
	 * The width of the screen of the device that this game is running on
	 */
	private static final double screenWidth = screenSize.getWidth();
	
	/**
	 * The height of the interface window
	 */
	private static final int WINDOW_HEIGHT = (int)(screenHeight * 2/3);
	
	/**
	 * The width of the interface window
	 */
	private static final int WINDOW_WIDTH = (int)(screenWidth * 2/3);
	
	/**
	 * The height position of the interface window
	 */
	private static final int WINDOW_Y_POSITION = (int)(screenHeight / 2) - (WINDOW_HEIGHT / 2);
	
	/**
	 * The width position of the interface window
	 */
	private static final int WINDOW_X_POSITION = (int)(screenWidth / 2) - (WINDOW_WIDTH / 2);
	
	/**
	 * The base window of the GUI
	 */
	private JFrame window = new JFrame();
	
	/**
	 * The panel of control buttons at the bottom of the window
	 */
	public JPanel controlButtons = new JPanel();
	
	/**
	 * The text pane of the window
	 */
	public JLabel screen;
	
	/**
	 * The panel to house the text screen
	 */
	public JPanel screenPanel = new JPanel();
	
	/**
	 * The content section of the window
	 */
	private Container contentPane = window.getContentPane();
	
	/**
	 * The ButtonGroup of Creatures
	 */
	private ButtonGroup creatureChoice = new ButtonGroup();
	
	/**
	 * The ButtonGroup of Locations 
	 */
	private ButtonGroup locationChoice = new ButtonGroup();
	
	/**
	 * The ButtonGroup of InteractionEvents
	 */
	private ButtonGroup actionChoice = new ButtonGroup();
	
	/**
	 * The panel of Creature choice buttons
	 */
	private JPanel creatureBlock = new JPanel();
	
	/**
	 * The panel of Location choice buttons
	 */
	private JPanel locationBlock = new JPanel();
	
	/**
	 * The panel of InteractionEvent choice buttons
	 */
	private JPanel actionBlock = new JPanel();
	
	/**
	 * The label for the current location
	 */
	private JLabel currentLocation = new JLabel();
	
	/**
	 * The constructor for a GameInterface Object
	 */
	public GameInterface() {
		
		// Try to set the the styles to cross-device default
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		// Set the size of the window
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Set the position of the window
        window.setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);
        
        // Set the action executed on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the background color
        window.setBackground(new Color(0,0,0));
        
        // Set the layout of the content pane
        contentPane.setLayout(new BorderLayout());
        
        // The panel that will be placed at the center of the window
        JPanel center = new JPanel();
        
        // Set the layout of the panel
        center.setLayout(new GridLayout(3, 1));

        // The panel that will be placed at the top of the window
        JPanel top = new JPanel();
        
        // Set the layout of the panel
        top.setLayout(new GridLayout(1, 1));
        
        // Set styling of the current location label
        currentLocation.setFont(new Font("Foop", 20, 25));
        currentLocation.setOpaque(true);
        currentLocation.setVisible(true);
        
        // Add the current location label to the panel
        top.add(currentLocation);

        // Set the layout of the panel
        screenPanel.setLayout(new GridLayout(1, 1));
        
        // The text label
        screen = new JLabel();
        
        // Set the styling of the text label
        screen.setFont(new Font("Foop", 20, 20));
        screen.setForeground(Color.WHITE);
        screen.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 2,true));
        
        // Add the text label to the panel
        screenPanel.add(screen);
        
        // Set the styling of the text panel
        screenPanel.setMaximumSize(new Dimension(900, 900));
        screenPanel.setMinimumSize(new Dimension(900, 900));
        screenPanel.setSize(new Dimension(900, 900));
        
        // Add the text panel to the center element
        center.add(screenPanel);
        
        // Set the size of the center element
        center.setSize(new Dimension(900, 900));
        
        // The panel of buttons for selecting a choice
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(1, 3));
        
        // Set the styling of the Creature choice panel
        creatureBlock.setOpaque(true);
        creatureBlock.setVisible(true);
        creatureBlock.setSize(new Dimension(900, 900));

        // Set the styling of the Location choice panel
        locationBlock.setOpaque(true);
        locationBlock.setVisible(true);
        locationBlock.setSize(new Dimension(900, 900));

        // Set the styling of the InteractionEvent choice panel
        actionBlock.setOpaque(true);
        actionBlock.setVisible(true);
        actionBlock.setSize(new Dimension(900, 900));
        
        // Add the panels to the larger panel
        radioButtons.add(locationBlock);
        radioButtons.add(actionBlock);
        radioButtons.add(creatureBlock);
        
        // Add the panel to the center panel
        center.add(radioButtons);
        
        // Set the styling for the control button panel
        controlButtons.setOpaque(true);
        controlButtons.setVisible(true);
        controlButtons.setSize(new Dimension(900, 900));
        
        // Add the panel to the center panel
        center.add(controlButtons);
        
        // Set the background colors to black
        locationBlock.setBackground(Color.BLACK);
        actionBlock.setBackground(Color.BLACK);
        creatureBlock.setBackground(Color.BLACK);
        controlButtons.setBackground(Color.BLACK);
        screenPanel.setBackground(Color.BLACK);
        currentLocation.setBackground(Color.BLACK);
        
        // Add the top and center panels to the content pane
        contentPane.add(top,BorderLayout.NORTH);
        contentPane.add(center,BorderLayout.CENTER);
        
        // Display the window
		window.setVisible(true);
		
	}
	
	/**
	 * The method to append text to the screen of this GameInterface
	 * 
	 * @param text The text to append
	 * 
	 */
	public void setScreenText(String text) {
		screen.setText((screen.getText() == "" ? "<html><div style='padding:20px;'>" : screen.getText().substring(0,screen.getText().length() - 12)) + text + "</div></html>");
	}
	
	/**
	 * The method to set the text of the current location label
	 * 
	 * @param location The location name to be set
	 */
	public void setCurrentLocation(Location location) {
		this.currentLocation.setText("<html><div style='padding:20px;text-align:center;color:white;'>Current Location: " + location.getLocationName() + "</div></html>");
	}
	
	/**
	 * The method to display the passed locations as buttons
	 * 
	 * @param locations The ArrayList of locations to be displayed
	 * 
	 */
	public void displayLocationChoice(ArrayList<Location> locations) {
		
		// Clear the Location buttons from the screen
		this.clearLocations();
		
		// Conditional if there are no locations available
		if (locations.size() < 0)
			return;
		
		// Set the layout of the location button block
		locationBlock.setLayout(new GridLayout(locations.size(),0));
		
		// Loop over locations
		for (Location l : locations) {
			
			// Create new button with the name of the Location
			JButton choice = new GameControlButton(l.getLocationName());
			
			// Set the font size of the button
			choice.setFont(new Font("Foop", 20, 20));
			
			// Add a listener to the button that is executed when is is pressed
			choice.addActionListener(new LocationChoiceListener(l,choice));
        	
			// Add the button to relevant sections
        		locationChoice.add(choice);
        		locationBlock.add(choice);
		}
		
	}
	
	/**
	 * The method to display the buttons for the Creatures to the GUI
	 * 
	 * @param creatures The Creatures to be displayed
	 */
	public void displayCreatureChoice(ArrayList<Creature> creatures) {
		
		// Clear the Creature buttons from the screen
		clearCreatures();
		
		// Conditional if no Creatures are available
		if (creatures.size() < 0)
			return;
		
		// Set the layout of the Creature button block
		creatureBlock.setLayout(new GridLayout(creatures.size(),1));
		
		// Loop over the Creatures
		for (Creature c : creatures) {
			
			// Create a new button for the Creature
			JButton choice = new GameControlButton(c.getName());
			
			// Set the font of the button
			choice.setFont(new Font("Foop", 20, 20));
			
			// Add a listener to the button to be enacted when pressed
			choice.addActionListener(new CreatureChoiceListener(c,choice));

			// Add the button to the panels
        		creatureChoice.add(choice);
        		creatureBlock.add(choice);
		}
	}
	
	/**
	 * The method to display the buttons for the actions to the GUI
	 * 
	 * @param actions The InteractionEvents to be displayed
	 */
	public void displayActionChoice(ArrayList<InteractionEvent> actions) {
		
		// Clear the action buttons from the screen
		clearActions();
		
		// Conditional if there are no actions available
		if (actions.size() < 0)
			return;
		
		// Set the layout of the pane
		actionBlock.setLayout(new GridLayout(actions.size(),1));
		
		// Loop over the InteractionEvents
		for (InteractionEvent a : actions) {
			
			// Create a new button with the title of the InteractionEvent
			JButton choice = new GameControlButton(a.getTitle());
			
			// Set the font of the button
			choice.setFont(new Font("Foop", 20, 20));
			
			// Add an listener to the button to be enacted on click
			choice.addActionListener(new ActionChoiceListener(a));
        		
			// Add the button to the panels
			actionChoice.add(choice);
        		actionBlock.add(choice);
        		
		}
		
	}
	
	/**
	 * The method to display the buttons for the controls to the GUI
	 * 
	 * @param controls The controls to be displayed
	 */
	public void displayButtons(ArrayList<Control> controls) {
		
		// Conditional if there are controls available
		if (controls.size() < 0)
			return;
		
		// Clear the control buttons from the screen
		clearButtons();
		
		// Set the layout of the button pane
		controlButtons.setLayout(new GridLayout(1,controls.size()));
		
		// Loop over controls
        for (Control c : controls) {
        	
        		// Create a new button with the control name
	        	JButton button = new GameControlButton(c.controlName);
	        	
	        	// Add listener to be enacted when button is pressed
	        	button.addActionListener(new ControlListener(c));
	        	
	        	// Add the button to the panel
	        	controlButtons.add(button);
	        	
        }
	}
	
	/**
	 * The method to remove all action buttons from the window
	 */
	public void clearActions() {
		this.actionBlock.removeAll();
	}

	/**
	 * The method to remove all Control buttons from the window
	 */
	public void clearButtons() {
		this.controlButtons.removeAll();
	}

	/**
	 * The method to remove all Creature buttons from the window
	 */
	public void clearCreatures() {
		this.creatureBlock.removeAll();
	}

	/**
	 * The method to remove all Location buttons from the window
	 */
	public void clearLocations() {
		this.locationBlock.removeAll();
	}
	
	/**
	 * The method to set the text color of the text label
	 * 
	 * @param c The Color object to be applied to the text
	 * 
	 */
	public void setScreenColor(Color c) {
		screen.setForeground(c);
	}

	/**
	 * The method to close the GUI
	 */
	public void close() {
		this.window.dispose();
	}

	/**
	 * The method to clear the text label's content
	 */
	public void clearScreenText() {
		screen.setText("");
	}
}