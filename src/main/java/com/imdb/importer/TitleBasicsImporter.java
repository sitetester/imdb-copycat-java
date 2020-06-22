package com.imdb.importer;

import com.imdb.entity.TitleBasics;
import com.imdb.repository.TitleBasicsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class TitleBasicsImporter extends AbstractImporter {

    private final TitleBasicsRepository titleBasicsRepository;

    public TitleBasicsImporter(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitleBasics data...");
        String DATA_FILE_NAME = "data/title_basics.tsv";

        var data = Files.lines(ImportHelper.getPath(DATA_FILE_NAME))
                .skip(1)
                .parallel()
                .map(line -> line.split("\t"))
                .map(lineData -> new TitleBasics(lineData[0],
                        lineData[1], lineData[2], lineData[3], lineData[4],
                        lineData[5], lineData[6], lineData[7], lineData[8]))
                .collect(Collectors.toList());

        data.forEach(titleBasicsRepository::save);
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
