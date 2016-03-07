package main;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileWatcher implements FileWatch {
    @Override
    public Path createPath() {
        return FileSystems.getDefault().getPath("/Users/priyapatil/Work");
    }
}
