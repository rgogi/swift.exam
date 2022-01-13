import java.util.*;

    class Element<Key, Value> {
        Key key;
        Value value;
        final int hashCode;
        Element<Key, Value> nextElem;

        public Element(Key key, Value value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    class HashMap<Key, Value> {
        private ArrayList<Element<Key, Value> > buckets;
        private int numBuckets;
        private int numElems;

        public HashMap() {
            buckets = new ArrayList<>();
            numBuckets = 100;
            numElems = 0;

            for(int i = 0; i < numBuckets; i++) buckets.add(null);
        }

        private final int hashCode(Key key) {
            return Objects.hashCode(key);
        }

        public int size() {
            return numElems;
        }

        public void remove(Key key) {
            int code = hashCode(key);
            int idx = code % numBuckets;

            Element<Key, Value> start = buckets.get(idx);
            Element<Key, Value> prevElem = null;
            while(start != null) {
                if(start.key.equals(key)) break;

                prevElem = start;
                start = start.nextElem;
            }

            if(start == null) return;
            if(prevElem != null) prevElem.nextElem = start.nextElem;
            else buckets.set(idx, start.nextElem);
            numElems--;
        }

        public Value get(Key key) {
            int code = hashCode(key);
            int idx = code % numBuckets;

            Element<Key, Value> start = buckets.get(idx);
            while(start != null) {
                if(start.key.equals(key)) return start.value;

                start = start.nextElem;
            }
            return null;
        }

        private void increaseSize() {
            ArrayList<Element<Key, Value> > tmp = buckets;
            buckets = new ArrayList<>();
            numBuckets *= 2;
            numElems = 0;
            for(int i = 0; i < numBuckets; i++) buckets.add(null);

            for(Element<Key, Value> start : tmp) {
                while(start != null) {
                    add(start.key, start.value);
                    start = start.nextElem;
                }
            }
        }

        public void add(Key key, Value value) {
            int code = hashCode(key);
            int idx = code % numBuckets;

            Element<Key, Value> start = buckets.get(idx);
            while(start != null) {
                if(start.key.equals(key)) {
                    start.value = value;
                    return;
                }

                start = start.nextElem;
            }

            start = buckets.get(idx);
            Element<Key, Value> newElem = new Element<Key, Value>(key, value, code);
            newElem.nextElem = start;
            buckets.set(idx, newElem);
            numElems++;

            if((double) numElems / numBuckets >= 0.5) increaseSize();
        }

        public static void main(String[] args) {
            HashMap<Integer, String> myMap = new HashMap<>();
            myMap.add(1, "first");
            myMap.add(2, "second");
            myMap.add(3, "third");
            myMap.add(1, "first1");
            myMap.add(5, "fifth");

            System.out.println(myMap.get(1));
            System.out.println(myMap.get(3));

            System.out.println(myMap.size());
            myMap.remove(1);
            myMap.remove(1);
            System.out.println(myMap.size());
            System.out.println(myMap.get(5));
        }


    }


