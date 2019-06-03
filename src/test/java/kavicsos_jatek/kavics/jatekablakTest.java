package kavicsos_jatek.kavics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class jatekablakTest {

    int mezok_test = 0;

    @Before
    public void setUp() throws Exception {
        int col;
        int r;
        int[][] board = new int[4][4];

        for (r = 0; r < 4; r++) {
            for (col = 0; col < 4; col++) {
                if (board[r][col] == 1)
                    mezok_test++;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Assert.assertEquals((mezok_test), (jatekablak.mezok));
    }
}