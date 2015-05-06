package baseCode;

import java.util.Random;


public class RandomGenerator {
	private static Random random=null;
	private static int seed=27;

	public static void initialiseWithSeed(int s)
	{
		seed = s;
		random = new Random(seed);
	}
	
	public static Random getRandom()
	{
		if(random==null){
			random = new Random(seed);
		}
		return random;
	}	
}
