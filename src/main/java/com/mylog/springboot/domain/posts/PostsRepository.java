package com.mylog.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> { // 보통 Dao라고 불리는 DB Layer 접근자 , JpaRepository<Entity 클래스, PK 타입>
    // JpaRepository를 상속하면 기본적으로 CRUD 메소드가 자동으로 생성됨.
    // 주의할 점은 Entity클래스와 기본 Entity Repository는 함께 위치해야 한다.

}
