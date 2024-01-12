package com.study.jpa.chap01.repository;

import com.study.jpa.chap01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 를 상속받고 제네릭은 첫번째 엔터티 클랫, 두번째는 PK 타입
public interface ProductRepository extends JpaRepository<Product, Long> {


}
