import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HashTableTest {

    //test constructors
    HashTable test1 = new HashTable();
    HashTable con1 = new HashTable();
    HashTable con2 = new HashTable();
    HashTable test2 = new HashTable(20);
    HashTable test3 = new HashTable(50);
    HashTable test4 = new HashTable(100);

    @org.junit.Test
    public void allTests() {
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
        String[] expected = new String[]{"DSC190", null, null, null, null, null, "FALL2022", null, null, null,
                "DSC80", "DSC30", null, null, null};
        assertEquals(Arrays.toString(expected), test1.toString());
        test1.delete("DSC30");
        test1.insert("abc");
        test1.insert("UCSD");
        test1.insert("HDSI");
        test1.insert("Grade");
        test1.insert("Midterm");
        test1.insert("30%");
        test1.delete("DSC80");
        assertEquals(8, test1.size());
        assertEquals(15, test1.capacity());
        test1.insert("rehash ready");
        test1.insert("now ready");
        assertEquals(10, test1.size());
        assertEquals(30, test1.capacity());
        assertEquals("Before rehash # 1: load factor 0.60, 7 collision(s).\n", test1.getStatsLog());
        expected = new String[]{"DSC190", "rehash ready", "HDSI", null, null, null, "FALL2022", "abc", null, null, "now ready",
                null, null, null, null, null, null, null, "UCSD", null, null, "Grade", null, null, "Midterm", null,
                null, null, null, "30%"};
        assertEquals(Arrays.toString(expected), test1.toString());
        test1.insert("Calculus");
        test1.insert("Math");
        test1.insert("English");
        test1.insert("Literature");
        test1.insert("Econ"); //0.5
        test1.insert("Public Health"); //0.53
        test1.insert("Linear Algebra");
        assertEquals(30, test1.capacity());
        test1.insert("Bio");
        assertEquals(60, test1.capacity());
        assertEquals("Before rehash # 1: load factor 0.60, 7 collision(s).\n" +
                "Before rehash # 2: load factor 0.57, 9 collision(s).\n", test1.getStatsLog());

        test2.insert("Calculus");
        test2.insert("Math");
        test2.insert("English");
        test2.insert("Literature");
        test2.insert("Econ");
        test2.insert("Public Health");
        test2.insert("Linear Algebra");
        test2.insert("Bio");
        test2.insert("Art");
        test2.insert("CS");
        test2.insert("Data Science");
        assertEquals(11, test2.size());
        assertEquals(20, test2.capacity());
        assertEquals(true, test2.lookup("Calculus"));
        assertEquals(true, test2.lookup("CS"));
        expected = new String[]{"CS", "Calculus", null, "Public Health", null, "Data Science", null, null, "Art",
                null, null, "English", null, null, null, "Linear Algebra", "Math", "Literature", "Econ", "Bio"};
        assertEquals(Arrays.toString(expected), test2.toString());
        test2.insert("Biostats"); //0.55 LF
        assertEquals("", test2.getStatsLog());
        test2.insert("Environment"); //time to rehash
        assertEquals("Before rehash # 1: load factor 0.60, 6 collision(s).\n", test2.getStatsLog());
        assertEquals(true, test2.delete("Biostats"));
        assertEquals(true, test2.delete("CS"));
        assertEquals(11, test2.size());
        assertEquals(40, test2.capacity());
        test2.insert("Bio");
        assertEquals(11, test2.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCon(){
        HashTable test = new HashTable(4);
    }

    @Test(expected = NullPointerException.class)
    public void testInsert(){
        test1.insert(null);
    }

    @Test(expected = NullPointerException.class)
    public void testDelete(){
        test2.insert("Hi");
        test2.delete(null);
    }

    @Test(expected = NullPointerException.class)
    public void testDelete2(){
        test2.delete(null);
    }

    @Test(expected = NullPointerException.class)
    public void testLook(){
        test2.insert("Hi");
        test2.lookup(null);
    }

    @Test(expected = NullPointerException.class)
    public void testLook2(){
        test2.lookup(null);
    }
}
