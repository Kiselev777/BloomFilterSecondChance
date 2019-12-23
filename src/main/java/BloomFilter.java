class BloomFilter {

    private int numberOfHash;
    //numOfHashFun
    private int size;
    private final double forHashGenerate = Math.random() * 32;
    private int counter;
    //Count of add
    private BitSet bit;

    BloomFilter(int size, int numberOfHash) {
        if (size <= 0)
            throw new IllegalArgumentException("Incorrect size");
        bit = new BitSet(size);
        this.numberOfHash = numberOfHash;
        this.size = size;
    }

    void clear() {
        counter = 0;
        try {
            bit.clear();
        } catch (Exception ignored){}
    }


    int size() {
        return counter;
    }

    private int hash(Object o) {
        int result = 0;
        for (int i = 0; i < o.toString().length(); i++)
            result += (o.toString().length() & (i * 16)) * forHashGenerate;
        return result % size;
    }


    boolean add(Object o) {
        counter++;
        for (int i = 0; i < numberOfHash; i++) {
            bit.add(hash(o));
        }
        return false;
    }

    boolean contains(Object o) {
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
