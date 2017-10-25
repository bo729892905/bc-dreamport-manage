package com.dreamport.controller.service;

import com.dreamport.domain.Log;
import org.springframework.stereotype.Service;

/**
 * Created by ren.xiaobo on 2017/8/9.
 */
@Service
public class LogService {
    public int insert(Log log){
        log.setId(200L);
        return log.getId().intValue();
    };
}
