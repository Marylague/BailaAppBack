package ru.appBaila.models.dto;

import ru.appBaila.models.entitys.Outfit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutfitDto {
    private Long Id;

    private String name;

    private String description;

    private Integer rating;

    private Integer size;

    private Double price;

    private String material;

    private String imageURL;

    public OutfitDto(Outfit entity) {
        this.Id = entity.getId();
        this.name = entity.getName();
        this.rating = entity.getRating();
        this.description = entity.getDescription();
        this.size = entity.getSize();
        this.price = entity.getPrice();
        if (entity.getMaterial() != null) {
            this.material = String.valueOf(entity.getMaterial());
        }
        this.imageURL = entity.getImageURL();
    }
}
