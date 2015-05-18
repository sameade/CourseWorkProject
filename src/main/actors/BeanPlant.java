package actors;

import java.util.ArrayList;

import labClasses.ModelConstants;
import baseCode.Field;
import baseCode.RandomGenerator;

public class BeanPlant extends Plant {
	
	public BeanPlant(boolean generateAge) {
		if(generateAge == true) {
			this.setAge(RandomGenerator.getRandom().nextInt(ModelConstants.BEAN_MAX_AGE));
		} else {
			this.setAge(0);
		}
		this.setAlive(true);
	}
	
	@Override
	protected void incrementAge() {
		int currentAge = this.getAge();
		if (currentAge < ModelConstants.BEAN_MAX_AGE) {
			this.setAge(++currentAge);
		} else {
			this.setAlive(false);
		}
	}

	@Override
	public void act(Field field, ArrayList<Actor> actors) {
		incrementAge();
	}
	
	

}
