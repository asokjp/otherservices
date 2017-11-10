package com.wellpoint.microservices.services.service.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseInfo implements Serializable {

    public static final Integer CODE_OK = 0;
    public static final String DESC_OK = "No error";

    public static final Integer CODE_ERROR = 1;
    public static final String DESC_ERROR = "Error";

    transient private static final long serialVersionUID = -7495659571563736846L;

    private Integer code;
    private String description;
    private Map<String, String> additionalInfo = new HashMap<String, String>();

    public ResponseInfo() {
        super();
    }

    public ResponseInfo(Integer code, String description) {
        this();
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[CODE]:").append(code);
        sb.append("|[DESC]:").append(description);
        return sb.toString();
    }

}
