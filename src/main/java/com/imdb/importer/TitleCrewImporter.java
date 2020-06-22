package com.imdb.importer;

import com.imdb.entity.TitlesCrew;
import com.imdb.repository.TitlesCrewRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TitleCrewImporter extends AbstractImporter {

    private final TitlesCrewRepository titlesCrewRepository;

    public TitleCrewImporter(TitlesCrewRepository titlesCrewRepository) {
        this.titlesCrewRepository = titlesCrewRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitleCrew data...");
        String DATA_FILE_NAME = "data/title_crew.tsv";

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ImportHelper.getPath(DATA_FILE_NAME))), encoding));
        reader.lines().skip(1).forEach(line -> {
            var lineData = line.split("\t");
            titlesCrewRepository.save(
                    new TitlesCrew(lineData[0], lineData[1], lineData[2])
            );
        });

        System.out.println("DONE - TitleCrew data");
    }

    public void run() {
        try {
            loadData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
