package com.yimanb.mapper.rencai;

import com.yimanb.entity.rencai.Expert;
import com.yimanb.entity.rencai.Unit;
import org.apache.ibatis.annotations.Insert;

public interface RencaiMapper {

    /**
     * 添加企事业单位申请信息
     * @param unit
     * @return
     */
    @Insert("insert into rc_unit values(null,#{user_id},#{businessLicense},#{frontOfIdCard}," +
            "#{backOfIdCard},#{proof},#{enterpriseName},#{unitIntroduction},#{type}," +
            "#{status},now(),now())")
    Integer addUnit(Unit unit);


    @Insert("insert into rc_expert values(null,#{user_id},#{name},#{age}," +
            "#{nationality},#{currentWorkingUnit},#{photograph}," +
            "#{resume},#{qualificationCertificate},#{passport},#{status}" +
            ",#{type},now(),now())")
    Integer addExpert(Expert expert);
}
