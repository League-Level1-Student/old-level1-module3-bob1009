import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
//10 by 10 square
public class gridworld {
public static void main(String[] args) {
	World world = new World();
	Location location1=new Location(5,5);
	Location location2=new Location(6,8);
	Bug bug1=new Bug();
	bug1.turn();
	bug1.turn();
	Bug bug2=new Bug(Color.blue);
	
	for (int i = 0; i < 100; i++) {
		Location location=new Location(i/10,i % 10);
		Flower flowey = new Flower();
		world.add(location, flowey);
	}
	world.add(location1, bug1);
	world.add(location2, bug2);
	world.show();
}
}
