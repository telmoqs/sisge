package in.a4t.sisge.neg.imp;

import in.a4t.sisge.dao.PessoaDao;
import in.a4t.sisge.entidade.Pessoa;
import in.a4t.sisge.excessao.DadosInvalidosException;
import in.a4t.sisge.neg.PessoaNeg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pessoaNeg")
public class PessoaNegImpl extends NegocioGenerico<Pessoa> implements PessoaNeg {

	@Autowired
	public PessoaNegImpl(PessoaDao persistencia) {
		super(persistencia);
	}

	@Override
	public Pessoa consultarPorEmail(String email) throws DadosInvalidosException {
		return ((PessoaDao) persistencia).consultarPorEmail(email);
	}

}