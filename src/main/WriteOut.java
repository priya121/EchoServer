package main;

import java.io.*;

public class WriteOut {

    private IOConsole io;

    public WriteOut(IOConsole io) {
        this.io = io;
    }

    public void readFromFile(String fileToRead) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String output = "";

        output = convertsToString(fileReader, output);
        io.showOutput(output);
    }

    private String convertsToString(FileReader fileReader, String output) {
        int i = 0;
        try {
            while ((i = fileReader.read()) != -1) {
                char ch = (char) i;
                output += ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
