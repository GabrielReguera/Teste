package com.reguera.springvs.repository;

import java.util.List;
import java.util.Optional;

import com.reguera.springvs.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Optional<Produto> findById(Long id);

    List<Produto> findByDescricaoContaining(String descricao);
}
