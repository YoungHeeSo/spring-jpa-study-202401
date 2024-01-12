package com.study.jpa.chap01.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="tbl_product")
public class Product {

    // 엔터티 클래스는 DB 테이블의 칼럼과 1대 1로 매칭되는 필드를 선언
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private long id; // PK

    @Column(name = "prod_nm", length = 30, nullable = false)
    private String name; // 상품 이름

    @Builder.Default
    private int price=1000; // 상품 가격

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // null 값이 허용되지 않는다
    // unique = true 값이 중복 되는걸 방지
    private Category category; // 상품 카테고리

    @CreationTimestamp // INSERT 시 현재 로컬 서버 시간 자동 저장
    @Column(updatable = false) // 수정 불가
    private LocalDateTime createdDate; // 상품 등록 시간

    @UpdateTimestamp // UPDATE문 실행시 자동으로 수정시간 변경
    private LocalDateTime updatedDate; // 상품 수정 시간

    @Transient // DB칼럼에는 생성되지 않고 java에서만 사용 가능함
    private String nickName;
}
