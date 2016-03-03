package main.client;

import java.io.OutputStream;

public interface ConnectionSocket {

    OutputStream getOutputStream();
    void close();
}
