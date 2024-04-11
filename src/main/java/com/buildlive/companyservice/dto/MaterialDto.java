package com.buildlive.companyservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {

    private String name;
    private String unit;
    private Double gst;
}
