import java.util.Arrays;
import java.util.List;

// Класс для представления шахматной доски
public class ChessBoard {
    private ChessPiece[][] board; // Двумерный массив для хранения фигур

    // Конструктор для инициализации доски
    public ChessBoard() {
        board = new ChessPiece[8][8];
        initializeBoard();
    }

    // Метод для инициализации доски с начальными позициями фигур
    private void initializeBoard() {
        // Инициализация доски с начальными позициями фигур
        board[0][0] = new Rook("black", 0, 0);
        board[0][1] = new Horse("black", 0, 1);
        board[0][2] = new Bishop("black", 0, 2);
        board[0][3] = new Queen("black", 0, 3);
        board[0][4] = new King("black", 0, 4);
        board[0][5] = new Bishop("black", 0, 5);
        board[0][6] = new Horse("black", 0, 6);
        board[0][7] = new Rook("black", 0, 7);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", 1, i);
            board[6][i] = new Pawn("white", 6, i);
        }

        board[7][0] = new Rook("white", 7, 0);
        board[7][1] = new Horse("white", 7, 1);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][3] = new Queen("white", 7, 3);
        board[7][4] = new King("white", 7, 4);
        board[7][5] = new Bishop("white", 7, 5);
        board[7][6] = new Horse("white", 7, 6);
        board[7][7] = new Rook("white", 7, 7);
    }

    // Метод для проверки, является ли ход валидным
    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // Метод для проверки, занята ли клетка фигурой
    public boolean isOccupied(int x, int y) {
        return board[x][y] != null;
    }

    // Метод для получения фигуры на доске
    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }

    // Метод для перемещения фигуры на доске
    public void movePiece(ChessPiece piece, int newX, int newY) {
        if (containsMove(piece.getPossibleMoves(this), newX, newY)) {
            board[piece.getX()][piece.getY()] = null;
            piece.setPosition(newX, newY);
            board[newX][newY] = piece;
        }
    }

    // Метод для проверки, содержится ли ход в списке возможных ходов
    private boolean containsMove(List<int[]> moves, int x, int y) {
        for (int[] move : moves) {
            if (Arrays.equals(move, new int[]{x, y})) {
                return true;
            }
        }
        return false;
    }

    // Метод для вывода доски в консоль
    public void printBoard() {
        System.out.println("   a  b  c  d  e  f  g  h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(" - ");
                } else {
                    ChessPiece piece = board[i][j];
                    String color = piece.getColor().equals("white") ? "w" : "b";
                    System.out.print(color + piece.getClass().getSimpleName().charAt(0) + " ");
                }
            }
            System.out.println(" " + (8 - i));
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }
}