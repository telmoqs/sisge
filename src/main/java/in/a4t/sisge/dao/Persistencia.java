package in.a4t.sisge.dao;

import in.a4t.sisge.excessao.DadosInvalidosException;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface Persistencia<E> extends Serializable {
	EntityManager getEntityManager();

	void incluir(E entidade) throws DadosInvalidosException;

	void alterar(E entidade) throws DadosInvalidosException;

	List<E> alterar(List<E> entidades) throws DadosInvalidosException;

	void excluir(E entidade) throws DadosInvalidosException;

	void excluirPorId(Object id) throws DadosInvalidosException;

	List<E> listar() throws DadosInvalidosException;

	E consultar(Object obj) throws DadosInvalidosException;
	
	void flush();

	void clear();

}
