package com.imdb.importer;

import com.imdb.entity.TitleBasics;
import com.imdb.repository.TitleBasicsRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TitleBasicsImporter extends AbstractImporter {

    private final TitleBasicsRepository titleBasicsRepository;

    public TitleBasicsImporter(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitleBasics data...");
        String DATA_FILE_NAME = "data/title_basics.tsv";


        reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ImportHelper.getPath(DATA_FILE_NAME))), encoding));
        reader.lines().skip(1).forEach(line -> {
            var lineData = line.split("\t");
            titleBasicsRepository.save(
                    new TitleBasics(lineData[0],
                            lineData[1], lineData[2], lineData[3], lineData[4],
                            lineData[5], lineData[6], lineData[7], lineData[8])
            );
        });

        System.out.println("DONE - TitleBasics data");
    }

    public void run() {
        try {
            loadData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
