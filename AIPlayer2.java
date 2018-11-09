public class AIPlayer2 implements Player {
	// do not change the line above

	// Define your fields here
	Board b1 = new Board();
	private int playerID;
	private int row;
	private int col;
	private char moves[][];

	// constructor takes the player id for this player, and the number of
	// rows and columns of the board we're playing on
	public AIPlayer2(int playerID, int row, int col) {
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		moves = new char[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				moves[i][j] = ' ';
			}
		}
	}

	// used to notify your AI player of the other players last move
	public void lastMove(int c) {
		for(int i = row-1; i >= 0; i--) {
			if(moves[i][c] == ' ') {
				moves[i][c] = 'C';
				break;
			}
		}
	}

	// returns column of where to play a token
	public int playToken() {
		int random = (col/2)-1;
		while(random < 0 || random >= col || moves[0][random] != ' ') {
			random = (int) (Math.random() * this.col);
		}
		
		for(int i = row-1; i >= 0; i--) {
			for(int j = col-1; j >= 0; j--) {

				if(j-1<0||j+1>=col)
				{
					break;
				}
				if(moves[i][j] == moves[i][j-1]&&moves[i][j]!=' ') {
					if(moves[i][j+1] != ' ') {
						break;
					
					}
	
					random=j+1;
				}
			}}
		for(int i = row-1; i >= 0; i--) {
			if(moves[i][random] == ' ') {
				moves[i][random] = 'L';
				break;
			}
		}
		return random;
	}

	// get this player's id
	public int getPlayerID() {
		return playerID;
	}

	// resets the state of the player in preparation for a new game
	public void reset() {
		moves = new char[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				moves[i][j] = ' ';
			}
		}
	}
}