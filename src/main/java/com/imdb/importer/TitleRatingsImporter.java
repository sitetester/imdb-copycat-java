package com.imdb.importer;

import com.imdb.entity.TitleRatings;
import com.imdb.repository.TitleRatingsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class TitleRatingsImporter {

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData(TitleRatingsRepository titleRatingsRepository) throws IOException {

        String DATA_FILE_NAME = "data/title_ratings.csv";

        var data =  Files.lines(ImportHelper.getPath(DATA_FILE_NAME))
                .skip(1)
                .parallel()
                .map(line -> line.split("\t"))
                .map(lineData -> new TitleRatings(lineData[0], lineData[1], Integer.parseInt(lineData[2])))
                .collect(Collectors.toList());

        data.subList(0, 14).parallelStream().forEach(titleRatingsRepository::save);

    }
}
