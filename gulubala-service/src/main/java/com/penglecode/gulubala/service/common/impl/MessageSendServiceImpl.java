package com.penglecode.gulubala.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.cache.ValidateCodeCacheManager;
import com.penglecode.gulubala.common.support.Messages;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.CommonValidateUtils;
import com.penglecode.gulubala.common.util.JavaMailUtils;
import com.penglecode.gulubala.common.util.RandomUtils;
import com.penglecode.gulubala.common.util.SmsUtils;
import com.penglecode.gulubala.service.common.MessageSendService;

@Service("messageSendService")
public class MessageSendServiceImpl implements MessageSendService {

	@Resource(name="validateCodeCacheManager")
	private ValidateCodeCacheManager validateCodeCacheManager;

	public String sendMessageBySms4Register(String mobilePhone) {
		ValidationAssert.notEmpty(mobilePhone, "手机号码不能为空!");
		ValidationAssert.isTrue(CommonValidateUtils.isMobilePhone(mobilePhone), "手机号码不合法!");
		String validateCode = RandomUtils.randomNumberCode(6);
		String message = Messages.getMessage("message.validatecode.register", validateCode);
		SmsUtils.sendMessage(mobilePhone, message);
		validateCodeCacheManager.setCache(mobilePhone, validateCode);
		return validateCode;
	}

	public String sendMessageByEmail4Register(String email) {
		ValidationAssert.notEmpty(email, "Email不能为空!");
		ValidationAssert.isTrue(CommonValidateUtils.isEmail(email), "Email不合法!");
		String validateCode = RandomUtils.randomNumberCode(6);
		String message = Messages.getMessage("message.validatecode.register", validateCode);
		JavaMailUtils.sendTextMail(email, "注册验证码", message);
		validateCodeCacheManager.setCache(email, validateCode);
		return validateCode;
	}
	
	
}
