package com.demo.Content;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContentController {
    private final ContentService contentservice;

    public ContentController(ContentService contentservice) {
        this.contentservice = contentservice;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "api/content/all")
    public List<Content> getallcontent() {
        return contentservice.getallcontent();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "api/content/getbyid/{id}")
    public Content getcontentbyid(@PathVariable("id") Long contentid) {
        return contentservice.getContentbyid(contentid);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "api/content/getcontentbywriterid/{writerid}")
    public List<Content> getallcontentwriter(@PathVariable Long writerid) {
        return contentservice.getallcontentWriter(writerid);
    }

}
