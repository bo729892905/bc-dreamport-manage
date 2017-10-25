package com.dreamport.controller.aop;


import com.dreamport.annotation.OperateLog;
import com.dreamport.common.log.LogManager;
import com.dreamport.controller.common.log.LogTaskFactory;
import com.dreamport.controller.service.LogService;
import com.dreamport.domain.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ren.xiaobo on 2017/8/79.
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final LogService logService;

    @Autowired
    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @AfterReturning("@annotation(operateLog)")
    public void doAround(JoinPoint joinPoint, OperateLog operateLog) throws Throwable {
        logger.info("==> 记录日志....");
        try {
            handle(joinPoint, operateLog);
        } catch (Exception e) {
            logger.error("创建日志失败！", e);
        }
    }

    private void handle(JoinPoint point, OperateLog operateLog) throws Exception {
        logService.insert(new Log());
        LogManager.getInstance().executeLog(LogTaskFactory.bussinessLog(operateLog.type().value(), "测试", 1L, ""));
    }
}
