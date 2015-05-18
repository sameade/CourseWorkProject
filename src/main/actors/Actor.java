package actors;

import java.util.ArrayList;

import baseCode.Field;
import baseCode.Location;

public abstract class Actor {
	
	public abstract void act(Field field, ArrayList<Actor> actors);
	
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
