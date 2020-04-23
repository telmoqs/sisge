package in.a4t.sisge.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("sessao")
@Scope("session")
public class Sessao implements Filter {
	public static final String NOME_BEAN = "sessao";

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		Sessao sessao = (Sessao) session.getAttribute(Sessao.NOME_BEAN);
		if (sessao == null) {
			sessao = new Sessao();
			session.setAttribute(Sessao.NOME_BEAN, sessao);
		}

		filter.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}