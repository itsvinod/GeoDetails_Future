package com.geodetails.application.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.management.timer.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.geodetails.application.model.ResponseModel;
import com.geodetails.application.model.ResultsWrapperModel;

@Service
public class GeoRepesponseService {

	Logger logger = LoggerFactory.getLogger(GeoRepesponseService.class);

	@Value("${mockservice.url}")
	String mockserviceUrl;

	public ResponseModel processRequest(String ip) {
		ResponseModel responseModel = new ResponseModel();
		RestTemplate restTemplate = new RestTemplate();
		String resMsg = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> inpt = new HashMap<String, String>();
		inpt.put("ip", ip);
		logger.info("9.49 mockserviceUrl={}  ip={}", mockserviceUrl, ip);

		if ("192.168.1.20".equals(ip)) {
			logger.info(" null...");
			Map nl = null;
			nl.clear();
		} else if ("192.168.1.21".equals(ip)) {
			logger.info(" sleep...");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ResponseEntity<ResultsWrapperModel> responseEntity = restTemplate.postForEntity(mockserviceUrl, inpt,
				ResultsWrapperModel.class);
		ResultsWrapperModel responseResultModel = responseEntity.getBody();
		logger.info("responseResultModel=" + responseResultModel.getResults());
		String addrs[] = null;
		if (responseResultModel.getResults() != null && responseResultModel.getResults().length > 0) {
			if (responseResultModel.getResults()[0].getFormattedAddressLines() != null
					&& responseResultModel.getResults()[0].getFormattedAddressLines().length > 2) {
				addrs = responseResultModel.getResults()[0].getFormattedAddressLines();
				resMsg = addrs[0] + "," + addrs[1] + "," + addrs[2];
				responseModel.setResCode(201);
				responseModel.setResMsg(resMsg);
			} else {
				responseModel.setResCode(HttpStatus.NOT_FOUND.value());
				responseModel.setResMsg("No Full Data Found");
			}
		} else {
			responseModel.setResCode(HttpStatus.NOT_FOUND.value());
			responseModel.setResMsg("No Data Found");
		}
		logger.info("resMsg={}", resMsg);
		responseModel.setResCode(201);
		return responseModel;
	}
}