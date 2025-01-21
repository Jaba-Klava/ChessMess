import java.util.ArrayList;
import java.util.List;

// Класс для короля, наследуется от ChessPiece
public class King extends ChessPiece {
    // Конструктор для инициализации короля
    public King(String color, int x, int y) {
        super(color, x, y);
    }

    // Реализация метода getPossibleMoves для короля
    @Override
    public List<int[]> getPossibleMoves(ChessBoard board) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        // Проверка всех возможных ходов короля
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (board.isValidMove(newX, newY) && (!board.isOccupied(newX, newY) || !board.getPiece(newX, newY).getColor().equals(color))) {
                moves.add(new int[]{newX, newY});
            }
        }

        // Проверка на рокировку
        if (canCastle(board)) {
            if (color.equals("white")) {
                moves.add(new int[]{2, 0}); // Длинная рокировка
                moves.add(new int[]{6, 0}); // Короткая рокировка
            } else {
                moves.add(new int[]{2, 7}); // Длинная рокировка
                moves.add(new int[]{6, 7}); // Короткая рокировка
            }
        }

        return moves;
    }

    // Метод для проверки возможности рокировки
    private boolean canCastle(ChessBoard board) {
        // Проверка условий для рокировки
        return false; // Пока просто заглушка
    }
}