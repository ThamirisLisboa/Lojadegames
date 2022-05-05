package com.generation.lojaGames.Repository;
 import java.util.List;

import org.springframework.stereotype.Repository;
 
 @Repository
public class ProdutotosRepository  extends JpaRepository<Produtos, Long>{
 public List<Produtos> findAllByDescricaoContainingIgnoreCase (String descricao);	 

}
