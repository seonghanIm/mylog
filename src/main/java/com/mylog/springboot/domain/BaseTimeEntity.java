package com.mylog.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity 를 상속할 경우 아래 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {
    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장됨
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장됨
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

}
