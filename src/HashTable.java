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

    //2.2 added instance variables
    private int rehash;
    private int collision;
    private double loadF;
    private String log;

    public HashTable() {
        this(15);
    }

    public HashTable(int capacity) {
        if (capacity < 5) {
            throw new IllegalArgumentException();
        }
        size = 0;
        table = new String[capacity];
        //initialize added
        rehash = 0;
        collision = 0;
        loadF = 0.00;
        log = "";
    }

    @Override
    public boolean insert(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (lookup(value)) {
            return false;
        } else {
            loadF = (double)size/table.length;
            if (loadF > 0.55) {
                rehash();
            }
            int index = hashString(value);
            int probed = 0;
            while (probed < table.length) {
                if (table[index] == null || table[index] == BRIDGE) {
                    table[index] = value;
                    size++;
                    return true;
                }
                index = (index + 1) % table.length;
                probed++;
                collision++;
            }
            return false;
        }
    }

    @Override
    public boolean delete(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (!lookup(value)) {
            return false;
        } else {
            int index = hashString(value);
            int probed = 0;
            while (table[index] != null && probed < table.length) {
                if (table[index].equals(value)) {
                    table[index] = BRIDGE;
                    size--;
                    return true;
                }
                index = (index + 1) % table.length;
                probed++;
            }
        }
        return false;
    }

    @Override
    public boolean lookup(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int index = hashString(value);
        int probed = 0;
        while (table[index] != null && probed < table.length) {
            if (table[index].equals(value)) {
                return true;
            }
            index = (index + 1) % table.length;
            probed++;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return table.length;
    }

    public String getStatsLog() {
        return log;
    }

    private void rehash() {
        int len = table.length;
        String[] temp = table;
        String[] re = new String[2 * len];

        rehash++;
        log += String.format("Before rehash # %d: load factor %.2f, %d collision(s).\n", rehash, loadF, collision);
        collision = 0;

        size = 0;
        table = re;
        for (int i = 0; i < len; i++) {
            if (temp[i] != null && temp[i] != BRIDGE) {
                insert(temp[i]);
            }
        }
    }

    private int hashString(String value) {
        int hashValue = 0;
        for (int i = 0; i < value.length(); i++) {
            int leftShiftedValue = hashValue << 5;
            int rightShiftedValue = hashValue >>> 27;
            hashValue = (leftShiftedValue | rightShiftedValue) ^ value.charAt(i);
        }
        return Math.abs(hashValue % table.length);
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
