package com.han.utils;

import com.alibaba.fastjson.JSON;

/**
 *常用字符处理
 */
public class StringUtil {

    private static  StringUtil stringUtil;

    private StringUtil() {
    }

    public static StringUtil getStringUtil(){
        if(stringUtil==null){
            stringUtil=new StringUtil();
        }
        return stringUtil;
    }

    /**
     * 将对象进行JSON化
     */
    public String toJSON(Object obj){
        if (obj==null){
            return null;
        }
        /*将JAVA对象转为JSON对象*/
        String stringJson= JSON.toJSONString(obj);
        return stringJson;
    }
}
