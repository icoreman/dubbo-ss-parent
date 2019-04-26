package com.xuxx.ss.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xuxx.ss.service.TwoService;

@org.apache.dubbo.config.annotation.Service(interfaceClass = TwoService.class)
@Service
public class TwoServiceImpl implements TwoService {
	private final static Logger logger = LoggerFactory.getLogger(TwoServiceImpl.class);

	@Override
	public String doTwo(String s) {
		logger.debug("TwoService invoke,s: " + s);

		return "twoservice invoke success!hello," + s;
	}

}
