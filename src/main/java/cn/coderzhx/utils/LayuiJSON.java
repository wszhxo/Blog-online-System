package cn.coderzhx.utils;

import net.sf.json.JSONObject;

/**
 * @author zhx
 *
 *
 * @create 2019-07-27-20
 */
public class LayuiJSON {
    //Layui返回格式的封装类
    public static String jsonStr(String msg,int count,Object data)  {
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", msg);
        obj.put("count",count);
        obj.put("data",data);
        return obj.toString();
    }

    //Shiro返回格式封装类
    public static String jsonStr(boolean success,String msg)  {
        JSONObject obj = new JSONObject();
        obj.put("msg", msg);
        obj.put("success",success);
        return obj.toString();
    }
    //markdown图片上传
    public static String jsonImg(int success,String msg,String url)  {
        JSONObject obj = new JSONObject();
        obj.put("success",success);
        obj.put("msg", msg);
        obj.put("url", url);
        return obj.toString();
    }
}
