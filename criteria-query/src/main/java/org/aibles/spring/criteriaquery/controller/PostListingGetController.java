package org.aibles.spring.criteriaquery.controller;

import org.aibles.spring.criteriaquery.dto.GenericResponse;
import org.aibles.spring.criteriaquery.dto.PagingRequest;
import org.aibles.spring.criteriaquery.dto.request.PostListingReq;
import org.aibles.spring.criteriaquery.dto.response.PostListingRes;
import org.aibles.spring.criteriaquery.service.PostListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostListingGetController {

    private final PostListingService service;

    @Autowired
    public PostListingGetController(PostListingService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse execute(PostListingReq postListingReq, PagingRequest pageReq) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setResult("OK");
        response.setData(service.execute(postListingReq, pageReq.makePageable()));
        return response;
    }

}
