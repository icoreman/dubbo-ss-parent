package com.xuxx.ss.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ss.service.OneService;

@RestController
public class SSController {

	@Reference(check = false)
	public OneService oneService;

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String Hello(@PathVariable String name) {
		String ret_msg;
		try {
			ret_msg = oneService.doOne(name);
		} catch (Exception e) {
			e.printStackTrace();
			ret_msg = "出错啦！";
		}
		return ret_msg;
	}
}
