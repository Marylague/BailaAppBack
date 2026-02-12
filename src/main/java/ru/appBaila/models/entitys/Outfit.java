package ru.appBaila.models.entitys;


import ru.appBaila.models.dto.OutfitDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Outfits_Info")
@NoArgsConstructor
@AllArgsConstructor
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Integer size;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Material material;

    @Column(nullable = false)
    private String imageURL;

    public Outfit(OutfitDto dto) {
        this.Id = dto.getId();
        this.name = dto.getName();
        this.rating = dto.getRating();
        this.description = dto.getDescription();
        this.size = dto.getSize();
        this.price = dto.getPrice();
        if (dto.getMaterial() != null) {
            this.material = Material.valueOf(dto.getMaterial());
        }
        this.imageURL = dto.getImageURL();
    }
}
