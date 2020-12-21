package com.jinhuiqian.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 231
 * @date 2020-12-09 0:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneBindDto {
    private String wxOpenId;
    private String phone;
    private String code;
}
