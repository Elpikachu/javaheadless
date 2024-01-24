package com.demo.Content;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentConfig {
    @Value("${CONTENT_CSV_PATH_FILE}")
    private String csvFilePath;

    @Bean
    CommandLineRunner initDatabaseContent(ContentRepository contentRepository) {
        return args -> {
            List<Content> content = readContentFromCSV(csvFilePath);
            Iterable<Content> iterableContent = Objects.requireNonNull(content, "Content list must not be null");
            contentRepository.saveAll(iterableContent);
        };
    }

    private List<Content> readContentFromCSV(String csvFilePath) throws IOException {
        return Files.lines(Paths.get(csvFilePath))
                .skip(1)
                .map(line -> {
                    String[] fields = line.split(",");
                    Long id = Long.parseLong(fields[0].trim());
                    String title = fields[1].trim();
                    Long writerid = Long.parseLong(fields[2].trim());
                    String summary = fields[3].trim();
                    String writername = fields[4].trim();
                    String article = fields[5].trim();
                    LocalDate dateCreate = LocalDate.parse(fields[6].trim());
                    String category = fields[7].trim();
                    String imglink = fields[8].trim();

                    return new Content(id, title, writerid, summary, writername, article, dateCreate, category,
                            imglink);
                })
                .collect(Collectors.toList());
    }
}
