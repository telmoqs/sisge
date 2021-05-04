package in.a4t.sisge.excessao;

@SuppressWarnings("serial")
public class DadosInvalidosException extends Exception {

	public DadosInvalidosException() {
		super("Erro ao alterar o registro");
	}

	public DadosInvalidosException(String mensagem) {
		super(mensagem);
	}

	public DadosInvalidosException(Exception e) {
		super(e.getMessage());
	}

}
