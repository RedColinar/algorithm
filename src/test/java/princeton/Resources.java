package princeton;

import org.junit.Test;

import java.io.*;

public class Resources {

    @Test
    public void testReadResources() {
        BufferedReader reader = getSortReader();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedReader getSortReader() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("princeton/sort/sort.txt");
        assert inputStream != null;
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static Integer[] getIntArray(String[] strArray) {
        Integer[] actualInteger = new Integer[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            actualInteger[i] = Integer.valueOf(strArray[i]);
        }
        return actualInteger;
    }
}
