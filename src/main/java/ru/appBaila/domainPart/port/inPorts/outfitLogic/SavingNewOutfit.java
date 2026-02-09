package ru.appBaila.domainPart.port.inPorts.outfitLogic;

import ru.appBaila.domainPart.models.outfitLogic.Outfit;

public interface SavingNewOutfit {
    Outfit createOutfit(Outfit outfit);
    Outfit updateOutfit(Outfit outfit);
}
