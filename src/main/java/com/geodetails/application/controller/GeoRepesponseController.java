package com.geodetails.application.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import com.geodetails.application.model.ResponseModel;
import com.geodetails.application.service.GeoRepesponseService;

@RestController
public class GeoRepesponseController {
	Logger logger = LoggerFactory.getLogger(GeoRepesponseController.class);
	
	
	@Autowired
	GeoRepesponseService geoRepesponseService;

	@Value("${geoapp.errormsg}")
	String errorMsg;

	@RequestMapping(path = "/geocode", method = RequestMethod.GET)
	public CompletableFuture<ResponseModel> getGeoDetails(@RequestParam String ip) {
      logger.info("Request received");
	  CompletableFuture<ResponseModel> completableFuture =
		      CompletableFuture.supplyAsync(new Supplier<ResponseModel>() {
		          @Override
		          public ResponseModel get() {
		              return geoRepesponseService.processRequest(ip);
		          }
		      }).completeOnTimeout(handleTimeoutException(), 1,TimeUnit.SECONDS);
	  
      logger.info("Servlet thread released");
	  return completableFuture;
	}
	
	ResponseModel handleTimeoutException() {
		ResponseModel responseModel =new ResponseModel();
		responseModel.setResCode(404);
		responseModel.setResMsg("Error ");
		return responseModel;
	}
}