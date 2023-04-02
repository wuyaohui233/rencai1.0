package com.yimanb.entity.rencai;

import lombok.Data;

/**
 * 企事业单位申请表
 */
@Data
public class ReleaseApply {
        /**
         * id
         */
        private Integer id;

        /**
         * 企业id
         */
        private Integer uid;

        /**
         * 专家id
         */
        private Integer eid;

        /**
         * 专家是否同意
         */
        private String eAgree;

        /**
         * 管理员是否同意
         */
        private String rAgree;

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
