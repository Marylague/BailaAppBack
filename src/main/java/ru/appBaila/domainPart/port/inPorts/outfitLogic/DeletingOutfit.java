package ru.appBaila.domainPart.port.inPorts.outfitLogic;

import ru.appBaila.domainPart.models.outfitLogic.Outfit;

public interface DeletingOutfit {
    boolean deleteOutfit(Outfit outfit);
}
