package ru.appBaila.repositories;

import ru.appBaila.models.entitys.Outfit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAOutfitRepository extends JpaRepository<Outfit, Long> {
}
