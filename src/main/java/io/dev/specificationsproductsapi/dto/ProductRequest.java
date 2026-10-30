package io.dev.specificationsproductsapi.dto;

import lombok.Builder;

@Builder
public record ProductRequest (
        String name,
        String description,
        String title
) {
}
