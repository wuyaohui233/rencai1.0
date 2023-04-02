package com.yimanb.entity.rencai;

import lombok.Data;

/**
 * 企事业单位实体类
 */
@Data
public class Unit {
        /**
         * id
         */
        private Integer id;

        /**
         * 用户id
         */
        private Integer user_id;

        /**
         * 营业执照
         */
        private String businessLicense;

        /**
         * 身份证正面
         */
        private String frontOfIdCard;

        /**
         * 身份证背面
         */
        private String backOfIdCard;

        /**
         * 纳税证明
         */
        private String proof;

        /**
         * 企业名称
         */
        private String enterpriseName;

        /**
         * 单位简介
         */
        private String unitIntroduction;

        /**
         * 类型
         */
        private String type;

        /**
         * 状态
         */
        private String status;

        /**
         * 日期
         */
        private String dataDate;

        /**
         * 时间
         */
        private String dataTime;
}
