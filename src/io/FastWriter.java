package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FastWriter {

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16; // 64KB buffer
    private BufferedOutputStream bos;
    private byte[] buffer;
    private int pointer;

    public FastWriter() {
        try {
            bos = new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\konga\\Study\\Core_Java\\Java_CP\\src\\io\\output.txt"),
                    DEFAULT_BUFFER_SIZE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        pointer = 0;
    }

    private void ensureCapacity(int length) throws IOException {
        if (pointer + length > buffer.length) {
            flush();
        }
    }

    public void write(String s) throws IOException {
        byte[] data = s.getBytes(StandardCharsets.UTF_8);
        ensureCapacity(data.length);
        System.arraycopy(data, 0, buffer, pointer, data.length);
        pointer += data.length;
    }

    public void write(int i) throws IOException {
        write(Integer.toString(i));
    }

    public void write(long l) throws IOException {
        write(Long.toString(l));
    }

    public void write(double d) throws IOException {
        write(Double.toString(d));
    }

    public void writeList(@SuppressWarnings("rawtypes") List list) throws IOException {
        for (Object object : list) {
            writeLine(object.toString());
        }
    }

    public void write(char c) throws IOException {
        ensureCapacity(1);
        buffer[pointer++] = (byte) c;
    }

    public void writeLine(String s) throws IOException {
        write(s);
        write('\n');
    }

    public void writeLine(int i) throws IOException {
        write(i);
        write('\n');
    }

    public void writeLine(long l) throws IOException {
        write(l);
        write('\n');
    }

    public void writeLine(double d) throws IOException {
        write(d);
        write('\n');
    }

    public void writeLine(char c) throws IOException {
        write(c);
        write('\n');
    }

    public void flush() throws IOException {
        if (pointer > 0) {
            bos.write(buffer, 0, pointer);
            pointer = 0;
        }
        bos.flush();
    }

    public void close() throws IOException {
        flush();
        bos.close();
    }

}
