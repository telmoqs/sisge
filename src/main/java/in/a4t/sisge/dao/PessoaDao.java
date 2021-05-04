package in.a4t.sisge.dao;

import in.a4t.sisge.entidade.Pessoa;
import in.a4t.sisge.excessao.DadosInvalidosException;

public interface PessoaDao extends Persistencia<Pessoa> {

	Pessoa consultarPorEmail(String email) throws DadosInvalidosException;

}
