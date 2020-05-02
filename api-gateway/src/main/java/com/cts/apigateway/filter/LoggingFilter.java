package com.cts.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
public class LoggingFilter extends ZuulFilter{

	private Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	//if the above method shouldFilter() return true then it invokes the run() method

	@Override
	public Object run() throws ZuulException {
		//httpserveletrequest contains the get post ... service methods
		//request context contains the state,request , responce and data for zuul filter to share and access
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		this.logger.info("Zuul Intercepts : " + request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
