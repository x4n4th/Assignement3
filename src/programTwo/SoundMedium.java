package programTwo;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public abstract class SoundMedium {

	/**
	 * Medium to which sound will travel
	 */

	protected int speed;
	protected int id;

	private String name;

	public static final SoundMedium AIR = new Air();
	public static final SoundMedium WATER = new Water();
	public static final SoundMedium STEEL = new Steel();

	@SuppressWarnings("serial")
	public static final HashMap<String, Class<? extends SoundMedium>> mediumTypes = new HashMap<String, Class<? extends SoundMedium>>() {
		{
			put("air", Air.class);
			put("water", Water.class);
			put("steel", Steel.class);
		}
	};

	SoundMedium(int speed, int id, String name) {
		this.speed = speed;
		this.name = name;
		this.id = id;
	}

	public double getTime(double distance) {
		return distance / speed;
	}

	public double getSpeed() {
		return speed;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SoundMedium parseSelection(String input)
			throws SoundMediumNotFoundException {
		input = input.toLowerCase();

		try {
			return classForType(input).getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new SoundMediumNotFoundException();
		}
	}

	public static Class<? extends SoundMedium> classForType(String type) {
		return (Class<? extends SoundMedium>) (mediumTypes.containsKey(type) ? mediumTypes
				.get(type) : null);
	}
}
