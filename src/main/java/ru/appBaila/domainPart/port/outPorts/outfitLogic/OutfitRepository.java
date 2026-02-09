package ru.appBaila.domainPart.port.outPorts.outfitLogic;

import ru.appBaila.domainPart.models.outfitLogic.Outfit;

public interface OutfitRepository {
    Outfit saveNewOutfit(Outfit outfit);
    Outfit getOutfit(Outfit outfit);
    Outfit updateOutfit(Outfit outfit);
    boolean deleteOutfit(Outfit outfit);
}
