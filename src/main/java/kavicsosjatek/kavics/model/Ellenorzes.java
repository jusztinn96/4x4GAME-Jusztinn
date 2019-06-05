package kavicsosjatek.kavics.model;

import kavicsosjatek.kavics.view.Jatekablak;

import static kavicsosjatek.kavics.view.Jatekablak.mezok;

public class Ellenorzes {

    /**
     * Megszámolja, hogy a táblánk valóban 4x4 mezőből áll.
     *
     * @return Mezők darabszáma
     */
    public int mezokEllenorzese() {
        /**
         * Ezen változó segítségével tartjuk számon, hogy hány mezőt számoltunk már meg.
         */
        mezok = 0;
        for (int r = 0; r < 4; r++) {
            for (int col = 0; col < 4; col++) {
                if (Jatekablak.board[r][col] == 1)
                    mezok++;
            }
        }
        return (mezok);
    }

}
