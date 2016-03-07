import main.EchoConsole;
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
        WriteOut output = new WriteOut(console);
        output.readFromFile("/Users/priyapatil/Work/hello.txt");
        assertEquals("Hello\nhow\nare\nyou\n", recordedOutputStream.toString());
    }

    @Test
    public void writesGoodbyeTextFromAFile() throws IOException {
        WriteOut output = new WriteOut(console);
        output.readFromFile("/Users/priyapatil/Work/goodbye.txt");
        assertEquals("Goodbye\n", recordedOutputStream.toString());
    }
}

