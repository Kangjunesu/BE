package com.team11.shareoffice.post.entity;

import com.team11.shareoffice.member.entity.Member;
import com.team11.shareoffice.post.dto.PostRequestDto;
import com.team11.shareoffice.post.dto.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    // 게시글 제목
    @Column(nullable = false)
    private String title;
    // 게시글 내용
    @Column(nullable = false, length = 5000)
    private String content;
    // 주소
    @Column(nullable = false)
    private String location;
    // 임대료
    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int capacity;  //총 인원 수

    @Column(nullable = false)
    private String contentDetails; //추가 내용

    //좋아요 개수
    @Column(nullable = false)
    @ColumnDefault("0")
    private int likeCount;

    @Column
    @Lob
    private List<String> postImages;

    @OneToOne(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Amenities amenities;

    @OneToOne(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private OperatingTime operatingTime;

    @Column
    private boolean isDelete;

    public Post (PostRequestDto requestDto, Amenities amenities, OperatingTime operatingTime, Member member){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent().replace("\\n", "\n");
        this.location = requestDto.getLocation();
        this.price = requestDto.getPrice();
        this.capacity = requestDto.getCapacity();
        this.operatingTime = operatingTime;
        this.contentDetails = requestDto.getContentDetails().replace("\\n", "\n");
        this.amenities = amenities;
        this.member = member;
    }

    public void updatePost (PostUpdateRequestDto requestDto, Amenities amenities, OperatingTime operatingTime){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent().replace("\\n", "\n");
        this.location = requestDto.getLocation();
        this.price = requestDto.getPrice();
        this.capacity = requestDto.getCapacity();
        this.operatingTime = operatingTime;
        this.contentDetails = requestDto.getContentDetails().replace("\\n", "\n");
        this.amenities = amenities;
    }

    public void updateLike(Boolean likeOrDislike) {
        this.likeCount = Boolean.TRUE.equals(likeOrDislike) ? this.likeCount + 1 : this.likeCount - 1;
    }
}
