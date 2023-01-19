package com.mylog.springboot.domain.posts;


import com.mylog.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
이 클래스에는 Setter 메소드가 없다, 자바빈 규약을 생각하면서 getter와 setter를 무작정 생성하는 경우가 있는데 이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서
변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 복잡해짐. 그래서 Entity클래스에서는 절대 Setter 메소드를 만들지 않는다. 대신 해당 필드의 값 변경이
필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야한다.
*/
@Getter// 롬복 , 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor // 롬복, 기본 생성자 자동 추가
@Entity // jpa의 어노테이션, 테이블과 링크될 클래스임을 나타냄.
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙, Generation.IDENTITY => auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // @Column 은 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 이 클래스의 필드는 모두 칼럼임을 나타낸다.
                                            // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을 떄 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;


    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author, String description){
        this.title = title;
        this.content = content;
        this.author = author;
        this.description = description;
    }

    public void update(String title,String content, String description){
        this.title = title;
        this.content = content;
        this.description = description;
    }

}
