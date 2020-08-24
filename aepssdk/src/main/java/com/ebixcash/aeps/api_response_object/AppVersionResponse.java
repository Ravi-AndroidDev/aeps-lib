package com.ebixcash.aeps.api_response_object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="appversionResponse")
public class AppVersionResponse {

    @Element(name="sessionId", required=false)
    private String sessionId;

    @Element(name="deviceId", required=false)
    private String deviceId;

    @Element(name="username", required=false)
    private String username;

    @Element(name="requestType", required=false)
    private String requestType;

    @Element(name="isWebview", required=false)
    private String isWebview;

    @Element(name="responseCode", required=false)
    private String responseCode;

    @Element(name="responseDesc", required=false)
    private String responseDesc;

    @Element(name="androidVersion", required=false)
    private String androidVersion;

    @Element(name="iosVersion", required=false)
    private String iosVersion;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getIsWebview() {
        return isWebview;
    }

    public void setIsWebview(String isWebview) {
        this.isWebview = isWebview;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getIosVersion() {
        return iosVersion;
    }

    public void setIosVersion(String iosVersion) {
        this.iosVersion = iosVersion;
    }
}
