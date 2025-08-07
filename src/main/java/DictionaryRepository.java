import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DictionaryRepository {
    private  final Path dictionaryPath;
    private final List<String> masterDictionary = new ArrayList<>();

    public DictionaryRepository(Path dictionaryPath) {
        Objects.requireNonNull(dictionaryPath, "dictionaryPath must not be null");
        if (!Files.isReadable(dictionaryPath)) {
            throw new IllegalArgumentException("Cannot read dictionary file " + dictionaryPath);
        }
        this.dictionaryPath = dictionaryPath;
    }


    public List<String> loadMasterDictionary() throws IOException {
        masterDictionary.clear();
        masterDictionary.addAll(Files.readAllLines(dictionaryPath));
        return List.copyOf(masterDictionary);
    }

}
