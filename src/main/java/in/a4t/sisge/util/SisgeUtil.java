package in.a4t.sisge.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SisgeUtil {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean ehVazio(String valor) {
		return valor == null || valor.trim().length() == 0;
	}

	public static String formatarData(Date data) {
		if (data != null) {
			return sdf.format(data);
		} else {
			return "";
		}
	}

}
