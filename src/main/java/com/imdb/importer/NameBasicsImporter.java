package com.imdb.importer;

import com.imdb.entity.NameBasics;
import com.imdb.repository.NameBasicsRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameBasicsImporter extends AbstractImporter {

    private final NameBasicsRepository nameBasicsRepository;

    public NameBasicsImporter(NameBasicsRepository nameBasicsRepository) {
        this.nameBasicsRepository = nameBasicsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing NameBasics data...");
        String DATA_FILE_NAME = "data/name_basics.tsv";

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ImportHelper.getPath(DATA_FILE_NAME))), encoding));
        reader.lines().skip(1).forEach(line -> {
            var lineData = line.split("\t");
            nameBasicsRepository.save(
                    new NameBasics(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5])
            );
        });

        System.out.println("DONE - NameBasics data");
    }

    public void run() {
        try {
            loadData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
