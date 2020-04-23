package in.a4t.sisge.controle;

import in.a4t.sisge.enumeradores.EnumAcao;
import in.a4t.sisge.enumeradores.EnumTela;
import in.a4t.sisge.util.Sessao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class SisgeControl {

	private EnumTela tela;
	private EnumAcao acao;
	protected Sessao sessao;

	protected final String msgIncluidoSucesso = "Inclusão realizada com Sucesso!";
	protected final String msgAlteradoSucesso = "Alteração realizada com sucesso!";
	protected final String msgExcluidoSucesso = "Exclusão realizada com Sucesso!";

	public SisgeControl() {
		mostrarTelaListar();
	}

	public String telaListar() {
		try {
			atualizarListaEntidades();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro inesperado do sistema!", "Comunique ao analista!"));
		}
		mostrarTelaListar();
		return null;
	}

	protected abstract void atualizarListaEntidades() throws Exception;

	protected abstract void criarEntidade();

	public abstract String getTitulo();

	public String telaIncluir() {
		criarEntidade();
		mostrarTelaIncluir();
		return null;
	}

	public String telaAlterar() {
		mostrarTelaAlterar();
		return null;
	}

	public String telaConsultar() {
		mostrarTelaConsultar();
		return null;
	}

	protected void addMensagemInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
	}

	protected void addMensagemAviso(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, ""));
	}

	protected void addMensagemErro(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
	}

	protected void addMensagemErroFatal(Throwable e) {
		e.printStackTrace();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro inesperado no sistema! Comunique ao analista.", ""));
	}

	protected void mostrarTelaListar() {
		tela = EnumTela.INICIO;
		acao = null;
	}

	protected void mostrarTelaAlterar() {
		tela = EnumTela.CADASTRO;
		acao = EnumAcao.A;
	}

	protected void mostrarTelaIncluir() {
		tela = EnumTela.CADASTRO;
		acao = EnumAcao.I;
	}

	protected void mostrarTelaConsultar() {
		tela = EnumTela.CADASTRO;
		acao = EnumAcao.C;
	}

	public boolean isEhTelaListar() {
		return tela == EnumTela.INICIO;
	}

	public boolean isEhTelaCadastro() {
		return tela == EnumTela.CADASTRO;
	}

	public boolean isEhAcaoIncluir() {
		return acao == EnumAcao.I;
	}

	public boolean isEhAcaoAlterar() {
		return acao == EnumAcao.A;
	}

	public boolean isEhAcaoConsultar() {
		return acao == EnumAcao.C;
	}

	public EnumAcao getAcao() {
		return acao;
	}

	public void setAcao(EnumAcao acao) {
		this.acao = acao;
	}

	public EnumTela getTela() {
		return tela;
	}

	public void setTela(EnumTela tela) {
		this.tela = tela;
	}

}
