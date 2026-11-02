import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");

        frame.setSize(360, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Membuat Main Menu
        JPanel menuPanel = new JPanel(new GridLayout(3, 1, 10, 20));
        menuPanel.setBackground(Color.cyan);

        JLabel title = new JLabel("FLAPPY BIRD", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));

        JButton startButton = new JButton("START GAME");
        JButton exitButton = new JButton("EXIT");

        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));

        menuPanel.add(title);
        menuPanel.add(startButton);
        menuPanel.add(exitButton);

        // Membuat View Game
        View view = new View();

        // Tombol Start Game
        startButton.addActionListener(e -> {
            frame.setContentPane(view);
            frame.revalidate();
            view.startGame();
        });

        // Tombol Exit
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Menampilkan Main Menu
        frame.setContentPane(menuPanel);
        frame.setVisible(true);
    }
}