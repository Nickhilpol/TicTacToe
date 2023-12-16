import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameWon = false;

        while (true) {
            printBoard(board);

            int[] move = getPlayerMove(currentPlayer);

            if (board[move[0]][move[1]] == ' ') {
                board[move[0]][move[1]] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a tie!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }
    }
    // Structure of Game

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    //Player input here choice
    private static int[] getPlayerMove(char player) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        while (true) {
            System.out.print("Player " + player + ", enter row (0, 1, or 2): ");
            move[0] = scanner.nextInt();

            System.out.print("Player " + player + ", enter column (0, 1, or 2): ");
            move[1] = scanner.nextInt();

            if (move[0] >= 0 && move[0] < 3 && move[1] >= 0 && move[1] < 3) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        return move;
    }

    private static boolean checkWinner(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
