package cn.hellochaos.generator.common.enums;

import lombok.Getter;

/**
 * @Filename ResponseCodeEnum
 * @Author chengk
 * @Description 响应码枚举
 * @Date 2020/5/27  10:05
 */
@Getter
public enum ResponseCodeEnum {
    SUCCESS(200, "成功"),

    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "凭证无效,重新认证"),
    FORBIDDEN(403, "权限不足,禁止访问"),
    METHOD_NOT_ALLOWED(405, "请求方式不支持"),
    BAD_ARGUMENT(406, "参数不对"),
    BAD_ARGUMENT_VALUE(407, "参数值不对"),
    INTERNAL_SERVER_ERROR(500, "系统错误,请稍后再试或联系管理员"),
    NO_ALUMNI_USER_BY_OPEN_ID(600, "根据openId查无该校友,请先认证"),
    NO_DATA_WITH_IMPORT_AUTH_INFO(700, "导入失败！导入校友认证数据不能为空！"),
    NO_FULL_DATA_WITH_IMPORT_AUTH_INFO(700, "导入失败！请完善校友信息，再导入！");
    ;

    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}