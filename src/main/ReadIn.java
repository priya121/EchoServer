package main;

import java.io.*;

public class ReadIn implements In {
    private final IOConsole io;
    private final String inputFilePath;

    public ReadIn(String inputFilePath, IOConsole io) {
        this.io = io;
        this.inputFilePath = inputFilePath;
    }

    public void readDataIn() throws IOException {
        io.showOutput("Type in text to write to file:\nType quit to exit\n");
        String currentInput = io.getInput();
        while (notQuit(currentInput)) {
            dataToFile(currentInput, inputFilePath, currentInput.length());
            currentInput += "\n" + io.getInput();
        }
        io.showOutput("Exiting the program");
    }

    public void dataToFile(String input, String file, int bytes) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new FileOutputStream(new File(file));
        byte[] buffer = new byte[bytes];

        transferBytes(inputStream, outputStream, buffer);
        outputStream.close();
    }

    private void transferBytes(InputStream in, OutputStream out, byte[] buffer) throws IOException {
        while ((in.read(buffer)) != -1) {
            out.write(buffer);
        }
    }

    private boolean notQuit(String nextInput) {
        return !nextInput.contains("quit");
    }
}
