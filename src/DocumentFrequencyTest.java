import java.io.IOException;

import static org.junit.Assert.*;

public class DocumentFrequencyTest {

    @org.junit.Test
    public void test() {
        try {
            DocumentFrequency forTest = new DocumentFrequency("./src/test.txt");
            assertEquals(5, forTest.numDocuments());
            assertEquals(5, forTest.query("quick"));
            assertEquals(2, forTest.query("dog"));
            assertEquals(0, forTest.query("dsc30"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}