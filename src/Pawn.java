import java.util.ArrayList;
import java.util.List;

// Класс для пешки, наследуется от ChessPiece
public class Pawn extends ChessPiece {
    // Конструктор для инициализации пешки
    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    // Реализация метода getPossibleMoves для пешки
    @Override
    public List<int[]> getPossibleMoves(ChessBoard board) {
        List<int[]> moves = new ArrayList<>();
        int direction = color.equals("white") ? -1 : 1;

        // Проверка хода вперед
        int newX = x + direction;
        if (board.isValidMove(newX, y) && !board.isOccupied(newX, y)) {
            moves.add(new int[]{newX, y});
        }

        // Проверка двойного хода вперед
        if ((x == 1 && color.equals("black")) || (x == 6 && color.equals("white"))) {
            newX = x + 2 * direction;
            if (board.isValidMove(newX, y) && !board.isOccupied(newX, y)) {
                moves.add(new int[]{newX, y});
            }
        }

        // Проверка атаки
        int[] attackDirections = {1, -1};
        for (int dy : attackDirections) {
            newX = x + direction;
            int newY = y + dy;
            if (board.isValidMove(newX, newY) && board.isOccupied(newX, newY) && !board.getPiece(newX, newY).getColor().equals(color)) {
                moves.add(new int[]{newX, newY});
            }
        }

        return moves;
    }
}