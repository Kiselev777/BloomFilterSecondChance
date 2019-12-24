import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterTest {
    private BloomFilter<Integer> f1 = new BloomFilter<>(99, 43);
    private BloomFilter<String> f = new BloomFilter<>(789, 4);

    @Test
    public void add() {
        f1.add(777);
        f1.add(-778798);
        f1.add(-1);
        assertTrue(f1.contains(777));
        assertTrue(f1.contains(-778798));
        assertTrue(f1.contains(-1));
        f.add("a");
        f.add("qwerty");
        f.add("77777");
        assertTrue(f.contains("a"));
        assertTrue(f.contains("qwerty"));
        assertTrue(f.contains("77777"));
        try {
            BloomFilter<Integer> f3= new BloomFilter<>(0, 10000);
            f3.add(66);
            f3.add(77);
        } catch (IllegalArgumentException e) {
            System.out.println("Please,not zero");
        }

        try {
            BloomFilter<Double> f4 = new BloomFilter<>(-1, 10000);
            f4.add(11.1);
            f4.add(1.1);
        } catch (IllegalArgumentException e) {
            System.out.println("Please,vvedite polozhitelnoe 4islo");
        }
    }

    @Test
    public void contains() {
        assertFalse(f.contains("yyy"));
        for (int i = 0; i < 20; i++) {
            f1.add(i);
        }
        assertTrue(f1.contains(7));
        assertTrue(f1.contains(8));
        assertTrue(f1.contains(9));
        assertTrue(f1.contains(3));
        BloomFilter<Integer> f2 = new BloomFilter<Integer>(44, 42);
        f2.add(983982);
        f2.add(8787483);
        assertTrue(f2.contains(83982));
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
        f1.add(90);
        f1.add(1);
        f1.add(0);
        f1.add(56);
        assertTrue(f1.contains(90));
        assertTrue(f1.contains(1));
        assertTrue(f1.contains(0));
        assertTrue(f1.contains(56));
        assertEquals(f1.size(), 4);
        f1.clear();
        assertFalse(f1.contains(90));
        assertFalse(f1.contains(1));
        assertFalse(f1.contains(0));
        assertFalse(f1.contains(56));
        assertEquals(f1.size(), 0);
        f1.add(9999);
        assertEquals(f1.size(), 1);
    }
}

