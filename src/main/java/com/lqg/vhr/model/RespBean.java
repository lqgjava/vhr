package com.lqg.vhr.model;

/**
 * @author : 李清钢
 * @date : 2020-03-19 17:58
 * 自己定义的返回的类
 **/
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean build() {
        return new RespBean();
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    private RespBean() {
    }

    //成功的只需要说一个msg
    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }

    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }

    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }
}
