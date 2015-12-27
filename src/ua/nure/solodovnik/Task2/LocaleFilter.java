package ua.nure.solodovnik.Task2;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebFilter(filterName="localeFilter", urlPatterns = {"/*"})
public class LocaleFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(LocaleFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("currentLocale") == null) {
			Locale locale = request.getLocale();
			if (locale == null) {
				locale = Locale.getDefault();
			}
			session.setAttribute("currentLocale", locale.getLanguage());
		}	
		LOG.info("current locale ==> " + session.getAttribute("currentLocale"));
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}