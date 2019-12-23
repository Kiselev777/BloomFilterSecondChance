import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BitSetTest {
    BitSet bs = new BitSet(20);
    @Test
    public void add() {
        bs.add(11);
        bs.add(15);
        int[] test = new int[1];
        test[0] = 34816;
        assertEquals(Arrays.toString(test), bs.toString());
        bs.add(8);
        int[] test1 = new int[1];
        test[0] = 35072;
        assertEquals(Arrays.toString(test),bs.toString());
    }

    @Test
    public void contains() {
        for (int i = 0; i <5 ; i++) {
            bs.add(i);
        }
        assertTrue(bs.contains(0));
        assertTrue(bs.contains(1));
        assertTrue(bs.contains(2));
        assertTrue(bs.contains(3));
        assertFalse(bs.contains(13));
        assertFalse(bs.contains(11));
        assertFalse(bs.contains(11));
        try {
            assertFalse(bs.contains(80));
            assertFalse(bs.contains(199));
            assertFalse(bs.contains(200));
        } catch (IllegalArgumentException e) {
            System.out.println("Превшают заданное значение");
        }
    }
    }
