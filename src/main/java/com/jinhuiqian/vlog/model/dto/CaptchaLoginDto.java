package com.jinhuiqian.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 231
 * @date 2020-12-11 9:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaptchaLoginDto {
    private String phone;
    private String password;
    private String captcha;
}
