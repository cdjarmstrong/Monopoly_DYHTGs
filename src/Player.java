import java.util.ArrayList;

public class Player {
	int totalWalk = 0;
	int position = 0;
	int id;
	String name;
	boolean brokeout = false;
	Money money = new Money(5000);
	ArrayList<HouseSquare> properties = new ArrayList<>();
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public void addProperty(HouseSquare property){
		properties.add(property);
	}
	public void printProperties(){
		for(HouseSquare property : properties){
			System.out.println(property.getName());
		}
	}
	
	public int getTotalWalk() {
		return totalWalk;
	}
	
	public int tossDie(Die die) {
		int face = die.getFace();
		Util.print(this, getName() + " toss a die... Face is " + face);
		return face;
	}
	
	public int getCurrentPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void nextTurn() {
		totalWalk++;
	}
	
	public String getName() {
		return name;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public int getID() {
		return id;
	}
	
	public void setBrokeOut(boolean brokeout) {
		this.brokeout = brokeout;
	}
	
	public boolean isBrokeOut() {
		return brokeout;
	}
}
