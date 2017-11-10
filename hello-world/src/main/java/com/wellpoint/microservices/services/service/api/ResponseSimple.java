package com.wellpoint.microservices.services.service.api;

import java.io.Serializable;
import java.util.Optional;

public class ResponseSimple implements Serializable {

    transient private static final long serialVersionUID = 5106222175899418836L;
    private ResponseInfo responseInfo = new ResponseInfo();

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    @Override
    public String toString() {
        return Optional.of(responseInfo).map(ri -> ri.toString()).orElse("");
    }

}