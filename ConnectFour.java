
public class ConnectFour {

	public static void main(String[] args) {

		// Create new board object
		Board b1 = new Board();
		CFGUI g1 = new CFGUI(b1, ChipColor.RED, ChipColor.BLACK);
		int versus;
		int ai;
		String s = "";
		// Set player tokens for player 1 and player 2
		b1.setPlayerOne('X');
		b1.setPlayerTwo('Y');
		
		Player p1 = new HumanPlayer(1, 6, 7);
		
		System.out.println("Welcome to Connect Four");
		System.out.println("Who would you like to play:\n\t1.Human\n\t2.Computer");
		System.out.print("Enter: ");
		versus = GIO.readInt(s);
		while(versus != 1 && versus != 2) {
			System.out.print("Invalid Input.");
			System.out.println("Who would you like to play:\n\t1.Human\n\t2.Computer");
			System.out.print("Enter: ");
			versus = GIO.readInt(s);
		}
		if(versus == 1) {
			Player p2 = new HumanPlayer(2, 6, 7);
			while (b1.isFinished() != 1 || b1.isFinished() != 2 || b1.isFinished() != 0) {
				System.out.print("Player 1 - Pick a column: ");
				int x = p1.playToken();
				b1.play(p1.getPlayerID(), x);
				g1.redraw();
				System.out.println("Status of game: " + b1.isFinished());
				if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
					g1.gameOver(b1.isFinished());
					g1.close();
					break;
				}
				p2.lastMove(x);
				System.out.print("Player 2 - Pick a column: ");
				int y = p2.playToken();
				b1.play(p2.getPlayerID(), y);
				g1.redraw();
				System.out.println("Status of game: " + b1.isFinished());
				p1.lastMove(y);
				if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
					g1.gameOver(b1.isFinished());
					g1.close();
					break;
				}
			}
		}
		if(versus == 2) {
			System.out.println("What difficulty would you like to play against:\n\t1.Easy\n\t2.Hard");
			System.out.print("Enter: ");
			ai = GIO.readInt(s);
			while(ai != 1 && ai != 2) {
				System.out.println("Invalid Input.");
				System.out.println("What difficulty would you like to play against:\n\t1.Easy\n\t2.Hard");
				System.out.print("Enter: ");
				ai = GIO.readInt(s);
			}
			if(ai == 1) {
				Player p2 = new AIPlayer1(1,6,7);
				while (b1.isFinished() != 1 || b1.isFinished() != 2 || b1.isFinished() != 0) {
					System.out.print("Player 1 - Pick a column: ");
					int x = p1.playToken();
					b1.play(p1.getPlayerID(), x);
					g1.redraw();
					System.out.println("Status of game: " + b1.isFinished());
					if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
						g1.gameOver(b1.isFinished());
						g1.close();
						break;
					}
					p2.lastMove(x);
					int y = p2.playToken();
					b1.play(p2.getPlayerID(), y);
					g1.redraw();
					System.out.println("Status of game: " + b1.isFinished());
					p1.lastMove(y);
					if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
						g1.gameOver(b1.isFinished());
						g1.close();
						break;
					}
				}
			}
			if(ai == 2) {
				Player p2 = new AIPlayer(2,6,7);
				while (b1.isFinished() != 1 || b1.isFinished() != 2 || b1.isFinished() != 0) {
					System.out.print("Player 1 - Pick a column: ");
					int x = p1.playToken();
					b1.play(p1.getPlayerID(), x);
					g1.redraw();
					System.out.println("Status of game: " + b1.isFinished());
					if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
						g1.gameOver(b1.isFinished());
						g1.close();
						break;
					}
					p2.lastMove(x);
					int y = p2.playToken();
					b1.play(p2.getPlayerID(), y);
					g1.redraw();
					System.out.println("Status of game: " + b1.isFinished());
					p1.lastMove(y);
					if(b1.isFinished() == 1 || b1.isFinished() == 2 || b1.isFinished() == 0) {
						g1.gameOver(b1.isFinished());
						g1.close();
						break;
					}
				}
			}
		}
	}
}