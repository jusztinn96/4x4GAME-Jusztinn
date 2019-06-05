package kavicsosjatek.kavics.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

/**
 * Ez az osztály felel az előzmények megjelenítéséért.
 *
 * @see kavicsosjatek.kavics
 */
public class Elozmenyek implements MouseListener {
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
    static JFrame elozmeny = new JFrame("4x4 kavics játék - előzmények");
    /**
     * Üzenet megjelenítésére szolgál a játékosok számára.
     */
    JLabel uzenet = new JLabel("Eredménylista megtekintése");
    /**
     * Vissza gombhoz változó deklarálás.
     */
    ImageIcon visszagomb;
    /**
     * Háttérképhez változó deklarálás.
     */
    ImageIcon hatter;
    /**
     * Előzmények gombhoz változó deklarálás.
     */
    ImageIcon harmadikmenu;

    /**
     * Ablak megjelenítését szolgálja.
     *
     * @see kavicsosjatek.kavics
     */
    public Elozmenyek() {
        hatter = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("hatter_3.jpg")));
        visszagomb = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("visszagomb.png")));
        harmadikmenu = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("elozo-gomb.jpg")));
        elozmeny.add(draw);
        draw.addMouseListener(this);
        elozmeny.setSize(800, 600);
        elozmeny.setLocation(dim.width / 2 - elozmeny.getSize().width / 2, dim.height / 2 - elozmeny.getSize().height / 2);
        uzenet.setFont(new Font("Serif", Font.BOLD, 20));
        uzenet.setForeground(Color.black);
        uzenet.setHorizontalAlignment(SwingConstants.CENTER);
        elozmeny.add(uzenet, "South");
        elozmeny.setVisible(true);
    }

    /**
     * A háttérkép és a menüpontok elhelyezésére szolgál az ablakban.
     */
    class Drawing extends JComponent {
        /**
         * Festésre szolgál.
         *
         * @param g a grafika
         */
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g.drawImage(hatter.getImage(), 0, 0, this);
            g.drawImage(visszagomb.getImage(), 0, 0, this);
            g.drawImage(harmadikmenu.getImage(), 250, 425, this);
        }
    }

    /**
     * @param e Egérkattintás kezelésére szolgál.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * @param e Egérkezelésre szolgál. A menüpontokra kattintva a megfelelő esemény hajtja végre.
     */
    public void mouseReleased(MouseEvent e) {
        int row = e.getX();
        int col = e.getY();
        if (row >= 0 && row <= 40 && col >= 0 && col <= 40) {
            elozmeny.dispose();
            new Kezdokepernyo();
        }
        if (row >= 250 && row <= 550 && col >= 425 && col <= 505) {
            try {
                Runtime.getRuntime().exec("notepad" + " " + (getClass().getClassLoader().getResource("ered.xml").getFile()));
            } catch (Exception k) {
                JOptionPane.showMessageDialog(null, k.getMessage());
            }
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
}