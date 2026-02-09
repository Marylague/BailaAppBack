package ru.appBaila.domainPart.models.outfitLogic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Outfit {
    private Long Id;
    private String Name;
    private String Description;
    private Integer Rating;
    private Integer Size;
    private Double Price;
    private String Material;
    private String ImageURL;
}
