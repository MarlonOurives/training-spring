package br.com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<MembershipRepository, Long> {
    Optional<MembershipRepository> findByName(String name);
}
