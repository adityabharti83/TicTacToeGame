import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        // create a 3x3 char array to store the board
        char[][] board = new char[3][3];
        // initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        // create a scanner object to get user input
        Scanner input = new Scanner(System.in);
        // create a boolean variable to store the game status
        boolean gameOver = false;
        // create a char variable to store the current player
        char player = 'X';
        // loop until the game is over
        while (!gameOver) {
            // display the board
            displayBoard(board);
            // prompt the current player to enter their move[^2^][2]
            System.out.println("Player " + player + ", enter your move (row[1-3] and column[1-3]):");
            int row = input.nextInt() - 1; // subtract 1 to match the array index
            int col = input.nextInt() - 1;
            // validate the move
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                // if the move is valid, mark the board with the player's symbol
                board[row][col] = player;
                // check if the player has won or the board is full
                if (isWinning(board, player)) {
                    // if the player has won, display the result and end the game
                    displayBoard(board);
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isFull(board)) {
                    // if the board is full, display the result and end the game
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    // otherwise, switch the player and continue the game
                    player = switchPlayer(player);
                }
            } else {
                // if the move is invalid, display an error message and ask for another move
                System.out.println("Invalid move. Try again.");
            }
        }
        input.close();
    }

    // a method that displays the board
    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // a method that checks if a player has won by forming a line of their symbol
    public static boolean isWinning(char[][] board, char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        // otherwise, no winning condition is met
        return false;
    }

    // a method that checks if the board is full of symbols
    public static boolean isFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // a method that switches the player's symbol
    public static char switchPlayer(char player) {
        if (player == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }
}
