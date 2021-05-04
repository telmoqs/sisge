package in.a4t.sisge.dao.jpa;

import in.a4t.sisge.dao.PessoaDao;
import in.a4t.sisge.entidade.Pessoa;
import in.a4t.sisge.excessao.DadosInvalidosException;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository("PessoaDao")
public class PessoaDaoJpa extends PersistenciaJpa<Pessoa> implements PessoaDao {

	public PessoaDaoJpa() {
		super(Pessoa.class);
	}

	@Override
	public Pessoa consultarPorEmail(String email) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select entidade from Pessoa entidade where entidade.email = :email");
			query.setParameter("email", email);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			throw new DadosInvalidosException(e.getMessage());
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}