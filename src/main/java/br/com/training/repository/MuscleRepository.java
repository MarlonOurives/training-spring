package br.com.training.repository;

import br.com.training.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleRepository extends JpaRepository<MuscleRepository, Long> {
    Optional<Muscle> findByName(String name);

}
