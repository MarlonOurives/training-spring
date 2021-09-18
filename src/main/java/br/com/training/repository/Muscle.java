package br.com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Muscle extends JpaRepository<Muscle, Long> {
}
