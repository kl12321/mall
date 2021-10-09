package com.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="数据封装对象",description = "封装返回的数据")
public class ResultVo {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("返回的对象")
    private Object object;
}
