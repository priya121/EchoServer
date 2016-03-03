package main.client;

import java.io.OutputStream;

public class FakeDataOutputCreator implements OutputStreamCreator {

    @Override
    public FakeDataOutput createOutput(OutputStream outputStream) {
        return new FakeDataOutput();
    }
}
