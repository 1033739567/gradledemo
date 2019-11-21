package cn.chenlilin.entity.result;

/**
 * @ClassName Msg
 * @Description TODO
 * @Author pc
 * @Date 2019/6/24 15:19
 * @Version 1.0
 * @company 百事贝集团
 * 百事贝集团版权所有
 * 注意：本内容仅限于百事贝集团内部传阅，禁止外泄以及用于其他的商业目的
 */

public class Result<T> {

    /*错误码*/
    private String code;

    /*提示信息 */
    private String msg;

    /*具体内容*/
    private  T data;

    public Result() {
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}