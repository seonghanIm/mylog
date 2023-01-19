package com.mylog.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String description;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String description){
        this.title = title;
        this.content = content;
        this.description = description;
    }

}
