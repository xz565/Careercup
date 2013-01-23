package chp01_ArraysAndStrings;

public class MyHashTable {
    public final static int TABLE_SIZE = 128;
   
    HashEntry[] table;

    public MyHashTable(){
        table = new HashEntry[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public void put(int key, int value) {
        int hash = key % TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        table[hash] = new HashEntry(key, value);
    }

    public int get(int key, int value) {
        int hash = key % TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        if (table[hash] == null) return -1;
        else return table[hash].getValue();
    }
}

class HashEntry {
    private int key;
    private int value;

    public HashEntry(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
