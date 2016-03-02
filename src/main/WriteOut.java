package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class WriteOut implements Out {

    private IOConsole io;

    public WriteOut(IOConsole io) {
        this.io = io;
    }

    public void writeDataOut(String dataToRead) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(dataToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            checkFileChange(fileReader);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String convertToString(FileReader fileReader) {
        String output = "";
        int i;
        try {
            while ((i = fileReader.read()) != -1) {
                char ch = (char) i;
                output += ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        io.showOutput(output);
        return output;
    }

    public void checkFileChange(FileReader reader) throws InterruptedException, IOException {
        final Path path = FileSystems.getDefault().getPath("/Users/priyapatil/Work");
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            updateOutput(reader, path, watchService);
        }
    }

    private void updateOutput(FileReader reader, Path path, WatchService watchService) throws IOException, InterruptedException {
        final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                final Path changed = (Path) event.context();
                if (changed.endsWith("hello.txt")) {
                    convertToString(reader);
                }
            }
            watchKey.reset();
        }
    }
}
