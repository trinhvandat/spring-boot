package org.aibles.spring.criteriaquery.service;

import org.aibles.spring.criteriaquery.dto.request.PostListingReq;
import org.aibles.spring.criteriaquery.dto.response.PostListingRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostListingService {
    Page<PostListingRes> execute(PostListingReq postListingReq, Pageable pageable);
}
