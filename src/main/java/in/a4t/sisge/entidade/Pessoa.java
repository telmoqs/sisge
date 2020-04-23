package in.a4t.sisge.entidade;

import in.a4t.sisge.enumeradores.EnumSimNao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorPessoa")
	@SequenceGenerator(name = "geradorPessoa", sequenceName = "gerador_pessoa", allocationSize = 1, initialValue = 1)
	private Integer id;

	private boolean cadastroAtivo = true;
	private String senha;
	private String email;
	private Date dataUltimoAcesso;
	private Date dataSenha = new Date();
	private Date dataCadastro = new Date();

	@Enumerated(EnumType.STRING)
	private EnumSimNao permitirEnvioEmail = EnumSimNao.SIM;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataSenha() {
		return dataSenha;
	}

	public void setDataSenha(Date dataSenha) {
		this.dataSenha = dataSenha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public EnumSimNao getPermitirEnvioEmail() {
		return permitirEnvioEmail;
	}

	public void setPermitirEnvioEmail(EnumSimNao permitirEnvioEmail) {
		this.permitirEnvioEmail = permitirEnvioEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}