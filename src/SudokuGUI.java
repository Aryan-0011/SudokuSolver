import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {
    private static final int GRID_SIZE = 9;
    private JTextField[][] cells;
    private int[][] board;
    private SudokuSolver solver;

    public SudokuGUI() {
        solver = new SudokuSolver();
        board = new int[GRID_SIZE][GRID_SIZE];
        cells = new JTextField[GRID_SIZE][GRID_SIZE];
        
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create the main panel with grid layout
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create cells
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                
                // Add borders to create 3x3 boxes
                if ((i / 3 + j / 3) % 2 == 0) {
                    cells[i][j].setBackground(new Color(240, 240, 240));
                }
                
                // Add input validation
                cells[i][j].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) || c == '0') {
                            e.consume();
                        }
                    }
                });
                
                gridPanel.add(cells[i][j]);
            }
        }
        
        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");
        
        solveButton.addActionListener(e -> solvePuzzle());
        clearButton.addActionListener(e -> clearBoard());
        
        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);
        
        // Add components to frame
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Set frame properties
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void solvePuzzle() {
        // Get values from text fields
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                String text = cells[i][j].getText();
                board[i][j] = text.isEmpty() ? 0 : Integer.parseInt(text);
            }
        }
        
        // Try to solve the puzzle
        if (solver.solveBoard(board)) {
            // Update the GUI with the solution
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    cells[i][j].setText(String.valueOf(board[i][j]));
                }
            }
            JOptionPane.showMessageDialog(this, "Puzzle solved successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j].setText("");
                board[i][j] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SudokuGUI().setVisible(true);
        });
    }
} 