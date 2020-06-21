package com.imdb.importer;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class ImportHelper {

    public static Path getPath(String filename) {

        File file = new File(
                Objects.requireNonNull(NameBasicsImporter.class.getClassLoader().getResource(filename)).getFile()
        );

        return Path.of(file.getPath());
    }
}
