package dictionary;


import primes.PrimeFinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashedSeparateChainingDictionary<K,V> implements DictionaryInterface<K,V> {

    List<List<TableEntry<K,V>>> hashTable;
    private static final int DEFAULTSIZE = 97; //97 is a prime, so it's a good default size for hash functions using size
    private static final double MAXLOAD = 0.5;
    int size;
    int currentNumOfEntries;


    public HashedSeparateChainingDictionary() {
        this(DEFAULTSIZE);
    }

    public HashedSeparateChainingDictionary(int size) {
        this.size = PrimeFinder.nextPrime(size); //reduce collisions by using a prime as size, since hash function is based on size
        hashTable = new ArrayList<>(this.size);
        currentNumOfEntries = 0;
        //Create the buckets
        for (int i = 0; i < this.size ; i++) {
            hashTable.add(i, new LinkedList<>());
        }
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

    @Override
    public V add(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V getValue(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(K key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<V> getValueIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

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



