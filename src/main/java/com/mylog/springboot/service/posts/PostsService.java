package com.mylog.springboot.service.posts;

import com.mylog.springboot.domain.posts.Posts;
import com.mylog.springboot.domain.posts.PostsRepository;
import com.mylog.springboot.web.dto.PostsResponseDto;
import com.mylog.springboot.web.dto.PostsSaveRequestDto;
import com.mylog.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getDescription());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    public List<PostsResponseDto> findAll(){
        List<PostsResponseDto> list = new ArrayList<>();
        List<Posts> postsList = postsRepository.findAll();
        for(int i=0;i< postsList.size();i++){
            list.add(new PostsResponseDto(postsList.get(i)));
            System.out.println(postsList.get(i));
        }

        return list;
    }
}
