package io.dev.specificationsproductsapi.specification;

import io.dev.specificationsproductsapi.model.Product;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Locale;

public class ProductSpec {


    public static Specification<Product> nameLike(String name) {
        return ((root, query, criteriaBuilder) -> {
            if (ObjectUtils.isEmpty(name)) {
                return null;
            }
            return criteriaBuilder.like(root.get("name"), "%" + name.toLowerCase(Locale.ROOT) + "%");
        });
    }

    public static Specification<Product> titleContains(String title) {
        return ((root, query, criteriaBuilder) ->  {
            if (ObjectUtils.isEmpty(title)) {
                return null;
            }
            return criteriaBuilder.like(root.get("title"), "%" + title.toLowerCase(Locale.ROOT) + "%");
        });
    }

    public static Specification<Product> descriptionContains(String description) {
        return ((root, query, criteriaBuilder) ->  {
            if (ObjectUtils.isEmpty(description)) {
                return null;
            }
            return criteriaBuilder.like(root.get("description"), "%" + description.toLowerCase(Locale.ROOT) + "%");
        });
    }
    public static Specification<Product> linkIdContains(String linkId) {
        return ((root, query, criteriaBuilder) ->  {
            if (ObjectUtils.isEmpty(linkId)) {
                return null;
            }
            return criteriaBuilder
                    .like(root.get("linkId"), "%" + linkId.toLowerCase(Locale.ROOT) + "%");
        });
    }

    // ate
    public static Specification<Product> createdBefore(Instant endDate) {
        return ((root, query, criteriaBuilder) ->  {
            if (ObjectUtils.isEmpty(endDate)) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate);
        });
    }

    public static Specification<Product> isActiveEquals(Boolean isActive) {
        return ((root, query, criteriaBuilder) ->  {
            if (ObjectUtils.isEmpty(isActive)) {
                return null;
            }
            return criteriaBuilder.equal(root.get("isActive"), isActive);
        });
    }



}

