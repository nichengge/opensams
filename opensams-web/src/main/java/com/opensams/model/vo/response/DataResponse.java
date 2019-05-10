package com.opensams.model.vo.response;

import java.util.List;

/**
 * 数据响应对象
 * "T" 的类型为 VO 对象，且必须实现 {@link java.io.Serializable} 接口
 * @author Kevin Leung
 */
public class DataResponse<T> extends BasicResponse{

    private List<T> data;

    public DataResponse(List<T> data) {
        this.data = data;
    }

    public DataResponse(String code, String messgae, List<T> data) {
        super(code, messgae);
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
