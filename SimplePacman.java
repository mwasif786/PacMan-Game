import java.util.Scanner;


class GameObject {
    private int x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}


class Pacman extends GameObject {
    private int score;

    public Pacman(int x, int y) {
        super(x, y);
        score = 0;
    }

    public void move(char direction) {
        int x = getX();
        int y = getY();

        switch (direction) {
            case 'w': x--; break;
            case 's': x++; break;
            case 'a': y--; break;
            case 'd': y++; break;
        }

        setX(x);
        setY(y);
    }

    public void eat() {
        score += 10;
    }

    public int getScore() {
        return score;
    }
}


class Ghost extends GameObject {

    public Ghost(int x, int y) {
        super(x, y);
    }

    // Simple chasing logic
    public void moveTowards(Pacman p) {
        int x = getX();
        int y = getY();

        if (x < p.getX()) x++;
        else if (x > p.getX()) x--;

        if (y < p.getY()) y++;
        else if (y > p.getY()) y--;

        setX(x);
        setY(y);
    }
}

// Main class
public class SimplePacman {
    static final int SIZE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pacman p = new Pacman(0, 0);
        Ghost g = new Ghost(4, 4);

        while (true) {
            drawBoard(p, g);

            System.out.println("Move (W/A/S/D) or Q to quit:");
            char move = sc.next().toLowerCase().charAt(0);

            if (move == 'q') {
                System.out.println("Game exited.");
                break;
            }

            p.move(move);


            if (p.getX() < 0) p.setX(0);
            if (p.getX() >= SIZE) p.setX(SIZE - 1);
            if (p.getY() < 0) p.setY(0);
            if (p.getY() >= SIZE) p.setY(SIZE - 1);

            g.moveTowards(p);

            p.eat();

            if (p.getX() == g.getX() && p.getY() == g.getY()) {
                drawBoard(p, g);
                System.out.println("Game Over! Ghost caught you!");
                System.out.println("Final Score: " + p.getScore());
                break;
            }

            System.out.println("Score: " + p.getScore());
        }

        sc.close();
    }


    static void drawBoard(Pacman p, Ghost g) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == p.getX() && j == p.getY())
                    System.out.print("P ");
                else if (i == g.getX() && j == g.getY())
                    System.out.print("G ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}