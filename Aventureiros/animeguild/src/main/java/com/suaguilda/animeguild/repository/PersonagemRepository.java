package com.suaguilda.animeguild.repository;

import com.suaguilda.animeguild.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}