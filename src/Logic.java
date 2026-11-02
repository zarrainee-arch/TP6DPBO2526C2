import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic implements ActionListener, java.awt.event.KeyListener {

    private Player player;
    private View view;
    private Timer gameLoop;
    private Timer pipesCooldown;
    private ArrayList<Pipe> pipes;
    private int pipeWidth = 64;
    private int pipeGap = 150;
    private int pipeVelocityX = -4;
    private int boardWidth = 360;
    private int boardHeight = 640;
    private boolean gameOver = false;
    private int score = 0;

    public Logic(View view) {
        this.view = view;

        player = new Player(100, 250, 34, 24);
        pipes = new ArrayList<>();

        pipesCooldown = new Timer(1500, e -> placePipe());

        gameLoop = new Timer(1000 / 60, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.setVelocityY(player.getVelocityY() + 1);
        player.setY(player.getY() + player.getVelocityY());

        for (Pipe pipe : pipes) {
            pipe.setX(pipe.getX() + pipeVelocityX);
            if (pipe.getY() > 0
                    && !pipe.isPassed()
                    && player.getX() > pipe.getX() + pipe.getWidth()) {

                score++;
                view.updateScore(score);
                pipe.setPassed(true);
            }
        }
        checkCollision();
        view.repaint();
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE && !gameOver) {
            player.setVelocityY(-10);
        }

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_R && gameOver) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }

    public void placePipe() {
        Random random = new Random();

        int randomPipeY = -150 - random.nextInt(200);

        Pipe topPipe = new Pipe(
                boardWidth,
                randomPipeY,
                pipeWidth,
                300
        );

        Pipe bottomPipe = new Pipe(
                boardWidth,
                randomPipeY + 300 + pipeGap,
                pipeWidth,
                300
        );

        pipes.add(topPipe);
        pipes.add(bottomPipe);
    }

    private void checkCollision() {
        // Cek apakah burung menyentuh batas bawah layar
        if (player.getY() + player.getHeight() >= boardHeight) {
            gameOver = true;
        }

        // Cek tabrakan burung dengan pipa
        for (Pipe pipe : pipes) {
            if (player.getX() < pipe.getX() + pipe.getWidth()
                    && player.getX() + player.getWidth() > pipe.getX()
                    && player.getY() < pipe.getY() + pipe.getHeight()
                    && player.getY() + player.getHeight() > pipe.getY()) {

                gameOver = true;
                break;
            }
        }
        if (gameOver) {
            gameLoop.stop();
            pipesCooldown.stop();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public void restartGame() {
        gameOver = false;
        score = 0;
        view.updateScore(score);

        player.setX(100);
        player.setY(250);
        player.setVelocityY(0);

        pipes.clear();

        pipesCooldown.start();
        gameLoop.start();

        view.repaint();
    }

    public void startGame() {
        gameOver = false;

        player.setX(100);
        player.setY(250);
        player.setVelocityY(0);

        score = 0;
        view.updateScore(score);

        pipes.clear();

        pipesCooldown.start();
        gameLoop.start();

        view.requestFocusInWindow();
        view.repaint();
    }
}