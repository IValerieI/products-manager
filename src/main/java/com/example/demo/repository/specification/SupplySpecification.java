package com.example.demo.repository.specification;

import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.SellerEntity;
import com.example.demo.model.entity.SupplyEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplySpecification {

    public static Specification<SupplyEntity> getSpecification(SellerEntity sellerEntity,
                                                               ProductEntity productEntity,
                                                               CustomerEntity customerEntity,
                                                               LocalDate fromDate,
                                                               LocalDate toDate) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(builder.equal(root.get("sellerEntity"), sellerEntity));
            if (productEntity != null) {
                predicates.add(builder.equal(root.get("productEntity"), productEntity));
            }
            if (customerEntity != null) {
                predicates.add(builder.equal(root.get("customerEntity"), customerEntity));
            }
            if (fromDate != null && toDate != null) {
                predicates.add(builder.between(root.get("date"), fromDate, toDate));
            }

            query.orderBy(builder.desc(root.get("date")));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}