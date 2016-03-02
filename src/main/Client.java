package main;

import java.io.*;
import java.net.Socket;

public class Client implements Out{

    private final String IPAddress;
    private final int port;
    private final IOConsole io;

    public Client(String IPAddress, int port, IOConsole io) {
        this.port = port;
        this.IPAddress = IPAddress;
        this.io = io;
    }

    public void writeDataOut(String dataToRead) throws IOException {
        BufferedReader userInput = writeInputToBufferedReader();
        Socket connectionSocket = new Socket(IPAddress, port);
        writeToServer(userInput, connectionSocket);
        connectionSocket.close();
    }

    private void writeToServer(BufferedReader userInput, Socket connectionSocket) throws IOException {
        String word;
        DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
        word = userInput.readLine();
        outToServer.writeBytes(word + '\n');
    }

    private BufferedReader writeInputToBufferedReader() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(io.getInput().getBytes());
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
