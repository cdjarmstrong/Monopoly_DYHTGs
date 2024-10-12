import java.util.Scanner;
public class Monopoly {
	Die die = new Die();
	Board board;


	public Monopoly(int totalPlayer, Scanner scanner) {
		board = new Board(totalPlayer, scanner);
	}
	
	public static void main(String[] args) {
		System.out.println("\tMonopoly\n");
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}

		Monopoly game = new Monopoly(totalPlayer, scanner);
		game.startGame(scanner);
		scanner.close();
	}
	
	public void startGame(Scanner scanner) {
		System.out.println("Game start!");
		System.out.println("========");
		while (!isGameEnd() && !board.hasWinner()){
			if(!board.getCurrentPlayer().isBrokeOut()){
				Player currentPlayer = board.getCurrentPlayer();
				String lifeChoice;
                System.out.println("Press enter to roll die...");
			    scanner.nextLine();
				

				int face = currentPlayer.tossDie(die);
				System.out.println(currentPlayer.getName() + " has the balance: " + currentPlayer.getMoney().getMoney());
				if(!currentPlayer.properties.isEmpty()){
					System.out.println(currentPlayer.getName() + " has the properties: ");
					currentPlayer.printProperties();
				}
				
				board.movePlayer(currentPlayer, face);
				System.out.println("Would you like to make a questionable life decision? y/n");
				boolean correctInput = false;
				while(!correctInput){
					try {
						lifeChoice = scanner.nextLine();
						if(lifeChoice.equals("y")){
							System.out.println("Good");
							correctInput = true;
						}else if (lifeChoice.equals("n")){
							System.out.println("Alright then, your loss.");
							correctInput = true;
						}else{
							System.out.println("Invalid input, try again.");
						}
					} catch (Exception e) {
						System.out.println("Invalid input, try again.");
					}
				}
				
			}
			board.nextTurn();
		}
		System.out.println("========");
		if(board.hasWinner()){
			System.out.println(board.getWinner().getName() + " is won by don't brokeout!");
		}else{
			System.out.println(board.getMaxMoneyPlayer().getName() + " is won by have most money!");
		}
		System.out.println("Game over!");
		scanner.close();
	}
	
	public boolean isGameEnd() {
		for(Player player:board.getPlayers()){
			if(player.getTotalWalk() < 20){ return false; }
		}
		return true;
	}
}
