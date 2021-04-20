package com.ada.adalibrary.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
public class CommentEntity {
    @Id
    private String id;
    private String bookExtid;
    private String commentAuthorName;
    private String comment_content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
