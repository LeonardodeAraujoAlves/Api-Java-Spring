package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;
/**
 * Um repositóri vai definir o que pode ser feito
 */
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{

	//List all intens
	List<ProdutoModelo> findAll();
	
	//Search product
	ProdutoModelo findByCodigo(int codigo);
	
	//Delete product
	void delete(ProdutoModelo produto);
	
	//Insert/update product
	<ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);
}
