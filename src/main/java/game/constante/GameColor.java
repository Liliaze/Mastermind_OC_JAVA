package game.constante;

public enum GameColor {

    BLACK("\033[30m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    PINK("\033[35m"),
    CYAN("\033[36m"),
    GREY("\033[37m"),
    DEFAULT("\033[0m");

    private final String color;

    GameColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void print(String msg, boolean backSlash) {
        System.out.print(this.color);
        if (backSlash)
            System.out.println(msg);
        else
            System.out.print(msg);
        System.out.print("\033[0m");
    }
    public void print(String msg) {
        System.out.print(this.color);
            System.out.println(msg + "\033[0m");
    }
}
