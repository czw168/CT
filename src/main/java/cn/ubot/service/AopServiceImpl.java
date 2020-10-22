package cn.ubot.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateUtil;
import cn.ubot.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Service
@Slf4j
public class AopServiceImpl implements AopService {
	
	@Autowired
	private HttpServletRequest request;
	
	@Pointcut("execution(public * cn.ubot.service..*.*(..))")
    public void brokerAspect(){

    }
	
	@Override
	@Before("brokerAspect()")
	public void logInsert() {
		log.info(
				"==> 用户【" + SecurityUtils.getSubject().getPrincipal() + 
				"】\t时间【" + DateUtil.date() + 
				"】\tIP【" + request.getRemoteAddr() + 
				"】\tURL【" + request.getServletPath() + 
				"】\t数据源【" + DynamicDataSource.getCustomerType()
		);
	}
	
}
