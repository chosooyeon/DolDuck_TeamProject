package com.my.test.freeboard.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
	//Filter가 먼저 출력되는 이유는 클라이언트에서 서버로 넘어갈 때 중간에 filter가 있기때문이고 
	//response될 때 출력이 안되는 이유는 처음 request할때 response할것까지한번에 수행해서 그렇다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String RemoteAddr = StringUtils.defaultString(req.getRemoteAddr()); //클라이언트IP
		//0:0:0:0:0:0:0:1 IPv6의 형태로 ip값을 반환 클라이언트의 ip
		String uri = StringUtils.defaultString(req.getRequestURI());
		// /mvc/detail.do
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		//http://localhost:8787/mvc/detail.do
		String queryString = StringUtils.defaultString(req.getQueryString());
		// ("?"string)+ id= ??
		String referer = StringUtils.defaultString(req.getHeader("referer")); // 전페이지.
		// http://localhost:8787/mvc/list.do 현재 요청된 페이지의 링크 이전의 웹 페이지 주소를 포함
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		//Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)  User와 Agent의 os및 브라우저 등 의 정보를 파싱하여 보여줌
		
		StringBuffer result = new StringBuffer();
		result.append(" | ")
			.append(RemoteAddr)
			.append(uri)
			.append("(")
			.append(url)
			.append("")
			.append("?"+queryString)
			.append(")")
			.append(referer)
			.append(" | ")
			.append(agent);
		logger.info("LOG FILTER "+result.toString());
		chain.doFilter(req, response);
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
