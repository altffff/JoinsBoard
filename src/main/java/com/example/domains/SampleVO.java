package com.example.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //모든속성을 사용하는 생성자 용
@NoArgsConstructor //비어있는 생성자 용
public class SampleVO {
    private Integer mno;
    private String firstName;
    private String lastName;

}
