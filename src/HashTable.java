/*
 * Name: Man Jiang
 * PID: A16147449
 */

import java.util.Arrays;

/**
 * TODO
 * 
 * @author Man Jiang
 * @since 02/28/2022
 */
public class HashTable implements IHashTable {

    /* the bridge for lazy deletion */
    private static final String BRIDGE = new String("[BRIDGE]".toCharArray());

    /* instance variables */
    private int size; // number of elements stored
    private String[] table; // data table

    public HashTable() {
        this(15);
    }

    public HashTable(int capacity) {
        if (capacity < 5) {
            throw new IllegalArgumentException();
        }
        size = 0;
        table = new String[capacity];
    }

    @Override
    public boolean insert(String value) {

        return false;
    }

    @Override
    public boolean delete(String value) {
        /* TODO */
        return false;
    }

    @Override
    public boolean lookup(String value) {
        /* TODO */
        return false;
    }

    @Override
    public int size() {
        /* TODO */
        return -1;
    }

    @Override
    public int capacity() {
        /* TODO */
        return -1;
    }

    public String getStatsLog() {
        /* TODO */
        return null;
    }

    private void rehash() {
        /* TODO */
    }

    private int hashString(String value) {
        /* TODO */
        return -1;
    }

    /**
     * Returns the string representation of the hash table.
     * This method internally uses the string representation of the table array.
     * DO NOT MODIFY. You can use it to test your code.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return Arrays.toString(table);
    }
}
