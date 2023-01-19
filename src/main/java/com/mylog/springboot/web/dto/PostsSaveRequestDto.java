package com.mylog.springboot.web.dto;

import com.mylog.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String description;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String description){
        this.title = title;
        this.content = content;
        this.author = author;
        this.description = description;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .description(description)
                .build();
    }
}
