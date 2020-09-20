package ysu.edu.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse {

    @ApiModelProperty(example="200")
    private Integer code;
    @ApiModelProperty(example="data")
    private Object data;
    @ApiModelProperty(example="操作成功")
    private String message;

    public static ServerResponse success(Object data) {
        ResponseState state = ResponseState.SUCCESS;
        return new ServerResponse(state.getCode(), data, state.getMsg());
    }

    public static ServerResponse success(Object data, String msg) {
        ResponseState state = ResponseState.SUCCESS;
        return new ServerResponse(state.getCode(), data, msg);
    }

    public static ServerResponse failed(ResponseState state) {
        return new ServerResponse(state.getCode(), null, state.getMsg());
    }

    public static ServerResponse failed(ResponseState state, String msg) {
        return new ServerResponse(state.getCode(), null, msg);
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
