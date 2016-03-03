package test;

import main.IOConsole;
import main.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientTest {
    IOConsole fakeInput = new FakeIO(Arrays.asList(""));
    Client client = new Client(fakeInput);
    OutputStreamCreator fakeDataOutputCreator = new FakeDataOutputCreator();
    FakeSocketSpy fakeSocket = new FakeSocketSpy();

    @Test
    public void socketProducesOutputStream() throws IOException {
        FakeSocketSpy fakeSocket = new FakeSocketSpy();
        client.writeDataOut(fakeSocket, fakeDataOutputCreator);
        assertTrue(fakeSocket.hasGotOutputStream());
    }

    @Test
    public void closesOutputStream() throws IOException {
        client.writeDataOut(fakeSocket, fakeDataOutputCreator);
        assertTrue(fakeSocket.hasClosed());
    }

    @Test
    public void writesDataOut() throws IOException {
        client.writeDataOut(fakeSocket, fakeDataOutputCreator);
        FakeDataOutput fakeDataOutput = (FakeDataOutput) fakeDataOutputCreator.createOutput(fakeSocket.getOutputStream());
        fakeDataOutput.writeBytes("Hi how");
        assertEquals(fakeDataOutput.getWrittenBytes(), "Hi how");
    }
}

class FakeIO implements IOConsole {
    private LinkedList<String> words;

    public FakeIO(List<String> words) {
        this.words = new LinkedList<>(words);
    }

    @Override
    public String getInput() {
        return words.pop();
    }

    @Override
    public String showOutput(String message) {
        return message;
    }
}