package io;

import java.io.*;
import java.util.StringTokenizer;

public class FastReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastReader() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("C:\\Users\\konga\\Study\\Core_Java\\Java_CP\\src\\io\\input.txt"));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean hasNext() {
        try {
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                return true;
            }
            reader.mark(1);
            if (reader.read() < 0) {
                return false;
            }
            reader.reset();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
