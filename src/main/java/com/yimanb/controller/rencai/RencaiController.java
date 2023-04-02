package com.yimanb.controller.rencai;

import com.alibaba.fastjson.JSON;
import com.yimanb.common.result.Result;
import com.yimanb.common.result.ResultCodeEnum;
import com.yimanb.entity.admin.Admin;
import com.yimanb.entity.rencai.Expert;
import com.yimanb.entity.rencai.Unit;
import com.yimanb.entity.user.User;
import com.yimanb.service.rencai.RencaiService;
import com.yimanb.util.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/rencai")
public class RencaiController {

    @Autowired
    private RencaiService rService;

    /**
     * 企事业单位申请认证
     * @param unit
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/unitApprove.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> unitApprove(Unit unit, User user) throws IOException {

        return null;
    }

    /**
     * 外籍专家申请认证
     * @param unit
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/expertApprove.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> expertApprove(Expert expert, User user) throws IOException {
        //添加企事业单位申请记录
        Result<Object> objectResult = rService.addExpertApprove(expert,user);
        return objectResult;
    }

    /**
     * 企事业单位申请查看专家信息
     * @param unit
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/unitApply.do",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> unitApply(String token,Integer eid) throws IOException {
        //添加企事业单位申请记录
        return null;
    }

}
