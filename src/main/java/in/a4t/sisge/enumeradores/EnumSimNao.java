package in.a4t.sisge.enumeradores;

public enum EnumSimNao implements Enumerador {

	SIM("S", "Sim"), 
	NAO("N", "Não");

	private final String abreviado;
	private final String descricao;

	private EnumSimNao(String abreviado, String descricao) {
		this.abreviado = abreviado;
		this.descricao = descricao;
	}

	public String getAbreviado() {
		return abreviado;
	}

	public String getDescricao() {
		return descricao;
	}

}