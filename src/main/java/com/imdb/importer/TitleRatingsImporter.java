package com.imdb.importer;

import com.imdb.entity.TitleRatings;
import com.imdb.repository.TitleRatingsRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TitleRatingsImporter extends AbstractImporter {

    private final TitleRatingsRepository titleRatingsRepository;

    public TitleRatingsImporter(TitleRatingsRepository titleRatingsRepository) {
        this.titleRatingsRepository = titleRatingsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitleRatings data...");
        String DATA_FILE_NAME = "data/title_ratings.tsv";

        var count = 0;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ImportHelper.getPath(DATA_FILE_NAME))), encoding));
        for (String line; (line = reader.readLine()) != null; ) {
            count += 1;

            if (count > 1) {
                var lineData = line.split("\t");
                titleRatingsRepository.save(
                        new TitleRatings(lineData[0], lineData[1], Integer.parseInt(lineData[2]))
                );
            }
        }

        System.out.println("DONE - TitleRatings data");
    }

    public void run() {
        try {
            loadData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
