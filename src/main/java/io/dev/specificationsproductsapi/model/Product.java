package io.dev.specificationsproductsapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    // columnDefinition = "VARCHAR(MAX)" para SQL SERVER
    @Column(name = "description",  nullable = false, columnDefinition = "VARCHAR(MAX)")
    private String description;

    @Column(name = "link_id", nullable = false, length = 300)
    private String linkId;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;


}
