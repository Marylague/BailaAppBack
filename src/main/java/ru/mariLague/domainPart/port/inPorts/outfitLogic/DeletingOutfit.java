package ru.mariLague.domainPart.port.inPorts.outfitLogic;

import ru.mariLague.domainPart.models.outfitLogic.Outfit;

public interface DeletingOutfit {
    boolean deleteOutfit(Outfit outfit);
}
