package com.moriartynho.apilocaisderisco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.apilocaisderisco.locais.models.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {

}
