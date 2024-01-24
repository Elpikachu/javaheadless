package com.demo.Writers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Content.Content;

@RestController
@RequestMapping
public class WriterController {
    private final WriterService authserv;

    public WriterController(WriterService authserv) {
        this.authserv = authserv;
    }

    @GetMapping(path = "/api/writers/all")
    public List<Writer> getwriters() {
        return authserv.getallwriters();
    }

    @GetMapping(path = "/api/writers/getcontent/{writername}")
    public List<Content> getcontentbywritername(@PathVariable String writername) {
        return authserv.getcontentbywritername(writername);
    }
}
