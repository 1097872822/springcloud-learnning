package com.rrw.donate.common;

import lombok.Data;

import javax.print.attribute.standard.PrinterURI;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:21
 */
@Data
public class Result<T> {
    private Integer code;
    private  String msg;

    private T data;
    public Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
    public static Result getSuccess(){
        return new Result(200,"成功");
    }
    public static Result getFailure(){
        return new Result(400,"失败");
    }

}
