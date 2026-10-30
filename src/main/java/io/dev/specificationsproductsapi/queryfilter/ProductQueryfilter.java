package io.dev.specificationsproductsapi.queryfilter;

import io.dev.specificationsproductsapi.model.Product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import static io.dev.specificationsproductsapi.specification.ProductSpec.*;

@Getter
@Setter
public class ProductQueryfilter {

    private String name;
    private String title;
    private String description;
    private Boolean isActive;

    public Specification<Product> getSpecification() {
        return nameLike(name)
                .and(titleContains(title))
                .and(descriptionContains(description))
                .and(isActiveEquals(isActive));
    }

}
