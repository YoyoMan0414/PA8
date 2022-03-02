/*
 * NAME: Man Jiang
 * PID: A16147449
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Man Jiang
 * @since 03/01/2022
 */
public class DocumentFrequency {

    private ArrayList<HashTable> tables = new ArrayList<>(); //arraylist

    public DocumentFrequency(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String lines[] = scanner.nextLine().split(" ");
            HashTable table = new HashTable();
            for (int i = 0; i < lines.length; i++) {
                table.insert(lines[i]);
            }
            tables.add(table);
        }
        scanner.close();
    }

    public int numDocuments() {
        return tables.size();
    }

    public int query(String word) {
        int times = 0;
        for (int i = 0; i < numDocuments(); i++) {
            if (tables.get(i).lookup(word)) {
                times++;
            }
        }
        return times;
    }
}


