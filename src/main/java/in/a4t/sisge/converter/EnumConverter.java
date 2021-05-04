package in.a4t.sisge.converter;

import in.a4t.sisge.enumeradores.Enumerador;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "enumConverter")
public class EnumConverter implements Converter {
	private String valor;

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (valor == null) {
			valor = value;
		}
		if (valor != null) {
			return this.getAttributesFrom(component).get(valor);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {

		if (value != null && !"".equals(value)) {

			Enumerador enumerador = (Enumerador) value;

			this.addAttribute(component, enumerador);

			String codigo = enumerador.getAbreviado();
			if (codigo != null) {
				return codigo;
			}
		}

		return (String) value;
	}

	private void addAttribute(UIComponent component, Enumerador o) {
		String key = o.getAbreviado();
		this.getAttributesFrom(component).put(key, o);
	}

	private Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
