import java.util.ArrayList;

public class data_creatures {
	
	public Creature parkManager = new Person("Park Manager", 10, 5, "You're banned from my park.");
	
	public Creature kingHippo = new Hippo("King " + data_names.getRandomName().toString(), 180, 250, "You spotted, furry skunk.");
	
	public Creature mom = new Person("Your Mom", 10, 5, "Well I just won't have it!");
	public Creature timmy = new Person("Timmy", 10, 5, "I love hippos!");
	
	public ArrayList<Hippo> hippos;
	
	public ArrayList<Person> police;
	
	public ArrayList<Person> zookeepers;
	
	public ArrayList<Person> visitors;
	
	public data_creatures() {
		this.hippos = new ArrayList<Hippo>();
		hippos.add(new Hippo("", 80, 100, "You spotted, furry skunk."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You spotted, furry skunk."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You watched me. I watched you back..."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You sea level raising, SUV driving, rain forest clearer."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "Yummy! You look like a tasty morsal!"));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You unseasonal, genetically modified, litter lout."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You purple, decomposing plant."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You alternative energy avoiding, Chelsea tractor driving, polar bear drowner."));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "I'm a hungry, hungry hippo!"));
		hippos.add(new Hippo(data_names.getRandomName().toString(), 80, 100, "You fossil fuel burning, environment destroying, whale eater."));
		
		this.police = new ArrayList<Person>();
		police.add(new Person("Chief of Police", 20, 50, ""));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "Nah, I don't feel like helping you."));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "First I need a powdered, jelly-filled donut."));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "I will radio for back-up."));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "FREEZE! You're under arrest!"));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "You can trust me..."));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "I wasn't trained to use a gun."));
		police.add(new Person(data_names.getRandomName().toString(), 15, 30, "I work for the hippos."));
		
		this.zookeepers = new ArrayList<Person>();
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "Don't hit me... I'm just trying to do my job!"));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "Sorry I can't help you, I have to feed the alligators."));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "WATCH OUT!"));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "I love my job... cleaning up shit is fun."));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "Let me show you to the hippos."));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "Do you want to feed the turtles."));
		zookeepers.add(new Person(data_names.getRandomName().toString(), 10, 5, "Welcome to the Zoo!"));
		
		this.visitors = new ArrayList<Person>();
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Did you buy anything from the gift shop?"));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Where am I?"));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Those flamingos are so rude!"));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Don't tell me a funny lion joke or I'll puma pants."));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Don't trust anyone..."));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Let's go watch the hippos!"));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Keep an eye on your child... I've heard the animals are always hungry."));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Life is a bowl of soup, but I'm a fork." ));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Did your brother fall into the hippo exhibit, too?"));
		visitors.add(new Person(data_names.getRandomName().toString(), 5, 5, "Did you buy an overpriced shake yet?"));

	}
}
