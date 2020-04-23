package in.a4t.sisge.neg;

import in.a4t.sisge.entidade.Pessoa;
import in.a4t.sisge.excessao.DadosInvalidosException;

public interface PessoaNeg extends Negocio<Pessoa> {

	Pessoa consultarPorEmail(String email) throws DadosInvalidosException;
}
