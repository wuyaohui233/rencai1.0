package com.yimanb.entity.rencai;

import lombok.Data;

/**
 * 外籍专家实体类
 */
@Data
public class Expert {
        private static final long serialVersionUID = 1L;
        /**
         * id
         */
        private Integer id;

        /**
         * 用户id
         */
        private Integer user_id;

        /**
         * 姓名
         */
        private String name;

        /**
         * 年龄
         */
        private Integer age;

        /**
         * 国籍
         */
        private String nationality;

        /**
         * 现工作单位
         */
        private String currentWorkingUnit;

        /**
         * 照片
         */
        private String photograph;

        /**
         * 个人简历
         */
        private String resume;

        /**
         * 资质证书
         */
        private String qualificationCertificate;

        /**
         * 护照
         */
        private String passport;

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
