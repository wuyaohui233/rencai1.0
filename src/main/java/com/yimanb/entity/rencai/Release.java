package com.yimanb.entity.rencai;

import lombok.Data;

/**
 * 需求发布表
 */
@Data
public class Release {

        private static final long serialVersionUID = 1L;

        /**
         * id
         */
        private Integer id;

        /**
         * 企业id
         */
        private Integer uid;

        /**
         * 岗位
         */
        private String post;

        /**
         * 技能
         */
        private String skill;

        /**
         * 学历
         */
        private String educationalBackground;

        /**
         * 福利待遇
         */
        private String welfareTreatment;

        /**
         * 企业简介
         */
        private String enterpriseProfile;

        /**
         * 状态
         */
        private String status;

        /**
         * 类型
         */
        private String type;

        /**
         * 日期
         */
        private String dataDate;

        /**
         * 时间
         */
        private String dataTime;
}
