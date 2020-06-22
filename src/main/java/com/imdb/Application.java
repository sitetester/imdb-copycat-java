package com.imdb;

import com.imdb.importer.*;
import com.imdb.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadMoviesData(

            NameBasicsRepository nameBasicsRepository,
            TitleRatingsRepository titleRatingsRepository,
            TitlesCrewRepository titlesCrewRepository,
            TitleBasicsRepository titleBasicsRepository,
            TitlePrincipalsRepository titlePrincipalsRepository
    ) {

        return (args) -> {

            System.out.println();

            new NameBasicsImporter(nameBasicsRepository).start();
            new TitleRatingsImporter(titleRatingsRepository).start();
            new TitleCrewImporter(titlesCrewRepository).start();
            new TitleBasicsImporter(titleBasicsRepository).start();
            new TitlePrincipalsImporter(titlePrincipalsRepository).start();

        };
    }
}
