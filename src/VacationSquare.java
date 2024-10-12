import java.util.Random;
import java.util.Scanner;

public class VacationSquare extends Square {
	public VacationSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board, Scanner scanner) {
		Random rand = new Random();
		Square square = board.movePlayer(player, rand.nextInt(board.getTotalSquare()), false);
		Util.print(player, player.getName() + " has go to vacation at " + square.getName());
		
	}
}
