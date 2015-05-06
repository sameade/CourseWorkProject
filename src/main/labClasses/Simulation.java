package labClasses;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import actors.Actor;
import actors.BeanPlant;
import actors.Farmer;
import actors.Weed;
import baseCode.Field;
import baseCode.Location;
import baseCode.RandomGenerator;
import baseCode.SimulatorView;

public class Simulation {

	private Field field;
	private SimulatorView view;
	private ArrayList<Actor> actors;
	private int step;
	
	public Simulation(int depth, int width) {
		int tempDepth = depth;
		int tempWidth = width;
		
		if (tempDepth <= 0) {
			tempDepth = ModelConstants.DEFAULT_FIELD_DEPTH;
		}
		if (tempWidth <= 0) {
			tempWidth = ModelConstants.DEFAULT_FIELD_WIDTH;
		}
		
		field = new Field(tempDepth, tempWidth);
		view = new SimulatorView(tempDepth, tempWidth);
		view.setColor(Farmer.class, Color.BLACK);
		view.setColor(Weed.class, Color.BLUE);
		view.setColor(BeanPlant.class, Color.GREEN);
		actors = new ArrayList<Actor>();
		RandomGenerator.initialiseWithSeed(ModelConstants.RANDOM_SEED);
	}
	
	private void populate() {
		field.clear();
		for(int x = 0; x < field.getDepth(); x++) {
			for(int y = 0; y < field.getWidth(); y++) {
				Double random = RandomGenerator.getRandom().nextDouble();
				if (random < ModelConstants.FARMER_CREATION_PROB) {
					Farmer farmer = new Farmer();
					placeActor(farmer, x, y);
				} else if (random < ModelConstants.WEED_CREATION_PROB) {
					int age = RandomGenerator.getRandom().nextInt(150);
					Weed weed = new Weed(age);
					placeActor(weed, x, y);
				} else if (random < ModelConstants.BEAN_CREATION_PROB) {
					int age = RandomGenerator.getRandom().nextInt(150);
					BeanPlant beanPlant = new BeanPlant(age);
					placeActor(beanPlant, x, y);
				}	
			}
		}
		
	}
	
	private void placeActor(Actor actor, int x, int y) {
		Location location = new Location(x, y);
		actor.setLocation(location);
		actors.add(actor);
		field.place(actor, location);
	}
	
	private void simulate(int numberOfSteps) {
		for (int i = 0; i < numberOfSteps; i++) {
			simulateOneStep();
		}
	}
	
	private void simulateOneStep() {
		Collections.shuffle(actors, RandomGenerator.getRandom());
		for(Actor actor : actors) {
			actor.act(field);
		}
		step++;
		view.showStatus(step, field);
	}
	
	public static void main(String[] args) {
		Simulation sim = new Simulation(50, 50);
		sim.populate();
		sim.simulate(10000);
	}
}
