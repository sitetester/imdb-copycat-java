package com.imdb.importer;

import com.imdb.entity.TitlesCrew;
import com.imdb.repository.TitlesCrewRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class TitleCrewImporter extends AbstractImporter {

    private final TitlesCrewRepository titlesCrewRepository;

    public TitleCrewImporter(TitlesCrewRepository titlesCrewRepository) {
        this.titlesCrewRepository = titlesCrewRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitleCrew data...");
        String DATA_FILE_NAME = "data/title_crew.tsv";
        ;

        var data = Files.lines(ImportHelper.getPath(DATA_FILE_NAME))
                .skip(1)
                .parallel()
                .map(line -> line.split("\t"))
                .map(lineData -> new TitlesCrew(lineData[0], lineData[1], lineData[2]))
                .collect(Collectors.toList());

        data.forEach(titlesCrewRepository::save);
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
