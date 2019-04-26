package com.xuxx.ss.service.impl;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xuxx.ss.service.OneService;
import com.xuxx.ss.service.TwoService;

@org.apache.dubbo.config.annotation.Service(interfaceClass = OneService.class)
@Service("oneService")
public class OneServiceImpl implements OneService {
	private final static Logger logger = LoggerFactory.getLogger(OneServiceImpl.class);

	@Reference(check = false)// 设置启动不检查是否存在
	private TwoService twoService;

	@Override
	public String doOne(String s) {
		logger.debug("oneservice invoke,s: " + s);

		String twoResult = "";
		try {
			twoResult = twoService.doTwo(s);
		} catch (Exception e) {
			e.printStackTrace();
			twoResult = "twoservice invoke fail!";
		}

		return "oneservice invoke success!" + twoResult;
	}

}
