import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Set;

class BloomFilter<T extends Comparable<T>> extends AbstractCollection<T> implements Set<T> {

    private int numberOfHash;
    //numOfHashFun
    private int size;
    private final double forHashGenerate = Math.random() * 32;
    private int counter;
    //Count of add
    private BitSet bit;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        bit=new BitSet(getSize());
        counter=0;
    }

    BloomFilter(int size, int numberOfHash) {
        if (numberOfHash==0)
            throw new IllegalArgumentException("Incorrect hash");
        bit = new BitSet(size);
        this.numberOfHash = numberOfHash;
        this.size = size;
    }


    private int getSize() {
        return size;
    }


    private int hash(T o) {
        int result = 0;
        for (int i = 0; i < o.toString().length(); i++)
            result += (o.toString().length() & (i * 16)) * forHashGenerate;
        return result % size;
    }


    public boolean add(T o) {
        counter++;
        for (int i = 0; i < numberOfHash; i++) {
            bit.add(hash(o));
        }
        return true;
    }


    boolean contains(T o) {
        for (int i = 0; i < numberOfHash; i++) {
            if (!bit.contains(hash(o)))
                return false;
        }
        return true;
    }

}
//Links with hash code algorithms and information about BloomFilter,what i am used in this project
//http://blog.skahin.ru/2016/12/oracle-bloom-filter.html
//https://learnc.info/adt/bloom_filter.html
//https://xakep.ru/2016/08/19/understanding-bloom-filter/
//https://habr.com/ru/post/112069/
