import java.util.ArrayList;
import java.util.Scanner;

/**
 * data_events is the class to keep track of the GameEvents that occur in the Game
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class data_events {
	
	/**
	 * The list of events that have been created
	 */
	private static ArrayList<GameEvent> events;
	
	/**
	 * The method to initialize the data in this class
	 */
	public static void init() {
		
		// Initialize events variable
		events = new ArrayList<GameEvent>();
		
		/* Events list:
		 * 
		 * PRE-GAME:
		 * Talk with Mom
		 * Talk With Timmy at Home
		 * Take a Selfie
		 * Watch the Hippos
		 * Feed the Turtles
		 * Order Something
		 * Mock the Flamingos
		 * Buy a Toy Hippo for Timmy
		 * 
		 * GAME:
		 * 
		 */
		
		
		//###################################> Talk with Mom <##################################################
		
		ConversationEvent talkWithMom = new ConversationEvent(
			"Talk with Mom",
			CONTROLLER.GAME.creatures.mom,
			"Your mom says that she wants to talk..."
		);
		
		talkWithMom.nodes.add(0,new ConversationNode("Hey " + CONTROLLER.player.getName() + ", little Timmy wants to go to the zoo.\nCan you take him?", new Response[] {
			new Response("Yes! I would love to. Anything for my younger brother.", 1),
			new Response("Aw, I would love to, but I have to finish my Calculus project.", 2),
			new Response("No! I hate Timmy and I refuse to take him", 2)
		}));
		talkWithMom.nodes.add(1,new ConversationNode("Great! Enjoy your time together.", null,() -> {
			CONTROLLER.GAME.controls.getControl('g').setAvailable(true);
			CONTROLLER.GAME.setCurrentLocation(CONTROLLER.GAME.getLocations().get(1));
		}));
		talkWithMom.nodes.add(2,new ConversationNode("It's just not an option for you to stay home honey.\nTimmy is really excited to see the hippos!\nAlso, you haven't done anything together in a long time.", new Response[] {
			new Response("Ok, fine. I'll take him.", 1)
		}));
		CONTROLLER.GAME.creatures.mom.addConversation(talkWithMom);
		events.add(talkWithMom);
		
		
		//###################################> Talk With Timmy at Home <##################################################
		
		ConversationEvent talkWithTimmyHome = new ConversationEvent(
				"Talk With Timmy at Home",
				CONTROLLER.GAME.creatures.timmy,
				"Timmy looks like he is about to burst with excitement."
			);
			
		talkWithTimmyHome.nodes.add(0,new ConversationNode("Hey " + CONTROLLER.player.getName() + ", mom said you were going to take me to the zoo!\nI can't wait to see the hippos.\nI hear they love to play paintball!", new Response[] {
			new Response("Hi Timmy. Yea, let's go to the zoo", 1),
			new Response("Aw, I would love to, but I have to finish my Calculus project.", 2),
			new Response("No! I hate you and I refuse to take you to the zoo.", 2)
		}));
		talkWithTimmyHome.nodes.add(1,new ConversationNode("I can't wait. Tell mom when we're ready to go.", null));
		talkWithTimmyHome.nodes.add(2,new ConversationNode("Yea? Well you should tell mom that.", null));
		
		CONTROLLER.GAME.creatures.timmy.addConversation(talkWithTimmyHome);
		events.add(talkWithTimmyHome);
		
		
		//###################################> Talk With Timmy at Home <##################################################
		
		ConversationEvent talkWithTimmyHome2 = new ConversationEvent(
				"Talk With Timmy at Home 2",
				CONTROLLER.GAME.creatures.timmy,
				"Timmy is so excited to go to the zoo."
			);
			
		talkWithTimmyHome2.nodes.add(0,new ConversationNode(CONTROLLER.player.getName() + ", I'm so glad you're my brother.\nYou're never selfish and always take me to the zoo when I want!", new Response[] {
			new Response("Timmy, why can't you just be normal. Hippos are stupid.", 4),
			new Response("I have never taken you to the zoo before, Timmy. And I can't take you today.", 2),
			new Response("I'm glad you're my brother too Timmy. I'll talk to mom and we can go to the zoo.", 1)
		}));
		talkWithTimmyHome2.nodes.add(1,new ConversationNode("I can't wait. Tell mom when we're ready to go.", null));
		talkWithTimmyHome2.nodes.add(2,new ConversationNode("Why not? You don't love me then.", new Response[] {
			new Response("Timmy, I do love you. I just have a lot to do.", 3),
			new Response("You're right. Screw you! I don't love you and I'm tired of being your brother.",4)
		}));
		talkWithTimmyHome2.nodes.add(3,new ConversationNode("Tell that to mom. It looks like she's going to make you take me. :)", null));
		talkWithTimmyHome2.nodes.add(4,new ConversationNode("Mom! " + CONTROLLER.player.getName() + " said he doesn't love me!", null,() -> {
			ConversationEvent temp = new ConversationEvent(
				"Mom Hears that You Don't Love Timmy",
				CONTROLLER.GAME.creatures.mom,
				"Your mom turns to you..."
			);
			temp.nodes.add(0,new ConversationNode(CONTROLLER.player.getName() + ", did I just hear what I think I heard?", new Response[] {
				new Response("No! I didn't say that. I was just frustrated with him. He always gets what he wants.", 1),
				new Response("Yes, he's being a little weasel and I am tired of it.", 4)
			}));
			temp.nodes.add(1,new ConversationNode("Well, you need to take your brother to the zoo.\nHe hasn't been in a while and you need to spend some time together.", new Response[] {
				new Response("Mom, I just can't. I'm too busy.", 3),
				new Response("Okay whatever, I'll take him.", 2)
			}));
			temp.nodes.add(2,new ConversationNode("Great! Enjoy your time together.", null,() -> {
				CONTROLLER.GAME.controls.getControl('g').setAvailable(true);
				CONTROLLER.GAME.setCurrentLocation(CONTROLLER.GAME.getLocations().get(1));
			}));
			temp.nodes.add(3,new ConversationNode("You're taking him and that's final. Now grab your coat.", null,() -> {
				CONTROLLER.GAME.controls.getControl('g').setAvailable(true);
				CONTROLLER.GAME.setCurrentLocation(CONTROLLER.GAME.getLocations().get(1));
			}));
			temp.nodes.add(4,new ConversationNode("How dare you say that to your brother.\nYou need some time together so that you can make up.\nNow you're definitely taking him to the zoo. Have fun boys!.", null,() -> {
				CONTROLLER.GAME.controls.getControl('g').setAvailable(true);
				CONTROLLER.GAME.setCurrentLocation(CONTROLLER.GAME.getLocations().get(1));
			}));
			temp.doEvent();
	}));
		
		CONTROLLER.GAME.creatures.timmy.addConversation(talkWithTimmyHome2);
		events.add(talkWithTimmyHome2);
		
		
		//###################################> Take a Selfie <##################################################
		
		events.add(new InteractionEvent("Take a Selfie") {
			public void runEvent() {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\n** Click **");
				
				CONTROLLER.sleep(1000);
				
				PRINTER.narrateln(" ___________________");
				PRINTER.narrate("\n|                   |");
				PRINTER.narrate("\n|                   |");
				PRINTER.narrate("\n|    O              |");
				PRINTER.narrate("\n|   /|\\             |");
				PRINTER.narrate("\n|  / | \\      O     |");
				PRINTER.narrate("\n|    ?       /|\\    |");
				PRINTER.narrate("\n|   / \\       |     |");
				PRINTER.narrate("\n|  /   \\     / \\    |");
				PRINTER.narrate("\n|___________________|");
				
				CONTROLLER.sleep(2000);
				
				CONTROLLER.player.increaseStrength();
				CONTROLLER.sleep(1000);
			}
		});
		
		events.add(new InteractionEvent("Take a Selfie2") {
			public void runEvent() {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\n** Click **");
				
				CONTROLLER.sleep(1000);
				
				PRINTER.narrateln(" ___________________");
				PRINTER.narrate("\n|                   |");
				PRINTER.narrate("\n|                   |");
				PRINTER.narrate("\n|    O              |");
				PRINTER.narrate("\n|   /|\\             |");
				PRINTER.narrate("\n|  / | \\      O     |");
				PRINTER.narrate("\n|    ?       /|\\    |");
				PRINTER.narrate("\n|   / \\       |     |");
				PRINTER.narrate("\n|  /   \\     / \\    |");
				PRINTER.narrate("\n|___________________|");
				
				CONTROLLER.sleep(2000);
				
				CONTROLLER.player.increaseStrength();
			}
		});
		
		
		//###################################> Watch the Hippos <##################################################
		
		events.add(new InteractionEvent("Watch the Hippos",20) {
			public void runEvent() {
				int rando = (int)(Math.random() * 4);
				if (rando == 0) {
					CONTROLLER.sleep(4000);
					PRINTER.sayln("\nO",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("H ",CONTROLLER.player);
					CONTROLLER.sleep(500);
					PRINTER.say("N",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("O",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(100);
					PRINTER.say("!",CONTROLLER.player);
					CONTROLLER.sleep(1000);
					
					PRINTER.narrate("\n\nTimmy fell into the hippo exhibit");
					CONTROLLER.GAME.preGameRunning = false;
					return;
				} else {
					CONTROLLER.sleep(1000);
					PRINTER.narrateln("You watch the hippos.");
					
					CONTROLLER.sleep(2000);
					PRINTER.narrate("\n\nThey watch you back...");
					
					CONTROLLER.sleep(1000);
				}
			}
		});
		
		
		//###################################> Feed the Turtles <##################################################
		
		events.add(new InteractionEvent("Feed the Turtles") {
			public void runEvent() {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You decided to feed the turtles.");
				
				CONTROLLER.player.increaseStrength();
				CONTROLLER.sleep(1000);
			}
		});
		
		
		//###################################> Order Something <##################################################
		
		events.add(new InteractionEvent("Order Something") {
			public void runEvent() {
				ArrayList<FoodItem> foods = new ArrayList<FoodItem>();
				foods.add(new FoodItem(3,"Cheeseburger",12));
				foods.add(new FoodItem(1,"French Fried",6));
				foods.add(new FoodItem(2,"Chicken Nugger",10));
				foods.add(new FoodItem(2,"Shake",8));
				PRINTER.narrateln("Welcome to the food court!");
				String input = "";
				Scanner in = new Scanner(System.in);
				while (input.compareToIgnoreCase("q") != 0) {
					PRINTER.narrateln("Here is what we have available:");
					int count = 0;
					for (FoodItem f : foods) {
						PRINTER.narrateln("[" + count++ + "]: " + f.getName() + " ($" + f.getPrice() + ")");
					}
					PRINTER.narrateln("What would you like to buy?: ");
					input = in.nextLine();
					
					if (input.length() < 3) {
						continue;
					} else if (input.charAt(0) == 'b') {
						int index = Integer.parseInt(input.replaceAll("[\\D]", ""));
						CONTROLLER.player.addToInventory(foods.get(index));
						foods.remove(foods.get(index));
					} 
				}
			}
			
		});
		
		
		//###################################> Mock the Flamingos <##################################################
		
		events.add(new InteractionEvent("Mock the Flamingos",5) {
			public void runEvent() {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You lift one foot off the ground.");
				
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You extend your neck.");
				
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You retract your arms.");
				
				CONTROLLER.sleep(5000);
				int rando = (int)(Math.random() * 5);
				if (rando == 0) {
					PRINTER.narrateln("The flamingos honk their disapproval.");
					CONTROLLER.player.increaseStrength(4);
				} else {
					PRINTER.narrateln("The flamingos were not amused.");
				}
				CONTROLLER.sleep(1000);
			}
		});
		
		
		//###################################> Buy a Toy Hippo for Timmy <##################################################
		
		events.add(new InteractionEvent("Buy a Toy Hippo for Timmy") {
			public void runEvent() {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You buy the toy hippo for $30.");
				
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("You eye the hippo suspiciously.");
				
				CONTROLLER.sleep(2000);
				PRINTER.narrateln("It eyes you back...");
				
				CONTROLLER.sleep(1000);
				
				CONTROLLER.player.increaseStrength();
				CONTROLLER.sleep(1000);
			}
		});
	}
	
	public static GameEvent getEvent(String title) {
		for (GameEvent event : events) {
			if (event.getTitle().compareTo(title) == 0) {
				return event;
			}
		}
		return null;
	}
}
