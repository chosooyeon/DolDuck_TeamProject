package com.my.dolduck.common.filter;

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
		
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//client랑 server를 묶어줘야한다...?
		HttpServletRequest req = (HttpServletRequest)request;
		//localhost여서  0:0:0:0:0:0:0:1 웹 서버로 정보를 요청한 웹 브라우저의 IP주소를 리턴한다. 
		String RemoteAddr = StringUtils.defaultString(req.getRemoteAddr());
		String uri = StringUtils.defaultString(req.getRequestURI());
		//웹 상에서 서비스를 제공하는 각 서버들에 있는 파일들의 위치를 표시하기 위한 것으로 접속할 서비스의 종류,도메인명,파일의 위치 등을 포함
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		//?id=11 부분의 queryString이 나온다.
		String queryString = StringUtils.defaultString(req.getQueryString());
		String referer = StringUtils.defaultString(req.getHeader("referer"));
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		
		StringBuffer result = new StringBuffer();
		result.append(" | ")
			  .append(RemoteAddr)			//ip(192.168.10.33) client의 ip
			  .append(uri)					//mvc/list.do
			  .append(" (")
			  .append(url)					//http://192.168.10.33:8787/mvc_up/detail.do
			  .append("")
			  .append("?"+queryString)
			  .append(") ")
			  .append(referer)
			  .append(" | ")
			  .append(agent);
		logger.info("LOG FILTER "+result.toString());
		
		//FilterChain 중간에서 request랑 request를 연결해준다.
		//client에서 요청이 들어와서 중간에 짤린 요청을 연결해주는 것
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
