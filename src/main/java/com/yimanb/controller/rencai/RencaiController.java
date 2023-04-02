package com.yimanb.controller.rencai;

import com.yimanb.common.result.Result;
import com.yimanb.common.result.ResultCodeEnum;
import com.yimanb.entity.rencai.Expert;
import com.yimanb.entity.rencai.Unit;
import com.yimanb.entity.user.User;
import com.yimanb.service.rencai.RencaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/rencai")
public class RencaiController {

    @Autowired
    private RencaiService rService;

    /**
     * 企事业单位申请认证
     * 注册用户 并返回token
     * @param unit 企事业单位实体类
     * @return objectResult
     */
    @RequestMapping(value="/unitApprove.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> unitApprove(Unit unit, User user){
        //添加企事业单位申请记录
        Result<Object> objectResult;
        try{
            objectResult=rService.addUnitApprove(unit,user);
        }catch(Exception e){
            return Result.fail(e.getMessage(),ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        return objectResult;
    }

    /**
     * 外籍专家申请认证
     * 注册用户 并返回token
     * @param expert 专家实体类
     * @return objectResult
     */
    @RequestMapping(value="/expertApprove.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> expertApprove(Expert expert, User user){
        //添加企事业单位申请记录
        Result<Object> objectResult;
        try{
            objectResult=rService.addExpertApprove(expert,user);
        }catch(Exception e){
            return Result.fail(e.getMessage(),ResultCodeEnum.ARGUMENT_VALID_ERROR);
        }
        return objectResult;
    }

    /**
     * 企事业单位申请查看专家信息
     * @param token 外企专家token
     * @return objectResult
     */
    @RequestMapping(value="/unitApply.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> unitApply(String token,Integer eid){
        //添加企事业单位申请记录
        return null;
    }

}
