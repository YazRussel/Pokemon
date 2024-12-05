import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Main() {
        setTitle("Pokemon Game");
        setBackground(Color.WHITE);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = Character.getNumericValue(e.getKeyChar());
                pokemons.removeIf(pokemon -> pokemon.getId() == key);
                repaint();

            }
        });
        initializePokemons();
    }

    private void initializePokemons() {
        Random random = new Random();
        Class[] types = {Pichu.class, Pikachu.class, Raichu.class, Charmander.class, Charmeleon.class, Charizard.class};
        pokemons.clear();
        for (int i = 0; i < 9; i++) {
            try {
                int idx = random.nextInt(types.length);
                Pokemon pokemon = (Pokemon) types[idx].getDeclaredConstructor().newInstance();
                pokemons.add(pokemon);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Pokemon pokemon : pokemons) {
            pokemon.draw(g);
        }
        if (pokemons.isEmpty()) {
            initializePokemons();
            repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
