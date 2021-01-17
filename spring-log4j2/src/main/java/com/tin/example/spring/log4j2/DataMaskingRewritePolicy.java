package com.tin.example.spring.log4j2;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedMessage;

/**
 * title: DataMaskingRewritePolicy
 * <p>
 * description: 修改logEvent，定制日志内容打码
 *
 * @author tin @看点代码再上班 on 2021/1/16 下午4:16
 */
@Plugin(name = "DataMaskingRewritePolicy", category = "Core",
        elementType = "rewritePolicy", printObject = true)
public final class DataMaskingRewritePolicy implements RewritePolicy {
    private static final String OVERLAY = "*************";
    private static final int START_EXCLUDE = 3;
    private static final int END_INCLUDE = 16;
    private static final int BAND_ACCOUNT_LEN = 19;

    @Override
    public LogEvent rewrite(LogEvent logEvent) {
        if (!(logEvent instanceof Log4jLogEvent)) {
            return logEvent;
        }
        Log4jLogEvent log4jLogEvent = (Log4jLogEvent) logEvent;

        Message message = log4jLogEvent.getMessage();
        if (!(message instanceof ParameterizedMessage)) {
            return logEvent;
        }
        ParameterizedMessage parameterizedMessage = (ParameterizedMessage) message;

        //遍历日志参数
        Object[] params = parameterizedMessage.getParameters();
        if (params == null || params.length <= 0) {
            return logEvent;
        }
        Object[] newParams = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            Object object = params[i];
            if (object instanceof String) {
                String obj = (String) object;
                if (StringUtils.isNumeric(obj) && obj.length() == BAND_ACCOUNT_LEN) {
                    newParams[i] = StringUtils.overlay(obj, OVERLAY, START_EXCLUDE, END_INCLUDE);
                    continue;
                }
                newParams[i] = obj;
            }
        }

        //重置message对象
        ParameterizedMessage m = new ParameterizedMessage(
                parameterizedMessage.getFormat(),
                newParams,
                parameterizedMessage.getThrowable());
        Log4jLogEvent.Builder builder = log4jLogEvent.asBuilder().
                setMessage(m);
        return builder.build();
    }


    @PluginFactory
    public static DataMaskingRewritePolicy createPolicy() {
        return new DataMaskingRewritePolicy();
    }
}
