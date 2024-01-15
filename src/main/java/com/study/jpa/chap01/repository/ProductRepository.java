package com.study.jpa.chap01.repository;

import com.study.jpa.chap01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 를 상속받고 제네릭은 첫번째 엔터티 클래스, 두번째는 PK 타입, 객체 타입으로 쓸 것.
public interface ProductRepository extends JpaRepository<Product, Long> {


}
