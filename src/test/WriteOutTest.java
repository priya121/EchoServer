package test;

import junit.framework.Assert;
import main.EchoConsole;
import main.ReadIn;
import main.WriteOut;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class WriteOutTest {
    OutputStream recordedOutputStream = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutputStream);
    InputStream input = new ByteArrayInputStream("Hello\nhow\nare\nyou\nquit\n".getBytes());
    EchoConsole console = new EchoConsole(input, actualOutput);

    @Test
    public void writesOutputFromAFile() throws IOException {
        String helloFile = "/Users/priyapatil/Work/hello.txt";
        WriteOut output = new WriteOut(console);
        output.writeDataOut(helloFile);
        ReadIn echoHello = getReadIn(helloFile, "quit\n");
        echoHello.readDataIn();
        Assert.assertEquals(actualOutput.toString(), "Hello\nhow\nare\nyou\nquit\n");
    }

    @Test
    public void writesGoodbyeTextFromAFile() throws IOException {
        WriteOut output = new WriteOut(console);
        output.writeDataOut("/Users/priyapatil/Work/goodbye.txt");
        assertEquals("Goodbye\n", recordedOutputStream.toString());
    }

    private ReadIn getReadIn(String file, String input) {
        InputStream helloInput = new ByteArrayInputStream(input.getBytes());
        EchoConsole console = new EchoConsole(helloInput, actualOutput);
        return new ReadIn(file, console);
    }
}

