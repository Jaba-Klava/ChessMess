import java.util.ArrayList;
import java.util.List;

// Класс для ладьи, наследуется от ChessPiece
public class Rook extends ChessPiece {
    // Конструктор для инициализации ладьи
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    // Реализация метода getPossibleMoves для ладьи
    @Override
    public List<int[]> getPossibleMoves(ChessBoard board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Проверка всех возможных ходов ладьи
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            while (board.isValidMove(newX, newY)) {
                if (board.isOccupied(newX, newY)) {
                    if (!board.getPiece(newX, newY).getColor().equals(color)) {
                        moves.add(new int[]{newX, newY});
                    }
                    break;
                }
                moves.add(new int[]{newX, newY});
                newX += dir[0];
                newY += dir[1];
            }
        }

        return moves;
    }
}