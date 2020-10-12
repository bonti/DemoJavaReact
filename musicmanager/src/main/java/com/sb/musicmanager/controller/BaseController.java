package com.sb.musicmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.response.bean.StatusBean;

public class BaseController {

	
	protected ResponseEntity<ResponseWrapper> getResponseEntity (ResponseWrapper responseWrapper) {

		StatusBean statusBean = responseWrapper.getStatusBean();
		if (statusBean == null || statusBean.getHttpStatusCode() < 100) {
			throw new IllegalArgumentException("StatusBean must Not be null and have valid Http Status in ResponseWrapper!");
		}

		return new ResponseEntity<>(responseWrapper, HttpStatus.valueOf(statusBean.getHttpStatusCode()));
	}

}
