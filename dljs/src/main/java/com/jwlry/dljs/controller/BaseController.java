package com.jwlry.dljs.controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.service.BaseService;

public abstract class BaseController<T> {
	private final Logger log = Logger.getLogger(this.getClass());

	private BaseService<T> baseService;
	private HttpRequest httpRequest;
	private HttpResponse httpResponse;

	public BaseController(BaseService<T> baseService) {
		super();
		this.baseService = baseService;
	}

	private void log(String line) {
		log.info(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	private void logErr(String line) {
		log.error(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	@GetMapping("/query/all")
	public ApiResponse<List<T>> get() {
		return baseService.getAll();
	}

	@PostMapping("/create")
	public ApiResponse<T> create(@RequestBody T entity/*
														 * , @RequestParam("workflow") final String workflow,
														 * 
														 * @RequestParam("conf") final String
														 * confValue, @RequestParam("dc") final String dc
														 */, HttpServletRequest request) {

		log("In create()");

		TimeZone timezone = RequestContextUtils.getTimeZone(request);
		log("entity : " + entity);
		/*
		 * log("workflow : " + workflow); log("confValue : " + confValue); log("dc" +
		 * dc);
		 */
		log("request.getRemoteAddr() : " + request.getRemoteAddr());
		log("request.getRemoteHost() : " + request.getRemoteHost());
		log("request.getLocalAddr() : " + request.getLocalAddr());
		log("request.getLocalName() : " + request.getLocalName());
		log("request.getServerName() : " + request.getServerName());
		log("timezone : " + timezone);
		

		return baseService.create(entity);
	}

	@PostMapping("/modify")
	private ApiResponse<T> modify(@RequestBody T entity) {
		return baseService.modify(entity);

	}

}
