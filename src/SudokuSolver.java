import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SudokuSolver {
    private static final int GRID_SIZE = 9;
    
    public static void main(String[] args) {
        // Launch the GUI instead of the console version
        SwingUtilities.invokeLater(() -> {
            new SudokuGUI().setVisible(true);
        });
    }

    // Make these methods public so they can be accessed from the GUI
    public static boolean isNumberInRow(int[][] board, int number, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isNumberInColumn(int[][] board, int number, int column) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row%3;
        int localBoxColumn = column - column%3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++) {
            for(int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if(board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isValidStatement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) && 
               !isNumberInColumn(board, number, column) && 
               !isNumberInBox(board, number, row, column);
    }
    
    public static boolean solveBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int column = 0; column < GRID_SIZE; column++) {
                if(board[row][column] == 0) {
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(isValidStatement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            if(solveBoard(board))
                                return true;
                            else
                                board[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Keep this method for debugging purposes
    public static void printBoard(int[][] board) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if (i%3==0 && i!=0)
                System.out.println("- - - - - - - - - - -");
            for(int j = 0; j < GRID_SIZE; j++) {
                if(j%3==0 && j!=0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}