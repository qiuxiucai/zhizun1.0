package com.ruoyi.project.staff.message.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author wuxx
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StaffDetail extends Staff{

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dBirth;

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
