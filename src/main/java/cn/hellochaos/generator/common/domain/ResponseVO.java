package cn.hellochaos.generator.common.domain;

import cn.hellochaos.generator.common.enums.ResponseCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @Filename ResponseVO
 * @Author chengk
 * @Description
 * @Date 2020/5/27  10:05
 */
@Data
public class ResponseVO<T> extends BaseVO {

    @ApiModelProperty(value = "成功标志",position = 0)
    private boolean success = false;

    /** 返回码 **/
    @ApiModelProperty(value = "返回码", notes = "成功-200",required = true,example = "200",position = 0)
    private Integer code;

    /** 返回描述 **/
    @ApiModelProperty(value = "返回描述",required = true,example = "responseOK",position = 1)
    private String message;

    /** 返回业务对象 **/
    @ApiModelProperty(value = "返回对象,code=200返回",required = false, position = 2)
    private T data;

    /** 构造 **/
    public ResponseVO() {
        code = ResponseCodeEnum.SUCCESS.getCode();
        success = true;
        message = ResponseCodeEnum.SUCCESS.getMessage();
    }

    /**************** 返回成功静态方法 **************************/
    /**
     * 返回200成功
     *
     * @return
     */
    public static ResponseVO responseOK() {
        return responseOK(null);
    }

    /**
     * 根据传入的值判断是返回成功还是失败，一般用于数据库的delete、update、insert语句的返回
     * @param code
     * @return
     */
    public static ResponseVO response(Integer code) {
        return code==1?responseOK(null):responseFail();
    }

    public static ResponseVO response(Boolean isOk) {
        return isOk?responseOK():responseFail();
    }
    /**
     * 返回200成功，带消息
     *
     * @return
     */
    public static ResponseVO responseOK(String msg) {
        return responseOK(null, msg);
    }

    public static <T> ResponseVO<T> responseOK(T data) {
        return responseOK(data, null);
    }


    public static <T> ResponseVO<T> responseOK(T data, String msg) {
        ResponseVO resultVO = new ResponseVO();
        resultVO.setData(data);
        resultVO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        msg = msg == null ? ResponseCodeEnum.SUCCESS.getMessage() : msg;
        resultVO.setMessage(msg);
        return resultVO;
    }

    /**************** 返回失败静态方法 **************************/

    /**
     * 返回400错误
     * @return
     */
    public static ResponseVO responseFail() {
        return responseFail(ResponseCodeEnum.BAD_REQUEST);
    }

    /**
     * 返回500，带消息
     * @param msg
     * @return
     */
    public static ResponseVO responseFail(String msg) {
        return responseFail(ResponseCodeEnum.BAD_REQUEST, msg);
    }

    public static ResponseVO responseFail(ResponseCodeEnum responseCodeEnum) {
        return responseFail(responseCodeEnum, responseCodeEnum.getMessage());
    }

    public static ResponseVO responseFail(ResponseCodeEnum responseCodeEnum, String msg) {
        ResponseVO resultVO = new ResponseVO();
        resultVO.setCode(responseCodeEnum.getCode());
        msg = msg == null ? responseCodeEnum.getMessage() : msg;
        resultVO.setMessage(msg);
        resultVO.setSuccess(false);
        return resultVO;
    }
}
