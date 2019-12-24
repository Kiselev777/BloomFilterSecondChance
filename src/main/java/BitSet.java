import java.util.Arrays;
import java.util.Objects;

public class BitSet {

    @Override
    public int hashCode() {
        int result = Objects.hash(countOfBit);
        result = 31 * result + Arrays.hashCode(bit);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(bit);

    }

    private int[] bit;
    // Array bit in our Filter
    private int countOfBit;
    // Count bit in Filter

    BitSet(int countOfBit) {
        if (countOfBit <= 0)
            throw new IllegalArgumentException("Incorrect size");
        this.bit = (countOfBit % 32 == 0) ? new int[countOfBit / 32] : new int[countOfBit / 32 + 1];
        this.countOfBit = countOfBit;
    }

    void add(int n) {
        if (n <= countOfBit && countOfBit >= 0) {
            int div = n / 32;
            int del = n % 32;
            if ((bit[div] & (1 << del)) == 0) bit[div] = bit[div] ^ (1 << del);
        } else {
            throw new IllegalArgumentException("");
        }
    }
    // Sign ^-XOR(побитовое или)
    // Sign <<-сдвиг битов влево
    // Sign & -bitwise(and)


    boolean contains(int n) {
        if (n >= 0 && n <= countOfBit)
            return (bit[n / 32] & (1 << (n % 32))) != 0;
        else throw new IllegalArgumentException("Error");
    }


}

