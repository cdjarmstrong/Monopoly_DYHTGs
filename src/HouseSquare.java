import java.util.Scanner;

public class HouseSquare extends Square {
	int price;
	int owner = -1;
	
	public HouseSquare(String name, int price) {
		super(name);
		this.price = price;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public void doAction(Player player, Board board, Scanner scanner) {
		if(owner < 0){
			boolean correctinput = false;
			while(!correctinput){
				Util.print(player, player.getName() + ", do you want to buy " + getName() + "? y/n");
				try {
					String input = scanner.nextLine();
					if(input.equals("y")){
						owner = player.getID();
						player.getMoney().substractMoney(price);
						Util.print(player, player.getName() + " buys " + getName());
						Util.print(player, player.getName() + " has the balance: " + player.getMoney().getMoney());
						player.addProperty(this);
						correctinput = true;
					}else if (input.equals("n")){
						Util.print(player, player.getName() + " doesn't want to buy " + getName());
						correctinput = true;
					}else{

						System.out.println("Invalid input, try again.");
					}
				} catch (Exception e) {
					System.out.println("Invalid input, try again.");
				}
			}
			
			
		}else{
			if(owner != player.getID()){
				int lost = price * 70 / 100;
				Util.print(player, player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).getName());
				player.getMoney().substractMoney(lost);
				board.getPlayer(owner).getMoney().addMoney(lost);
			}
		}
	}
}
