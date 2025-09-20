package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.Niche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NicheRepository extends JpaRepository<Niche,Long> {
    Optional<Niche> findByName(String name);
    List<Niche> findByNameContaining(String keyword);
}
