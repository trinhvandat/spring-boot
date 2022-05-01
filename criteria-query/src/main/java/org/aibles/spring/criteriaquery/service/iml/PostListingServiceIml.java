package org.aibles.spring.criteriaquery.service.iml;

import org.aibles.spring.criteriaquery.dto.request.PostListingReq;
import org.aibles.spring.criteriaquery.dto.response.PostListingRes;
import org.aibles.spring.criteriaquery.model.PostEntity;
import org.aibles.spring.criteriaquery.repository.PostRepository;
import org.aibles.spring.criteriaquery.repository.criteria.PostListingCriteria;
import org.aibles.spring.criteriaquery.service.PostListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostListingServiceIml implements PostListingService {

    private final PostRepository postRepository;

    @Autowired
    public PostListingServiceIml(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<PostListingRes> execute(PostListingReq postListingReq, Pageable pageable) {
        PostListingCriteria postListingQueryCriteria =
                new PostListingCriteria(postListingReq.getTitle(), postListingReq.getCreator());

        return postRepository.findAll(postListingQueryCriteria.toSpecification(), pageable)
                .map(new Function<PostEntity, PostListingRes>() {
                    @Override
                    public PostListingRes apply(PostEntity postEntity) {
                        PostListingRes postRes = new PostListingRes();
                        postRes.setId(postEntity.getId());
                        postRes.setTitle(postEntity.getTitle());
                        postRes.setCreator(postEntity.getCreator());
                        postRes.setCreatedAt(postEntity.getCreatedAt());
                        return postRes;
                    }
                });
    }
}
