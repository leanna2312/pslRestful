package com.example.pslrestful.entity;

//import com.example.memorestful.dto.MemoRequestDto;
import com.example.pslrestful.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username; // 작성자명

    @Column(nullable = false)
    private String title; // 제목
    @Column(nullable = false)
    private String contents; // 작성 내용

    @Column(nullable = false)
    private String pwd; // 글 작성 비밀번호

    @Column(nullable = false)
    private Boolean success; // 글 작성 비밀번호

    public String getPwd() {
        return pwd;
    }

    public Blog(String username, String title, String contents, String pwd) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.pwd = pwd;
    }

    public Blog(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.pwd = requestDto.getPwd(); // 패스워드
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.username = blogRequestDto.getUsername();
        this.contents = blogRequestDto.getContents();
        this.title = blogRequestDto.getTitle();
        this.pwd = blogRequestDto.getPwd(); // 패스워드

    }

    public void delete(BlogRequestDto blogRequestDto){
        this.pwd = blogRequestDto.getPwd();
    }

}