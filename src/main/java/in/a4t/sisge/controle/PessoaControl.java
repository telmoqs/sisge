package in.a4t.sisge.controle;

import in.a4t.sisge.entidade.Pessoa;
import in.a4t.sisge.excessao.DadosInvalidosException;
import in.a4t.sisge.neg.PessoaNeg;
import in.a4t.sisge.util.SisgeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("PessoaControl")
@Scope("session")
public class PessoaControl extends SisgeControl {

	@Autowired
	private PessoaNeg pessoaNeg;

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private String senha1;
	private String senha2;

	public PessoaControl() {
		this.criarEntidade();
	}

	@Override
	protected void criarEntidade() {
		pessoa = new Pessoa();
		pessoas = new ArrayList<Pessoa>();
		senha1 = "";
		senha2 = "";
	}

	@Override
	protected void atualizarListaEntidades() throws Exception {
		try {
			if (!SisgeUtil.ehVazio(pessoa.getEmail())) {
				pessoas = new ArrayList<Pessoa>();
				pessoas.add(pessoaNeg.consultarPorEmail(pessoa.getEmail()));
			} else {
				pessoas = pessoaNeg.listar();
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	public String incluir() {
		try {
			this.validar(pessoa);
			pessoaNeg.incluir(pessoa);
			addMensagemInfo(msgIncluidoSucesso);
			this.criarEntidade();
		} catch (DadosInvalidosException e) {
			addMensagemAviso(e.getMessage());
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
		return null;
	}

	public String alterar() {
		try {
			this.validar(pessoa);
			pessoaNeg.alterar(pessoa);
			telaListar();
			addMensagemInfo(msgAlteradoSucesso);
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
		return null;
	}

	public String atualizarLista() {
		try {
			atualizarListaEntidades();
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
		return null;
	}

	private void validar(Pessoa pessoa) throws DadosInvalidosException {
		if (SisgeUtil.ehVazio(pessoa.getEmail())) {
			throw new DadosInvalidosException("Infome um e-mail.");
		}
		if (SisgeUtil.ehVazio(pessoa.getSenha())) {
			throw new DadosInvalidosException("Infome uma senha.");
		}
	}

	public void alterarSenha(ActionEvent evento) {
		if (SisgeUtil.ehVazio(senha1) || SisgeUtil.ehVazio(senha2)) {
			addMensagemAviso("As senhas não podem ser nulas");
		} else if (senha1 != null && senha1.equals(senha2)) {
			try {
				pessoa.setSenha(senha1);
				pessoa.setDataSenha(new Date());
				pessoaNeg.alterar(pessoa);
				pessoa = new Pessoa();
				addMensagemInfo("Senha alterada com sucesso!");
				senha1 = "";
				senha2 = "";
			} catch (Exception e) {
				e.printStackTrace();
				addMensagemErroFatal(e);
			}
		} else {
			addMensagemAviso("As senhas devem ser iguais!");
		}
	}

	public void recuperarSenha() {
		addMensagemInfo("Sua senha foi encaminhada ao seu email de contato");
	}

	@Override
	public String getTitulo() {
		return "Pessoa";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

}
