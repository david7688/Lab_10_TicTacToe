import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '*';
                }
            }

            String play1 = "X";
            String play2 = "O";

            boolean player1 = true;
            boolean gameEnded = false;

            while (!gameEnded) {
                drawBoard(board);

                if (player1) {
                    System.out.println("Player 1's Turn (X)");
                } else {
                    System.out.println("Player 2's Turn (O)");
                }

                char c = '-';
                if (player1) {
                    c = 'X';
                } else {
                    c = 'O';
                }

                int row = 0;
                int col = 0;

                while (true) {
                    System.out.print("Enter row number (0, 1, or 2): ");
                    row = scan.nextInt();
                    System.out.print("Enter column number (0, 1, or 2): ");
                    col = scan.nextInt();
                    if (row < 0 || col < 0 || row > 2 || col > 2) {
                        System.out.println("Input is incorrect. Enter 0, 1, or 2.");
                    } else if (board[row][col] != '*') {
                        System.out.println("There is already a move here");
                    } else {
                        break;
                    }

                }

                board[row][col] = c;
                if (playerHasWon(board) == 'X') {
                    System.out.println("X Won");
                    gameEnded = true;
                } else if (playerHasWon(board) == 'O') {
                    System.out.println("O Won");
                    gameEnded = true;
                } else {
                    if (boardIsFull(board)) {
                        System.out.println("It's a tie");
                        gameEnded = true;
                    } else {
                        player1 = !player1;
                    }
                }
            }
            drawBoard(board);

            System.out.print("Do you want to play again? Enter y or n: ");
            String playAgain = scan.nextLine();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }

        }

    }

    // methoods that create board

    private static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char playerHasWon(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2] &&
                    board[i][0] != '*') {
                return board[i][0];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j] &&
                    board[0][j] != '*') {
                return board[0][j];
            }
        }

        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != '*') {
            return board[0][0];
        }

        if (board[2][0] == board[1][1] &&
                board[1][1] == board[0][2] &&
                board[2][0] != '*') {
            return board[2][0];
        }

        return ' ';
    }

    public static boolean boardIsFull(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;



    }
}
