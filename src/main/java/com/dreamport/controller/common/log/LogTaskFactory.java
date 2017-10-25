package com.dreamport.controller.common.log;

import com.dreamport.common.log.factory.LogFactory;
import com.dreamport.controller.service.LogService;
import com.dreamport.domain.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

/**
 * Created by ren.xiaobo on 2017/8/9.
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogTaskFactory.class);

    @Autowired
    private static LogService logService;

    public static TimerTask bussinessLog(final String logType, final String logName, final Long userId, final String remark) {
        return new TimerTask() {
            @Override
            public void run() {
                Log log = LogFactory.createOperateLog(logType, logName, userId, remark);
                try {
                    int result = logService.insert(log);
                    if (result < 0) {
                        logger.error("创建业务日志失败！");
                    }
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }
}
