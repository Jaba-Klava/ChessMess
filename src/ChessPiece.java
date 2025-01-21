import java.util.List;

// Абстрактный класс для всех шахматных фигур
public abstract class ChessPiece {
    protected String color; // Цвет фигуры (белый или черный)
    protected int x; // Координата x на доске
    protected int y; // Координата y на доске

    // Конструктор для инициализации фигуры
    public ChessPiece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Абстрактный метод для получения возможных ходов
    public abstract List<int[]> getPossibleMoves(ChessBoard board);

    // Метод для проверки, может ли фигура атаковать другую фигуру
    public boolean canAttack(ChessPiece target, ChessBoard board) {
        List<int[]> possibleMoves = getPossibleMoves(board);
        for (int[] move : possibleMoves) {
            if (move[0] == target.x && move[1] == target.y) {
                return true;
            }
        }
        return false;
    }

    // Геттеры и сеттеры для координат
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + getClass().getSimpleName() + " at " + (char) ('a' + y) + (8 - x);
    }
}