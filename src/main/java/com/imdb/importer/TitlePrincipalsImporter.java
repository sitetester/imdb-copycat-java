package com.imdb.importer;

import com.imdb.entity.TitlePrincipals;
import com.imdb.repository.TitlePrincipalsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class TitlePrincipalsImporter extends AbstractImporter {

    private final TitlePrincipalsRepository titlePrincipalsRepository;

    public TitlePrincipalsImporter(TitlePrincipalsRepository titlePrincipalsRepository) {
        this.titlePrincipalsRepository = titlePrincipalsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitlePrincipals data...");
        String DATA_FILE_NAME = "data/title_principals.tsv";


        var data = Files.lines(ImportHelper.getPath(DATA_FILE_NAME))
                .skip(1)
                .parallel()
                .map(line -> line.split("\t"))
                .map(lineData -> new TitlePrincipals(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5]))
                .collect(Collectors.toList());

        data.forEach(titlePrincipalsRepository::save);
        System.out.println("DONE - TitlePrincipals data");
    }

    public void run() {
        try {
            loadData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
