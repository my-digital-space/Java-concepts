package com.demo.Logging.config;

import com.demo.Logging.dto.MyBookRequestDto;
import org.slf4j.MDC;

import java.util.UUID;

public class LogContext {

    private static final String TRACE_ID = "traceId";
    private static final String REQUEST_PATH = "requestPath";
    private static final String CLIENT_IP = "clientIp";
    private static final String CALLER_ID = "callerId";

    private static final String BOOK_NAME = "bookName";
    private static final String METHOD = "method";

    public static void clearLogContext() {
        MDC.clear();
    }

    public static void updateRequestContext(String path, String clientIp,
                                            String callerId, String traceId) {
        if (null == traceId) {
            traceId = UUID.randomUUID().toString();
        }
        MDC.put(TRACE_ID, traceId);
        MDC.put(REQUEST_PATH, path);
        MDC.put(CLIENT_IP, clientIp);
        MDC.put(CALLER_ID, callerId);
    }

    public static void createBook(MyBookRequestDto bookRequestDto) {
        MDC.put(BOOK_NAME, bookRequestDto.getBookName());
        MDC.put(METHOD, "createBook");
    }

    public static void getBook(String bookName) {
        MDC.put(BOOK_NAME, bookName);
        MDC.put(METHOD, "getBook");
    }

}
