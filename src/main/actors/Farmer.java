package actors;

import baseCode.Field;
import baseCode.Location;

public class Farmer extends Actor {

	@Override
	public void act(Field field) {
		Location location = field.freeAdjacentLocation(this.getLocation());
		if (location != null) {
			field.clearLocation(this.getLocation());
			field.place(this, location);
			this.setLocation(location);
		}
	}

}
