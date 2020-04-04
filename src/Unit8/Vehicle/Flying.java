package Unit8.Vehicle;

public interface Flying {
	/** @throws IllegalArgumentException if miles is negative. */
	public boolean canFly(double miles);

	/** @throws IllegalArgumentException if miles is negative. */
	public void fly(double miles);
}
