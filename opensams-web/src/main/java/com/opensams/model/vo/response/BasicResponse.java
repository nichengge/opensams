package com.opensams.model.vo.response;

/**
 * @author Kevin Leung
 */
public class BasicResponse {

    private String code;

    private String messgae;

    public BasicResponse() {
    }

    public BasicResponse(String code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
