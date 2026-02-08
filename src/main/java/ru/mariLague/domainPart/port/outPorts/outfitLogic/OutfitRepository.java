package ru.mariLague.domainPart.port.outPorts.outfitLogic;

import ru.mariLague.domainPart.models.outfitLogic.Outfit;

public interface OutfitRepository {
    Outfit saveNewOutfit(Outfit outfit);
    Outfit getOutfit(Outfit outfit);
    Outfit updateOutfit(Outfit outfit);
    boolean deleteOutfit(Outfit outfit);
}
