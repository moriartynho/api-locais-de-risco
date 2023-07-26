package com.moriartynho.apilocaisderisco.mantimentos.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.apilocaisderisco.imagem.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
