package com.imdb;

import com.imdb.importer.NameBasicsImporter;
import com.imdb.importer.TitleCrewImporter;
import com.imdb.importer.TitleRatingsImporter;
import com.imdb.repository.NameBasicsRepository;
import com.imdb.repository.TitleRatingsRepository;
import com.imdb.repository.TitlesCrewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadMoviesData(

            NameBasicsRepository nameBasicsRepository,
            TitleRatingsRepository titleRatingsRepository,
            TitlesCrewRepository titlesCrewRepository) {

        return (args) -> {

            new NameBasicsImporter().loadData(nameBasicsRepository);
            new TitleRatingsImporter().loadData(titleRatingsRepository);
            new TitleCrewImporter().loadData(titlesCrewRepository);

            System.out.println("*********************");
        };
    }
}
