package com.demo.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("imgs/" + imageName);

        if (imgFile.exists()) {
            byte[] bytes = Files.readAllBytes(Path.of(imgFile.getURI()));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
