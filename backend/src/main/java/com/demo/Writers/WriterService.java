package com.demo.Writers;

import com.demo.Content.Content;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WriterService {
    private final WriterRepository writerrepo;
    private String backendUrl;

    @Autowired
    public void setBackendUrl(@Value("${BACKEND_URL}") String backendUrl) {
        this.backendUrl = Objects.requireNonNull(backendUrl, "No backend URL provided.");
    }

    public WriterService(WriterRepository writerrepo) {
        this.writerrepo = writerrepo;
    }

    public List<Writer> getallwriters() {
        return writerrepo.findAll();
    }

    public List<Content> getcontentbywritername(String writername) {
        Writer exists = writerrepo.findWriterByName(writername).orElseThrow(
                () -> new IllegalStateException("Writer with name '" + writername + "'not found"));
        Long wrid = exists.getWriterid();

        RestTemplate template = new RestTemplate();
        @SuppressWarnings("null") // Only for the urilink as we check backendURL beforehand
        String urilink = UriComponentsBuilder.fromHttpUrl(backendUrl)
                .path("/api/content/getcontentbywriterid/{writerId}")
                .buildAndExpand(wrid)
                .toUriString();

        @SuppressWarnings("null")
        ResponseEntity<List<Content>> response = template.exchange(
                urilink,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Content>>() {
                });

        return response.getBody();
    }
}
