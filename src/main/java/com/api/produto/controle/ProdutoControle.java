package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

//especificando que esta classe é um controlador

@RestController
@RequestMapping("/api")
public class ProdutoControle {

	//Ações
	@Autowired
	private ProdutoRepositorio acoes;
	
	//Listar produtos
	@RequestMapping(value="/produtos",method=RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll();
	}
	
	
	//Cadastrar produtos
	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	//filtrar proutos
	@RequestMapping(value="/produtos/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable int codigo) {
		return acoes.findByCodigo(codigo);
	}
	
	//Alterando um informação no banco de dados
	@RequestMapping(value = "/produto", method = RequestMethod.PUT)
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Removendo um objeto
	@RequestMapping(value="/produtos/{codigo}",method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable int codigo) {
		RespostaModelo resposta = new RespostaModelo();
		try {
			ProdutoModelo produto = filtrar(codigo);
			this.acoes.delete(produto);
			resposta.setMensagem("Produto removido com sucesso");
		}catch (Exception e) {
			resposta.setMensagem("Ocorreu um erro ao relizar a operação de remoção :"  + e.getMessage());
		}
		
		return resposta;
	}
	
}