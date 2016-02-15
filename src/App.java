public class App {

    public static void main(String[] args) {
        IOConsole userInput = new EchoConsole(System.in, System.out);
        EchoServer server = new EchoServer(userInput);
        server.start();
    }
}
