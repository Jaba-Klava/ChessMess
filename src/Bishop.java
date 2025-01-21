import java.util.ArrayList;
import java.util.List;

// Класс для слона, наследуется от ChessPiece
public class Bishop extends ChessPiece {
    // Конструктор для инициализации слона
    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    // Реализация метода getPossibleMoves для слона
    @Override
    public List<int[]> getPossibleMoves(ChessBoard board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        // Проверка всех возможных ходов слона
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            while (board.isValidMove(newX, newY)) {
                if (board.isOccupied(newX, newY)) {
                    if (!board.getPiece(newX, newY).getColor().equals(color)) {
                        moves.add(new int[]{newX, newY});
                    }
                    break; // Прерываем цикл, если встретили фигуру
                }
                moves.add(new int[]{newX, newY});
                newX += dir[0];
                newY += dir[1];
            }
        }

        return moves;
    }
}