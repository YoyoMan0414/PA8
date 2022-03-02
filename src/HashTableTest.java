import static org.junit.Assert.*;

public class HashTableTest {

    HashTable test1 = new HashTable();
    HashTable test2 = new HashTable(20);
    HashTable test3 = new HashTable(50);

    @org.junit.Test
    public void insert() {
        test1.insert("DSC30");
        test1.insert("DSC80");
        test1.insert("DSC190");
        test1.insert("FALL2022");
        assertEquals(false, test1.insert("DSC30"));
        assertEquals(4, test1.size());
        assertEquals(15, test1.capacity());
        assertEquals(false, test1.delete("fall2022"));
        assertEquals(true, test1.lookup("FALL2022"));
        assertEquals(false, test1.lookup("dsc80"));
        assertEquals("", test1.getStatsLog());
        assertEquals("", test1.toString());
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void lookup() {
    }

    @org.junit.Test
    public void size() {
    }

    @org.junit.Test
    public void capacity() {
    }

    @org.junit.Test
    public void getStatsLog() {
    }

    @org.junit.Test
    public void testToString() {
    }
}