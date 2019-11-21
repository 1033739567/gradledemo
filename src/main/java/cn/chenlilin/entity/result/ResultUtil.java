package cn.chenlilin.entity.result;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author pc
 * @Date 2019/6/24 15:20
 * @Version 1.0
 * @company 百事贝集团
 * 百事贝集团版权所有
 * 注意：本内容仅限于百事贝集团内部传阅，禁止外泄以及用于其他的商业目的
 */

public class ResultUtil {
    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result msg=new Result();
        msg.setCode("200");
        msg.setMsg("success");
        msg.setData(object);
        return msg;
    }
    public static Result success(){
        return success(null);
    }

    public static Result error(String code, String resultmsg){
        Result msg=new Result();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }
}
