package main.client;

import java.io.OutputStream;

public interface OutputStreamCreator {
    DataOutput createOutput(OutputStream outputStream);
}
