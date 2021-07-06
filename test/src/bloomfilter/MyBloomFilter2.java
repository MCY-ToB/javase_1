package bloomfilter;

import java.util.BitSet;

public class MyBloomFilter2 {
    private static final int DEFAULT_SIZE = 2 << 24;
    private  final BitSet bitSet = new BitSet(DEFAULT_SIZE);
    private final static int[] SEEDS = new int[]{1,5,12,23,34,45};
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter2() {
        for (int i = 0; i < func.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    public void add(Object value){
        for (SimpleHash simpleHash : func) {
            bitSet.set(simpleHash.hash(value),true);
        }
    }

    public boolean contains(Object value){
        for (SimpleHash simpleHash : func) {
            if (bitSet.get(simpleHash.hash(value)) == false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }

    public static class SimpleHash{
        int cap;
        int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value){
            int h;
            return value == null ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode())^(h >>> 16)));
        }
    }
}
