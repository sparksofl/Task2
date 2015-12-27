package ua.nure.solodovnik.Task2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

@WebFilter(filterName="encodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(EncodingFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("Encoding set");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}