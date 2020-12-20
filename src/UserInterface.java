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

public class UserInterface {
	
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final double screenHeight = screenSize.getHeight();
	private static final double screenWidth = screenSize.getWidth();
	
	private static final int WINDOW_HEIGHT = (int)(screenHeight * 2/3);
	private static final int WINDOW_WIDTH = (int)(screenWidth * 2/3);
	private static final int WINDOW_Y_POSITION = (int)(screenHeight / 2) - (WINDOW_HEIGHT / 2);
	private static final int WINDOW_X_POSITION = (int)(screenWidth / 2) - (WINDOW_WIDTH / 2);
	private JFrame window = new JFrame();
	public JPanel buttons = new JPanel();
	public JLabel screen;
	public HashMap<String, JButton> buttonMap = new HashMap<>();
	public JPanel screenPanel = new JPanel();
	private Container contentPane = window.getContentPane();
	private ButtonGroup creatureChoice = new ButtonGroup();
	private ButtonGroup locationChoice = new ButtonGroup();
	private ButtonGroup actionChoice = new ButtonGroup();
	private JPanel creatureBlock = new JPanel();
	private JPanel locationBlock = new JPanel();
	private JPanel actionBlock = new JPanel();
	private JLabel currentLocation = new JLabel();
	
	public UserInterface() {
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setBackground(new Color(50,50,50));
        
        
        contentPane.setLayout(new BorderLayout());
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 1));
        
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 1));
        
        currentLocation.setFont(new Font("Foop", 20, 25));
        currentLocation.setOpaque(true);
        currentLocation.setVisible(true);
        top.add(currentLocation);
        
        
        screenPanel.setLayout(new GridLayout(1, 1));
        //screenPanel.setBorder(BorderFactory.createBevelBorder(1));
        screen = new JLabel();
        screen.setFont(new Font("Foop", 20, 20));
        screen.setForeground(Color.WHITE);
        screen.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 2,true));
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
        
        locationBlock.setOpaque(true);
        locationBlock.setVisible(true);
        locationBlock.setSize(new Dimension(900, 900));
        
        actionBlock.setOpaque(true);
        actionBlock.setVisible(true);
        actionBlock.setSize(new Dimension(900, 900));
        radioButtons.add(locationBlock);
        radioButtons.add(actionBlock);
        radioButtons.add(creatureBlock);
        
        center.add(radioButtons);
        
        buttons.setOpaque(true);
        buttons.setVisible(true);
        buttons.setSize(new Dimension(900, 900));
        center.add(buttons);
        
        locationBlock.setBackground(Color.BLACK);
        actionBlock.setBackground(Color.BLACK);
        creatureBlock.setBackground(Color.BLACK);
        buttons.setBackground(Color.BLACK);
        screenPanel.setBackground(Color.BLACK);
        currentLocation.setBackground(Color.BLACK);
        
        
        contentPane.add(top,BorderLayout.NORTH);
        contentPane.add(center,BorderLayout.CENTER);
        
		window.setVisible(true);
	}
	
	public void setScreenText(String text) {
		screen.setText("<html><div style='padding:20px;'>" + text + "</div></html>");
	}
	
	public void setCurrentLocation(Location location) {
		this.currentLocation.setText("<html><div style='padding:20px;text-align:center;color:white;'>Current Location: " + location.getLocationName() + "</div></html>");
	}

	public void displayLocationChoice(ArrayList<Location> locations) {
		clearLocations();
		locationBlock.setLayout(new GridLayout(locations.size(),0));
		System.out.println(locations.size());
		for (Location l : locations) {
			JButton choice = new JButton(l.getLocationName());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new LocationChoiceListener(l,choice));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	choice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	
        	choice.addMouseListener(new java.awt.event.MouseAdapter() {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) {
        	        choice.setBackground(Color.BLACK);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	        choice.setBackground(UIManager.getColor("control"));
        	    }
        	});
        	choice.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent evt) {
                    if (choice.getModel().isPressed()) {
                    	choice.setBackground(Color.GREEN);
                    } else if (choice.getModel().isRollover()) {
                    	choice.setBackground(Color.PINK);
                    } else {
                    	choice.setBackground(UIManager.getColor("control"));
                    }
                }
            });
        	
        	locationChoice.add(choice);
        	locationBlock.add(choice);
		}
		
	}
	
	public void displayCreatureChoice(ArrayList<Creature> creatures) {
		clearCreatures();
		creatureBlock.setLayout(new GridLayout(creatures.size(),1));
		for (Creature c : creatures) {
			JButton choice = new JButton(c.getName());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new CreatureChoiceListener(c,choice));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	choice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	
        	choice.addMouseListener(new java.awt.event.MouseAdapter() {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) {
        	    	choice.setBackground(Color.BLACK);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	        choice.setBackground(UIManager.getColor("control"));
        	    }
        	});
        	choice.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent evt) {
                    if (choice.getModel().isPressed()) {
                    	choice.setBackground(Color.GREEN);
                    } else if (choice.getModel().isRollover()) {
                    	choice.setBackground(Color.PINK);
                    } else {
                    	choice.setBackground(UIManager.getColor("control"));
                    }
                }
            });
        	
        	creatureChoice.add(choice);
        	creatureBlock.add(choice);
		}
	}
	
	public void displayActionChoice(ArrayList<InteractionEvent> actions) {
		clearActions();
		actionBlock.setLayout(new GridLayout(actions.size(),1));
		for (InteractionEvent a : actions) {
			JButton choice = new JButton(a.getTitle());
			choice.setFont(new Font("Foop", 20, 20));
			choice.addActionListener(new ActionChoiceListener(a));
        	choice.setVisible(true);
        	choice.setOpaque(true);
        	choice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	
        	choice.addMouseListener(new java.awt.event.MouseAdapter() {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) {
        	    	choice.setBackground(Color.BLACK);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	        choice.setBackground(UIManager.getColor("control"));
        	    }
        	});
        	choice.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent evt) {
                    if (choice.getModel().isPressed()) {
                    	choice.setBackground(Color.GREEN);
                    } else if (choice.getModel().isRollover()) {
                    	choice.setBackground(Color.PINK);
                    } else {
                    	choice.setBackground(UIManager.getColor("control"));
                    }
                }
            });
        	
        	actionChoice.add(choice);
        	actionBlock.add(choice);
		}
		
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
	        	button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        	
	        	button.addMouseListener(new java.awt.event.MouseAdapter() {
	        	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	    	button.setBackground(Color.BLACK);
	        	    }

	        	    public void mouseExited(java.awt.event.MouseEvent evt) {
	        	    	button.setBackground(UIManager.getColor("control"));
	        	    }
	        	});
	        	
	        	
	        	buttons.add(button);
	        	buttonMap.put(c.controlName,button);
        }
	}
	
	public void clearButtonColoring() {
		for (Component button : actionBlock.getComponents()) {
			button.setBackground(new Color(238,238,238));
		}
		for (Component button : locationBlock.getComponents()) {
			button.setBackground(new Color(238,238,238));
		}
		for (Component button : creatureBlock.getComponents()) {
			button.setBackground(new Color(238,238,238));
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