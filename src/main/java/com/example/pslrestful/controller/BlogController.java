package com.example.pslrestful.controller;

import com.example.pslrestful.dto.BlogRequestDto;
import com.example.pslrestful.entity.Blog;
import com.example.pslrestful.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        log.info("requestDto=={}",requestDto);
        return memoService.createBlog(requestDto); //memoService.
    } // 글 작성

    @GetMapping("/api/posts")
    public List<Blog> getBlogs() {
        return memoService.getBlogs();
    } // 모든 글 불러오기 (작성일 내림차순)


    //선택된 글 RUD
    @GetMapping("/api/posts/{id}")
    public Optional<Blog> getBlog(@PathVariable Long id) { //Optional<Blog>
        return memoService.getBlog(id);
    } // 특정 글만 불러오기


//    @PutMapping("/api/posts/{id}")
//    public Blog updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
//        return memoService.update(id, requestDto);
//    }

//    @DeleteMapping("/api/posts/{id}")
//    public Boolean deleteBlog(@PathVariable Long id, @PathVariable String pwd){
//        return memoService.deleteBlog(id,pwd);
//    } // 글 삭제 시 비밀번호 기입

}