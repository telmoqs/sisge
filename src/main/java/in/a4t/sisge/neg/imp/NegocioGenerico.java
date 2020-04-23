package in.a4t.sisge.neg.imp;

import in.a4t.sisge.dao.Persistencia;
import in.a4t.sisge.excessao.DadosInvalidosException;
import in.a4t.sisge.neg.Negocio;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class NegocioGenerico<E> implements Negocio<E> {

	protected Persistencia<E> persistencia;

	public NegocioGenerico(Persistencia<E> persistencia) {
		this.persistencia = persistencia;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(E entidade) throws DadosInvalidosException {
		try {
			persistencia.alterar(entidade);
		} catch (EntityExistsException e) {
			throw new DadosInvalidosException("Erro ao alterar. Provavelmente o registro está duplicado.");
		} catch (PersistenceException e) {
			throw new DadosInvalidosException(e.getMessage());
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(E entidade) throws DadosInvalidosException {
		persistencia.excluir(entidade);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DadosInvalidosException.class)
	public void incluir(E entidade) throws DadosInvalidosException {
		persistencia.incluir(entidade);
	}

	@Transactional
	public List<E> listar() throws DadosInvalidosException {
		return persistencia.listar();
	}

}
