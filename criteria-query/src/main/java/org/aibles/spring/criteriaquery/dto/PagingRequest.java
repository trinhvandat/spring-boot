package org.aibles.spring.criteriaquery.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class PagingRequest {

    private Integer pageNumber;
    private Integer pageSize;

    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    public Pageable makePageable() {
        return PageRequest.of(getPageNumber() - 1, getPageNumber());
    }

    public Integer getPageNumber() {
        return Optional.ofNullable(pageNumber).orElse(DEFAULT_PAGE_NUMBER);
    }

    public Integer getPageSize() {
        return Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);
    }
}
