package com.generation.lojaGames.Repository;
import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter

public interface categoriaRepository extends JpaRepository<Produtotos, Long> {
  public List<categoria> findAllByTituloContainingIgnoreCase( String titulo);
}
