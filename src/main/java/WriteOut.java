import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class WriteOut {

    private IOConsole io;

    public WriteOut(IOConsole io) {
        this.io = io;
    }

    public void readFromFile(String fileToRead, Path path) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fileChanged(fileReader, path);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String convertsToString(FileReader fileReader) {
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

    public void fileChanged(FileReader reader, Path path) throws InterruptedException, IOException {
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            updateOutput(reader, path, watchService);
        }
    }

    private void updateOutput(FileReader reader, Path path, WatchService watchService) throws IOException, InterruptedException {
        final WatchKey watchKey = path.register(watchService, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY});
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                final Path changed = (Path) event.context();
                if (changed.endsWith("hello.txt")) {
                    convertsToString(reader);
                }
            }
            watchKey.reset();
        }
    }
}
