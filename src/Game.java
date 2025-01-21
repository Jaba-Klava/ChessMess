import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

// Класс для управления игрой
public class Game {
    private ChessBoard board; // Доска для игры
    private String currentPlayer; // Текущий игрок

    // Конструктор для инициализации игры
    public Game() {
        board = new ChessBoard();
        currentPlayer = "white";
    }

    // Метод для запуска игры
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println("Ход игрока: " + currentPlayer);
            System.out.print("Введите координаты фигуры (например, 'e2'): ");
            String input = scanner.nextLine();
            int fromX = 8 - (input.charAt(1) - '0');
            int fromY = input.charAt(0) - 'a';

            System.out.print("Введите координаты хода (например, 'e4'): ");
            input = scanner.nextLine();
            int toX = 8 - (input.charAt(1) - '0');
            int toY = input.charAt(0) - 'a';

            ChessPiece piece = board.getPiece(fromX, fromY);
            if (piece != null && piece.getColor().equals(currentPlayer)) {
                List<int[]> possibleMoves = piece.getPossibleMoves(board);
                System.out.println("Возможные ходы: " + formatMoves(possibleMoves));
                if (containsMove(possibleMoves, toX, toY)) {
                    board.movePiece(piece, toX, toY);
                    currentPlayer = currentPlayer.equals("white") ? "black" : "white";
                } else {
                    System.out.println("Неверный ход, попробуйте еще раз.");
                }
            } else {
                System.out.println("Неверный ход, попробуйте еще раз.");
            }
        }
    }

    // Метод для форматирования списка возможных ходов в читаемый формат
    private String formatMoves(List<int[]> moves) {
        StringBuilder sb = new StringBuilder();
        for (int[] move : moves) {
            sb.append("[").append((char) ('a' + move[1])).append(8 - move[0]).append("] ");
        }
        return sb.toString();
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
}