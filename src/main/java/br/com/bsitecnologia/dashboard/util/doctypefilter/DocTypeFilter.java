package br.com.bsitecnologia.dashboard.util.doctypefilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class DocTypeFilter implements Filter {

	public FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getContentType() == null){
			System.out.println("########### entrou no filtro content type == null");
			PrintWriter out = response.getWriter();
			CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
			chain.doFilter(request, wrapper);
			String modifiedHtml = "<!DOCTYPE HTML>"+wrapper.toString();
			response.setContentLength(modifiedHtml.getBytes().length);
			out.write(modifiedHtml);
			out.close();
		}else{
			System.out.println("########### entrou no filtro content type == null");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
