
public class AIPlayer implements Player {
	
	// do not change the line above
	// Define your fields here
	private int playerID;
	private int row;
	private int col;
	private char board[][];
	
	// constructor takes the player id for this player, and the number of
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col) {
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		board = new char[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	// used to notify your AI player of the other players last move
	public void lastMove(int c) {
		for(int i = row-1; i >= 0; i--) {
			if(board[i][c] == ' ') {
				//L for last
				board[i][c] = 'L';
				break;
			}
		}
	}

	// returns column of where to play a token
	public int playToken() {
		int play = (col/2);
		while(play < 0 || play >= col || board[0][play] != ' ') {
			play = (int) (Math.random() * this.col);
		}
		for(int i = row-1; i >= 0; i--) {
			for(int j = col-1; j >= 0; j--) {
				if(j-1 < 0 || j+1 >= col)
				{
					break;
				}
				if(board[i][j] == board[i][j-1] && board[i][j] != ' ') {
					if(board[i][j+1] != ' ') {
						break;
					}
					play=j+1;
				}
			}
		}
		for(int i = row-1; i >= 0; i--) {
			if(board[i][play] == ' ') {
				//C for current
				board[i][play] = 'C';
				break;
			}
		}
		return play;
	}

	// get this player's id
	public int getPlayerID() {
		return playerID;
	}

	// resets the state of the player in preparation for a new game
	public void reset() {
		board = new char[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
}