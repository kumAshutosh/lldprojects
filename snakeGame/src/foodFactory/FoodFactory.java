package foodFactory;

public class FoodFactory {
	public static FoodItem createFood(int[] position, String type) {
		switch(type) {
		case "bonus": return new BonusFood(position[0], position[1]);
		case "poison": return new PoisonFood(position[0], position[1]);
		default: return new NormalFood(position[0], position[1]);
		}
	}
}
