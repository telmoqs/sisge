package in.a4t.sisge.neg;

import in.a4t.sisge.excessao.DadosInvalidosException;

import java.util.List;

public interface Negocio<E> {

	void incluir(E entidade) throws DadosInvalidosException;

	void alterar(E entidade) throws DadosInvalidosException;

	void excluir(E entidade) throws DadosInvalidosException;

	List<E> listar() throws DadosInvalidosException;

}
