package main;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        String IPAddress = "localhost";
        int port = 5000;
        IOConsole console = new EchoConsole(System.in, System.out);
        Server server = new Server(port, console);
        Client client = new Client(IPAddress, port, console);


        if (args[0].equals("in")) try {
            client.writeDataOut("");
        } catch (IOException e) {
            console.showOutput("Invalid input");
            e.printStackTrace();
        }
        else if (args[0].equals("out"))
            server.readDataIn();
    }
}
