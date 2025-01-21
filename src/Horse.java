import java.util.ArrayList;
import java.util.List;

// Класс для коня, наследуется от ChessPiece
public class Horse extends ChessPiece {
    // Конструктор для инициализации коня
    public Horse(String color, int x, int y) {
        super(color, x, y);
    }

    // Реализация метода getPossibleMoves для коня
    @Override
    public List<int[]> getPossibleMoves(ChessBoard board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        // Проверка всех возможных ходов коня
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (board.isValidMove(newX, newY) && (!board.isOccupied(newX, newY) || !board.getPiece(newX, newY).getColor().equals(color))) {
                moves.add(new int[]{newX, newY});
            }
        }

        return moves;
    }
}