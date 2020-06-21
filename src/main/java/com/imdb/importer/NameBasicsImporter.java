package com.imdb.importer;

import com.imdb.entity.NameBasics;
import com.imdb.repository.NameBasicsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class NameBasicsImporter {

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData(NameBasicsRepository nameBasicsRepository) throws IOException {

        String DATA_FILE_NAME = "data/name_basics.csv";

        var data = Files.lines(ImportHelper.getPath(DATA_FILE_NAME))
                .skip(1)
                .parallel()
                .map(line -> line.split("\t"))
                .map(lineData -> new NameBasics(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5]))
                .collect(Collectors.toList());

        data.subList(0, 14).parallelStream().forEach(nameBasicsRepository::save);
    }
}
