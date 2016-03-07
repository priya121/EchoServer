import main.EchoConsole;
import main.ReadIn;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class ReadInTest {
    String helloFile = "/Users/priyapatil/Work/hello.txt";
    String goodbyeFile = "/Users/priyapatil/Work/goodbye.txt";
    OutputStream recordedOutputStream = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutputStream);

    @Test
    public void readsHelloHowAreYouToFile() throws IOException {
        ReadIn echoHello = getReadIn(helloFile, "Hello\nhow\nare\nyou\nquit\n");
        echoHello.inputToFile();
        Assert.assertTrue(read("/Users/priyapatil/Work/hello.txt", 100).contains("Hello\nhow\nare\nyou"));
    }

    @Test
    public void readsGoodbyeHowAreYouToFile() throws IOException {
        ReadIn echoGoodbye = getReadIn(goodbyeFile, "Goodbye\nquit\n");
        echoGoodbye.inputToFile();
        Assert.assertTrue(read("/Users/priyapatil/Work/Goodbye.txt", 100).contains("Goodbye"));
    }

    private String read(String inputFilePath, int amountOfBytes) throws IOException {
        File inputFile = new File(inputFilePath);
        InputStream input = new FileInputStream(inputFile);
        byte[] buffer = new byte[amountOfBytes];
        input.read(buffer);
        return new String(buffer);
    }

    private ReadIn getReadIn(String file, String input) {
        InputStream helloInput = new ByteArrayInputStream(input.getBytes());
        EchoConsole console = new EchoConsole(helloInput, actualOutput);
        return new ReadIn(file, console);
    }

}
