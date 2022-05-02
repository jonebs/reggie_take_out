package cn.ggb.reggie.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class R<T> {
    //状态码
    private Integer code;
    //信息
    private String msg;
    //数据
    private T data;
    //动态数据
    private Map map = new HashMap();

    public static <T> R<T> success(T object){
        R<T> r = new R<>();
        r.setCode(ResultCode.SUCCESS);
        r.data = object;
        return r;
    }

    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.setCode(ResultCode.ERROR);
        r.setMsg(msg);
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
