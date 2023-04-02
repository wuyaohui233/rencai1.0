package com.yimanb.service.rencai.impl;

import com.yimanb.common.result.Result;
import com.yimanb.common.result.ResultCodeEnum;
import com.yimanb.entity.rencai.Expert;
import com.yimanb.entity.rencai.Unit;
import com.yimanb.entity.user.User;
import com.yimanb.mapper.rencai.RencaiMapper;
import com.yimanb.mapper.user.UserMapper;
import com.yimanb.service.rencai.RencaiService;
import com.yimanb.util.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class RencaiServiceImpl implements RencaiService {

    @Autowired(required = false)
    private RencaiMapper rMapper;

    /**
     * 用户方法
     */
    @Autowired(required = false)
    private UserMapper uMapper;

    /**
     * 添加企业认证信息
     * @param unit
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Result<Object> addUnitApprove(Unit unit, User user) {

        //用户账号验证
        if(user.getName()==null||user.getName().equals("")) {
            throw new RuntimeException("请填写用户名");
        }
        if(user.getPassword()==null||user.getPassword().equals("")){
            throw new RuntimeException("请填写密码");
        }
        user.setType("企业");
        user.setStatus("待审核");
        Integer user_id = uMapper.InsertUser(user);

        //企业身份验证
        if(unit.getBusinessLicense()==null||unit.getBusinessLicense().equals("")){
            throw new RuntimeException("营业执照信息不完整");
        }
        if(unit.getFrontOfIdCard()==null||unit.getFrontOfIdCard().equals("")){
            throw new RuntimeException("身份证正面信息不完整");
        }
        if(unit.getBackOfIdCard()==null||unit.getBackOfIdCard().equals("")){
            throw new RuntimeException("身份证反面信息不完整");
        }
        if (unit.getProof()==null||unit.getProof().equals("")){
            throw new RuntimeException("纳税证明信息不完");
        }
        if(unit.getEnterpriseName()==null||unit.getEnterpriseName().equals("")){
            throw new RuntimeException("企业名称信息不完整");
        }
        if(unit.getUnitIntroduction()==null||unit.getUnitIntroduction().equals("")){
            throw new RuntimeException("单位简介信息不完整");
        }
        unit.setUser_id(user_id);

        //添加企事业单位
        Integer integer = rMapper.addUnit(unit);
        if(integer>0){
            //生成登录token
            String loginName = user.getName();
            String user_id_str = String.valueOf(user_id);
            String token = JwtUtil.sign(loginName, user_id_str, "专家");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("token",token);
            return Result.ok(map);
        }else{
            return Result.fail(ResultCodeEnum.FAIL);
        }

    }

    @Override
    public Result<Object> addExpertApprove(Expert expert, User user) {
        //用户账号验证
        if(user.getName()==null||user.getName().equals("")) {
            throw new RuntimeException("请填写用户名");
        }
        if(user.getPassword()==null||user.getPassword().equals("")){
            throw new RuntimeException("请填写密码");
        }
        user.setType("专家");
        user.setStatus("待审核");
        Integer user_id = uMapper.InsertUser(user);

        if(expert.getName()==null||expert.getName().equals("")){
            throw new RuntimeException("姓名信息不完整");
        }
        if(expert.getAge()==null){
            throw new RuntimeException("年龄信息不完整");
        }
        if(expert.getNationality()==null||expert.getNationality().equals("")){
            throw new RuntimeException("民族信息不完整");
        }
        if(expert.getCurrentWorkingUnit()==null||expert.getCurrentWorkingUnit().equals("")){
            throw new RuntimeException("现工作单位信息不完整");
        }
        if(expert.getPhotograph()==null||expert.getPhotograph().equals("")){
            throw new RuntimeException("照片信息不完整");
        }
        if(expert.getResume()==null||expert.getResume().equals("")){
            throw new RuntimeException("个人简历信息不完整");
        }
//        if(expert.getQualificationCertificate()==null||expert.getQualificationCertificate().equals("")){
//            return Result.fail("资质证书信息不完整",ResultCodeEnum.ARGUMENT_VALID_ERROR);
//        }
        if(expert.getPassport()==null||expert.getPassport().equals("")){
            throw new RuntimeException("护照信息不完整");
        }
        expert.setUser_id(user_id);

        Integer integer = rMapper.addExpert(expert);
        if(integer>0){
            //生成登录token
            String loginName = user.getName();
            String user_id_str = String.valueOf(user_id);
            String token = JwtUtil.sign(loginName, user_id_str, "专家");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("token",token);
            return Result.ok(map);
        }else{
            return Result.fail(ResultCodeEnum.FAIL);
        }

    }
}
