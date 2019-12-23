import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class BloomFilterTest {
    BloomFilter f1 = new BloomFilter(99, 43);
    BloomFilter f = new BloomFilter(789, 4);

    @Test
    public void add() {
        f1.add(999);
        for (int i = 0; i <80 ; i++) {
            f1.add(Math.random());
        }
        f1.add("ytyt");
        assertTrue(f1.contains(999));
        assertTrue(f1.contains("ytyt"));
        assertFalse(f1.contains("479283798432798473984729874307143908743019"));
    }

    @Test
    public void contains() {
        assertFalse(f.contains(43));
        assertFalse(f.contains("jkjsd"));
        for (int i = 0; i <20 ; i++) {
            f1.add(i);
        }
        assertTrue(f1.contains(7));
        assertTrue(f1.contains(8));
        assertTrue(f1.contains(9));
        assertTrue(f1.contains(3));
        BloomFilter f2=new BloomFilter(44,42);
        f2.add(989);
        f2.add("jhdsjh");
        f2.add(13.032);
        assertTrue(f2.contains(989));
        assertTrue(f2.contains("jhdsjh"));
        assertTrue(f2.contains(13.032));
        try {
            assertFalse(f2.contains(98274924));
            assertFalse(f2.contains(9824082));
            assertFalse(f2.contains(1081309031));
        } catch (AssertionError e) {
            System.out.println("Can be truth true");
        }
    }

    @Test
    public void clear() {
        f1.add(43);
        f1.add(44);
        f1.clear();
        assertEquals(f1.size(),0);
    }
}

