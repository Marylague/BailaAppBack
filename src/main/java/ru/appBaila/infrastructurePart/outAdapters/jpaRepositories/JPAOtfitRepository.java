package ru.appBaila.infrastructurePart.outAdapters.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.appBaila.domainPart.models.outfitLogic.Outfit;

public interface JPAOtfitRepository extends JpaRepository<Outfit, Integer> {
}
