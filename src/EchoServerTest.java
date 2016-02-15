import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EchoServerTest {

    @Test
    public void echoOnceOne() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("one", "quit")));
        echoServer.start();
        Assert.assertEquals("one\n", echoServer.write());
    }

    @Test
    public void echoTwoOnce() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("two", "quit")));
        echoServer.start();
        Assert.assertEquals("two\n", echoServer.write());
    }

    @Test
    public void echosHelloTwice() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("hello", "hello", "quit")));
        echoServer.start();
        Assert.assertEquals("hello\nhello\n", echoServer.write());
    }

    @Test
    public void echoMultipleWords() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("hello", "how", "quit")));
        echoServer.start();
        Assert.assertEquals("hello\nhow\n", echoServer.write());
    }

    @Test
    public void exitsTheProgramWhenUserEntersQuit() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("hello", "quit")));
        echoServer.start();
        Assert.assertEquals("hello\n", echoServer.write());
    }

    @Test
    public void echosMultipleWordsAndExitsWhenUserEntersQuit() {
        EchoServer echoServer = new EchoServer(getFakeIO(Arrays.asList("hello", "how", "are", "you", "quit")));
        echoServer.start();
        Assert.assertEquals("hello\nhow\nare\nyou\n", echoServer.write());
    }

    private FakeIOConsole getFakeIO(List<String> input) {
        return new FakeIOConsole(input);
    }
}