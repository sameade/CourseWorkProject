package actors;

import baseCode.Field;
import baseCode.Location;

public abstract class Actor {
	
	private Location location;
	
	public abstract void act(Field field);

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
