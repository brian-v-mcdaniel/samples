package Baseball2;

import java.awt.EventQueue;

public class Baseball2 {
	
	static Scoreboard scoreboard;
	static Controlboard controlboard;
	
	public static void main(String arguments[]) {
		try {
			scoreboard = new Scoreboard();
			scoreboard.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
			Controlboard controlboard = new Controlboard();
			controlboard.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		// scoreboard.add_runs(1,1);
		// scoreboard.add_runs(1,1);		
		// scoreboard.add_runs(2,10);
		// scoreboard.subtract_runs(1,1);
	}
}
