
public class AIPlayer1 implements Player {
	// do not change the line above

		// Define your fields here
		Board b1 = new Board();
		private int playerID;
		private int row;
		private int col;
		private char board[][];

		// constructor takes the player id for this player, and the number of
		// rows and columns of the board we're playing on
		public AIPlayer1(int playerID, int row, int col) {
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
					board[i][c] = 'L';
					break;
				}
			}
		}

		// returns column of where to play a token
		public int playToken() {
			int play = (int) (Math.random() * this.col);
			while(play < 0 || play >= col || board[0][play] != ' ') {
				play = (int) (Math.random() * this.col);
			}
			for(int i = row-1; i >= 0; i--) {
				if(board[i][play] == ' ') {
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
