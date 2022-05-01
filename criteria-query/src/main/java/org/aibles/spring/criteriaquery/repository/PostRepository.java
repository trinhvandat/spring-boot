package org.aibles.spring.criteriaquery.repository;

import org.aibles.spring.criteriaquery.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>,
        JpaSpecificationExecutor<PostEntity> {
}
