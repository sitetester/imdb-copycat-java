package com.imdb.importer;

import com.imdb.entity.TitlePrincipals;
import com.imdb.repository.TitlePrincipalsRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TitlePrincipalsImporter extends AbstractImporter {

    private final TitlePrincipalsRepository titlePrincipalsRepository;

    public TitlePrincipalsImporter(TitlePrincipalsRepository titlePrincipalsRepository) {
        this.titlePrincipalsRepository = titlePrincipalsRepository;
    }

    // https://stackoverflow.com/questions/25436026/parallelstream-for-files
    public void loadData() throws IOException {

        System.out.println("Importing TitlePrincipals data...");
        String DATA_FILE_NAME = "data/title_principals.tsv";

        var count = 0;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ImportHelper.getPath(DATA_FILE_NAME))), encoding));
        for (String line; (line = reader.readLine()) != null; ) {
            count += 1;

            if (count > 1) {
                var lineData = line.split("\t");
                titlePrincipalsRepository.save(
                        new TitlePrincipals(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5])
                );
            }
        }

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
