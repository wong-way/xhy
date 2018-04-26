package scu.edu.cn.util;

/**
 * @author 黄伟
 * dto返回信息
 * @param <T> 泛型
 */
public class Response<T> {
    Error error;
    T data;

    public Response() {
    }

    public Response(Error error, T data) {
        this.error = error;
        this.data = data;
    }

    public Response(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
