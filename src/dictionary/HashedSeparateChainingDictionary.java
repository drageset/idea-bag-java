package dictionary;

import primes.PrimeFinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This hash table uses separate chaining and implements the Dictionary/Map ADT
 * @param <K> is the type of the keys
 * @param <V> is the type of the values
 * @author drageset
 */
public class HashedSeparateChainingDictionary<K,V> implements DictionaryInterface<K,V> {

    List<List<TableEntry<K,V>>> hashTable;
    private static final int DEFAULTSIZE = 97; //97 is a prime, so it's a good default size for hash functions using size
    private static final double LOADFACTOR = 0.5;
    int size;
    int currentNumOfEntries;


    public HashedSeparateChainingDictionary() {
        this(DEFAULTSIZE);
    }

    public HashedSeparateChainingDictionary(int size) {
        size = PrimeFinder.nextPrime(size); //reduce collisions by using a prime as size, since hash function is based on size
        this.size = size;
        hashTable = newHashTable(this.size);
        currentNumOfEntries = 0;
    }

    /**
     * Creates a new hash table with a size equal to the first prime larger than or equal to the int given as parameter
     * @param size is the number from which we wil search upwards for the first prime
     * @return a new hash table of size larger than or equal to the parameter
     */
    private List<List<TableEntry<K,V>>> newHashTable(int size) {
        this.size = PrimeFinder.nextPrime(size); //reduce collisions by using a prime as size, since hash function is based on size
        List<List<TableEntry<K,V>>> newHashTable = new ArrayList<>(this.size);
        //Create the buckets
        for (int i = 0; i < this.size ; i++) {
            newHashTable.add(i, new LinkedList<>());
        }
        return newHashTable;
    }

    /**
     * Retrieves the hash index of a key.
     * Can be used to assign an index (a bucket) to a new item, or find the index (bucket) of an existing item
     * @param key of the item you wish to find or place
     * @return the index in the hashTable of the bucket
     */
    private int hashFunction(K key){
        int index = key.hashCode() % size;
        if(index < 0) {
            index = index + size;
        }
        return index;
    }

    /**
     * Resize the hash table by a factor specified
     * @param factor of resize
     */
    private void resize(int factor) {
        List<List<TableEntry<K,V>>> oldHashTable = hashTable;
        hashTable = newHashTable(size*factor);
        size = hashTable.size();
        currentNumOfEntries = 0;
        //grab all values from the old buckets and add them again
        for (List<TableEntry<K, V>> bucket : oldHashTable) {
            for (TableEntry<K, V> tableEntry : bucket) {
                add(tableEntry.key, tableEntry.value);
            }
        }
    }

    @Override
    public V add(K key, V value) {
        int indexOfBucket = hashFunction(key);
        TableEntry<K,V> newEntry = new TableEntry<>(key, value);
        V oldEntry = remove(key); //resolves duplicate entries by deleting the old value if there is one
        hashTable.get(indexOfBucket).add(newEntry);
        if (oldEntry == null){
            currentNumOfEntries++;
        }
        if (currentNumOfEntries > (size * LOADFACTOR)) {
            resize(2);
        }
        return oldEntry;
    }

    @Override
    public V remove(K key) {
        int indexOfBucket = hashFunction(key);
        List<TableEntry<K,V>> bucket = hashTable.get(indexOfBucket);
        for (TableEntry<K,V> tableEntry : bucket) {
            if (tableEntry.getKey().equals(key)){
                bucket.remove(tableEntry);
                return tableEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public V getValue(K key) {
        int indexOfBucket = hashFunction(key);
        List<TableEntry<K,V>> bucket = hashTable.get(indexOfBucket);
        for (TableEntry<K,V> tableEntry : bucket) {
            if (tableEntry.getKey().equals(key)){
                return tableEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        int indexOfBucket = hashFunction(key);
        List<TableEntry<K,V>> bucket = hashTable.get(indexOfBucket);
        for (TableEntry<K,V> tableEntry : bucket) {
            if (tableEntry.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        List<K> keyList = new ArrayList<>(currentNumOfEntries);
        for (List<TableEntry<K, V>> bucket : hashTable) {
            for (TableEntry<K, V> tableEntry : bucket) {
                keyList.add(tableEntry.key);
            }
        }
        return keyList.iterator();
    }

    @Override
    public Iterator<V> getValueIterator() {
        List<V> valueList = new ArrayList<>(currentNumOfEntries);
        for (List<TableEntry<K, V>> bucket : hashTable) {
            for (TableEntry<K, V> tableEntry : bucket) {
                valueList.add(tableEntry.value);
            }
        }
        return valueList.iterator();
    }

    @Override
    public boolean isEmpty() {
        for (List<TableEntry<K, V>> bucket : hashTable) {
            if (!bucket.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public int getSize() {
        return currentNumOfEntries;
    }

    @Override
    public void clear() {
        hashTable = newHashTable(DEFAULTSIZE);
        size = hashTable.size();
        currentNumOfEntries = 0;
    }

    private class TableEntry<K,V>{
        private K key;
        V value;
        TableEntry(K key, V value){
            this.setKey(key);
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }

    }

}



