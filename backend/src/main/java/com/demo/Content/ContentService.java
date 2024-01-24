package com.demo.Content;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ContentService {
    private final ContentRepository contentrepository;

    public ContentService(ContentRepository contentrepository) {
        this.contentrepository = contentrepository;
    }

    public List<Content> getallcontent() {
        return contentrepository.findAll();
    }

    public Content getContentbyid(Long contentid) {
        try {
            if (contentid == null) {
                throw new IllegalArgumentException("ID passed was null and that can't be.");
            }
            Content exists = contentrepository.findById(contentid)
                    .orElseThrow(() -> new IllegalStateException("This id doesn't exist"));
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public List<Content> getallcontentWriter(Long writerid) {
        return contentrepository.findContentBywriterid(writerid);
    }

}
