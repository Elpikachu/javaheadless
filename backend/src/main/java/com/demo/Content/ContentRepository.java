package com.demo.Content;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
    public List<Content> findContentBywriterid(Long writerid);
}
