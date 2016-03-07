import main.EchoConsole;
import main.FileWatcher;
import main.WriteOut;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;

import static junit.framework.TestCase.assertEquals;

public class WriteOutTest {
    Path path = new FileWatcher().createPath();
    OutputStream recordedOutputStream = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutputStream);
    InputStream input = new ByteArrayInputStream("Hello\nhow\nare\nyou\nquit\n".getBytes());
    EchoConsole console = new EchoConsole(input, actualOutput);

    @Test
    public void writesOutputFromAFile() throws IOException {
        WriteOut output = new WriteOut(console);
        output.readFromFile("/Users/priyapatil/Work/hello.txt", path);
        assertEquals("Hello\nhow\nare\nyou\n", recordedOutputStream.toString());
    }

    @Test
    public void writesGoodbyeTextFromAFile() throws IOException {
        WriteOut output = new WriteOut(console);
        output.readFromFile("/Users/priyapatil/Work/goodbye.txt", path);
        assertEquals("Goodbye\n", recordedOutputStream.toString());
    }
}

