package ru.vlapin.trainings.integrationtraining.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.trainings.integrationtraining.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
