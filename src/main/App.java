package main;

import java.io.IOException;
import java.nio.file.Path;

public class App {

    public static void main(String[] args) throws IOException {
       String filePath = "/Users/priyapatil/Work/hello.txt";
        Path path = new FileWatcher().createPath();

        IOConsole console = new EchoConsole(System.in, System.out);
        ReadIn inputReader = new ReadIn(filePath, console);
        WriteOut writeFileContents = new WriteOut(console);

        if (args[0].equals("in")) try {
            inputReader.inputToFile();
        } catch (IOException e) {
            console.showOutput("Invalid input");
            e.printStackTrace();
        }
        else if (args[0].equals("out")) writeFileContents.readFromFile(filePath, path);
    }
}
