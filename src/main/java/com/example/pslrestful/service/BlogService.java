package com.example.pslrestful.service;

import com.example.pslrestful.dto.BlogRequestDto;
import com.example.pslrestful.dto.SuccessDto;
import com.example.pslrestful.entity.Blog;
import com.example.pslrestful.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Blog createBlog(BlogRequestDto requestDto) {
        log.info("requestDto=={}",requestDto);
        Blog memo = new Blog(requestDto);
        log.info("memo=={}",memo);
        blogRepository.save(memo);
        return memo;
    } //블로그 글 생성



    @Transactional(readOnly = true)
    public List<Blog> getBlogs() { //return memoRepository.findAllByOrderByModifiedAtDesc();
                      return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")); }
    //글 불러올 때, 내림차순으로 정렬해서 불러오기.

    @Transactional(readOnly = true)
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow();
        //특정 id만 불러오기.
    }

    @Transactional
    public Blog update(Long id, BlogRequestDto requestDto) { //BlogRequestDto > pwd
        Blog memo = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return blogRepository.findById(id).orElseThrow();/*memo.getId();*/
    }


    @Transactional
    public SuccessDto deleteBlog(Long id,String pwd) {
        //pwd 매칭
        Blog byId = blogRepository.findById(id).orElseThrow();
        SuccessDto success = new SuccessDto();
        if(byId.getPwd().equals(pwd)){
            blogRepository.deleteById(id);
            success.setSuccess(true);
            return success;//byId.getSuccess();
        }else{
            return success;
        }

    }




}
