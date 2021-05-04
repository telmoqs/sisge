package in.a4t.sisge.controle;

import in.a4t.sisge.enumeradores.EnumAcao;
import in.a4t.sisge.enumeradores.EnumSimNao;
import in.a4t.sisge.enumeradores.EnumTela;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("ControleEnumerador")
@Scope("session")
public class ControleEnumerador {

	public List<EnumAcao> getListaEnumAcao() {
		List<EnumAcao> retorno = new ArrayList<EnumAcao>();
		for (EnumAcao enumerador : EnumAcao.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumSimNao> getListaEnumSimNao() {
		List<EnumSimNao> retorno = new ArrayList<EnumSimNao>();
		for (EnumSimNao enumerador : EnumSimNao.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumTela> getListaEnumTela() {
		List<EnumTela> retorno = new ArrayList<EnumTela>();
		for (EnumTela enumerador : EnumTela.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

}