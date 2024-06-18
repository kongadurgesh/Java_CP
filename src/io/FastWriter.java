package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FastWriter {
    private BufferedWriter writer;

    public FastWriter() throws IOException {
        writer = new BufferedWriter(
                new FileWriter("C:\\\\Users\\\\konga\\\\Study\\\\Core_Java\\\\Java_CP\\\\src\\\\io\\\\output.txt"));
    }

    public void write(String str) {
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(int num) {
        try {
            writer.write(Integer.toString(num));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(long num) {
        try {
            writer.write(Long.toString(num));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(double num) {
        try {
            writer.write(Double.toString(num));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(boolean bool) {
        try {
            writer.write(Boolean.toString(bool));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String str) {
        try {
            writer.write(str);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(int num) {
        try {
            writer.write(Integer.toString(num));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(long num) {
        try {
            writer.write(Long.toString(num));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(double num) {
        try {
            writer.write(Double.toString(num));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(boolean bool) {
        try {
            writer.write(Boolean.toString(bool));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeln() {
        try {
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
