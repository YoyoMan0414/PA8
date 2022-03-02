/*
 * NAME: Man Jiang
 * PID: A16147449
 */

/**
 * TODO
 *
 * @author Man Jiang
 * @since 03/01/2022
 */
public class BloomFilterJunior {

    /* Constants */
    private static final int MIN_INIT_CAPACITY = 50;
    private static final int BASE256_LEFT_SHIFT = 8;
    private static final int HORNERS_BASE = 27;

    /* Instance variables */
    private boolean[] table;

    public BloomFilterJunior(int capacity) {
        if (capacity < MIN_INIT_CAPACITY) {
            throw new IllegalArgumentException();
        }
        table = new boolean[capacity];
    }

    public void insert(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int key1 = hashBase256(value);
        int key2 = hashCRC(value);
        int key3 = hashHorners(value);

        table[key1] = true;
        table[key2] = true;
        table[key3] = true;
    }

    public boolean lookup(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int key1 = hashBase256(value);
        int key2 = hashCRC(value);
        int key3 = hashHorners(value);

        if (table[key1] == true && table[key2] == true && table[key3] == true) {
            return true;
        }
        return false;
    }

    /**
     * Base-256 hash function.
     *
     * @param value string to hash
     * @return hash value
     */
    private int hashBase256(String value) {
        int hash = 0;
        for (char c : value.toCharArray()) {
            hash = ((hash << BASE256_LEFT_SHIFT) + c) % table.length;
        }
        return Math.abs(hash % table.length);
    }

    /**
     * Simplified CRC hash function.
     *
     * @param value string to hash
     * @return hash value
     */
    private int hashCRC(String value) {
        int hashValue = 0;
        for (int i = 0; i < value.length(); i++) {
            int leftShiftedValue = hashValue << 5;
            int rightShiftedValue = hashValue >>> HORNERS_BASE;
            hashValue = (leftShiftedValue | rightShiftedValue) ^ value.charAt(i);
        }
        return Math.abs(hashValue % table.length);
    }

    /**
     * Horner's hash function.
     *
     * @param value string to hash
     * @return hash value
     */
    private int hashHorners(String value) {
        int hash = 0;
        for (char c : value.toCharArray()) {
            hash = (hash * HORNERS_BASE + c) % table.length;
        }
        return Math.abs(hash % table.length);
    }
}
