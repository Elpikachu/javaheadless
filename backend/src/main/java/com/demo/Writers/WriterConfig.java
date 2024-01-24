package com.demo.Writers;

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
public class WriterConfig {
    @Value("${WRITER_CSV_PATH_FILE}")
    private String csvFilePath;

    @Bean
    CommandLineRunner initDatabase(WriterRepository writerRepository) {
        return args -> {
            // Specify the path to your CSV file
            // String csvFilePath =
            // "/Users/julien/Repos/java_demo_preps/blog_demo/backend/src/main/java/com/demo/Writers/writers.csv";

            // String csvFilePath = "writers.csv";

            // Read data from CSV file and save to the database
            List<Writer> writers = readWritersFromCSV(csvFilePath);

            Iterable<Writer> iterableWriters = Objects.requireNonNull(writers, "Writers list must not be null");
            writerRepository.saveAll(iterableWriters);
        };
    }

    private List<Writer> readWritersFromCSV(String csvFilePath) throws IOException {
        return Files.lines(Paths.get(csvFilePath))
                .skip(1) // Skip header line if present
                .map(line -> {
                    String[] fields = line.split(",");
                    Long id = Long.parseLong(fields[0].trim());
                    String name = fields[1].trim();
                    LocalDate dateCreate = LocalDate.parse(fields[2].trim());
                    String description = fields[3].trim();

                    return new Writer(id, name, dateCreate, description);
                })
                .collect(Collectors.toList());
    }
}