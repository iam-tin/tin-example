package com.tin.example.cglib.design.pattern;

/**
 * title: SexEnum
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午10:25
 */
public enum SexEnum {
    MALE("MALE"),
    FEMALE("FEMALE");
    private String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }
}
