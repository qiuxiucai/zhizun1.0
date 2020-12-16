package com.ruoyi.project.staff.message.domain;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author wuxx
 */
@Data
public class StaffDetail {

    /**
     * 细节主键
     */
    private Long dId;

    /**
     * 性别 1是男性 2是女性
     */
    private Integer dSex;

    /**
     * 生日
     */
    private LocalDate dBirth;

    /**
     * 学历
     */
    private String dEdu;

    /**
     * 专业
     */
    private String dMajor;

    /**
     * 工作年限
     */
    private Integer dYear;

    /**
     * 政治面貌
     */
    private String dFace;

    /**
     * 籍贯
     */
    private String dPlace;

    /**
     * 邮箱
     */
    private String dEmail;

    /**
     * 地址
     */
    private String dAddress;

    /**
     * 头像
     */
    private String dAvatar;

    /**
     * 外键(员工主键)
     */
    private Long sId;
}
