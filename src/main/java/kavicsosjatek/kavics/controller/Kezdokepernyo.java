package kavicsosjatek.kavics.controller;

import kavicsosjatek.kavics.view.Jatekablak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

/**
 * Ez az osztály felel a kezdőképernyő megjelenítéséért.
 *
 * @see kavicsosjatek.kavics
 */
public class Kezdokepernyo implements MouseListener {
    /**
     * Segítségével megvizsgáljuk a képernyő méretét.
     */
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Grafikus felület kirajzolásához használjuk.
     */
    Drawing draw = new Drawing();
    /**
     * Ablak címsorának elnevezésére használjuk.
     */
    JFrame kezdo = new JFrame("4x4 kavics játék - kezdőképernyő");
    /**
     * Üzenet megjelenítésére szolgál a játékosok számára.
     */
    JLabel uzenet = new JLabel("Válasszon egy opciót!");
    /**
     * Háttérképhez változó deklarálás.
     */
    ImageIcon hatter;
    /**
     * Start gombhoz változó deklarálás.
     */
    ImageIcon elsomenu;
    /**
     * Szabályok gombhoz változó deklarálás.
     */
    ImageIcon masodikmenu;
    /**
     * Előzmények gombhoz változó deklarálás.
     */
    ImageIcon harmadikmenu;


    /**
     * Ablak megjelenítését szolgálja.
     *
     * @see kavicsosjatek.kavics
     */
    public Kezdokepernyo() {
        hatter = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("hatter.jpg")));
        elsomenu = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("start-gomb.jpg")));
        masodikmenu = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("szabalyok-gomb.jpg")));
        harmadikmenu = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("elozo-gomb.jpg")));
        kezdo.add(draw);
        draw.addMouseListener(this);
        kezdo.setSize(800, 600);
        kezdo.setLocation(dim.width / 2 - kezdo.getSize().width / 2, dim.height / 2 - kezdo.getSize().height / 2);
        uzenet.setFont(new Font("Serif", Font.BOLD, 20));
        uzenet.setForeground(Color.black);
        uzenet.setHorizontalAlignment(SwingConstants.CENTER);
        kezdo.add(uzenet, "South");
        kezdo.setVisible(true);
    }

    /**
     * A háttérkép és a menüpontok elhelyezésére szolgál az ablakban.
     */
    class Drawing extends JComponent {
        /**
         * @param g Felület kirajzolása.
         */
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g.drawImage(hatter.getImage(), 0, 0, this);
            g.drawImage(elsomenu.getImage(), 250, 200, this);
            g.drawImage(masodikmenu.getImage(), 250, 280, this);
            g.drawImage(harmadikmenu.getImage(), 250, 360, this);
        }
    }

    /**
     * @param e Egérmozgás megfigyelésére szolgál.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * @param e Egér kattintások érzékelésére és kezelésére szolgál. Menüpontokra kattintva az megfelelő eseményt hajtja végre.
     */
    public void mouseReleased(MouseEvent e) {
        int row = e.getX();
        int col = e.getY();
        if (row >= 250 && row <= 550 && col >= 200 && col <= 280) {
            kezdo.dispose();
            new Jatekablak();
            Jatekablak.board = new int[4][4];
        }
        if (row >= 250 && row <= 550 && col >= 281 && col <= 360) {
            kezdo.dispose();
            new Szabalyok();
        }
        if (row >= 250 && row <= 550 && col > 361 && col <= 440) {
            kezdo.dispose();
            new Elozmenyek();
        }
    }

    /**
     * @param e Egérmozgás megfigyelésére szolgál.
     */
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * @param e Egérmozgás megfigyelésére szolgál.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * @param e Egérmozgás megfigyelésére szolgál.
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * A kezdőképernyő ablak megjelenítése.
     *
     * @param args A kezdő paraméter.
     */
    public static void main(String[] args) {
        new Kezdokepernyo();
    }
}