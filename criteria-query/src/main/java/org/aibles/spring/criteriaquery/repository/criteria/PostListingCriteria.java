package org.aibles.spring.criteriaquery.repository.criteria;

import org.aibles.spring.criteriaquery.model.PostEntity;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PostListingCriteria {

    private String title;
    private String creator;

    /**
     * PostListingCriteria constructor
     * @param title - String
     * @param creator - String
     */
    public PostListingCriteria(String title, String creator) {
        this.title = title;
        this.creator = creator;
    }

    /**
     * Function create specification for list posts query
     * @return
     */
    public Specification<PostEntity> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates = this.createPredicates(root, criteriaBuilder)
                    .toArray(new Predicate[0]);
            query.orderBy(new OrderImpl(root.get("createdAt"), true));
            return criteriaBuilder.and(predicates);
        };
    }

    /**
     * Function create List<Predicate> for criteria.
     * If attribute is not null, it will be added to predicate
     * @return
     */
    private List<Predicate> createPredicates(Root<PostEntity> root, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(title)) {
            predicates.add(cb.like(root.get("title"), "%" + title + "%"));
        }
        if (StringUtils.hasText(creator)) {
            predicates.add(cb.equal(root.get("creator"), creator));
        }

        return predicates;
    }
}
