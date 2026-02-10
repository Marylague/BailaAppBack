package ru.appBaila.domainPart.port.inPorts.outfitLogic;

import ru.appBaila.domainPart.models.outfitLogic.Outfit;

public interface UsingOutfitCases {
    boolean deleteOutfit(Outfit outfit);
    Outfit getOutfit(Outfit outfit);
    Outfit createOutfit(Outfit outfit);
    Outfit updateOutfit(Outfit outfit);
}
