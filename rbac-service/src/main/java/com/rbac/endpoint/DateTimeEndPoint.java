package com.rbac.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * /actuator/datetime
 */
@Endpoint(id = "datetime")
public class DateTimeEndPoint {

    private String pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 显示监控指标
     * @return
     */
    @ReadOperation
    public Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();
        info.put("author", "geekymv");
        info.put("datetime", new SimpleDateFormat(pattern).format(new Date()));
        return info;
    }

    /**
     * 动态改变pattern值 使用POST方式
     * @param pattern
     */
    @WriteOperation
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
