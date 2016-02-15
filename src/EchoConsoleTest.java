import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class EchoConsoleTest {
    OutputStream recordedOutputStream = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutputStream);

    @Test
    public void testsEchoConsoleWithSingleInput() {
        InputStream input = new ByteArrayInputStream("Hello\nquit".getBytes());
        EchoConsole console = new EchoConsole(input, actualOutput);
        EchoServer echo = new EchoServer(console);
        echo.start();
        Assert.assertEquals("Type in text to echo\nEnter quit to exit the program: \n\n" +
                "Hello\n\n" +
                "Exiting the program\n", recordedOutputStream.toString());
    }
}
