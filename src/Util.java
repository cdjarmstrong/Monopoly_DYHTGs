public class Util {
	public static void print(Player player, String msg) {
		System.out.println("[Turn: " + (player.getTotalWalk() + 1) + " Position: " + player.getCurrentPosition() + "] "+ msg);
	}
}
