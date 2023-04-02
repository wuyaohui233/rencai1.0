package com.yimanb.service.rencai;

import com.yimanb.common.result.Result;
import com.yimanb.entity.rencai.Expert;
import com.yimanb.entity.rencai.Unit;
import com.yimanb.entity.user.User;

public interface RencaiService {

     Result<Object> addUnitApprove(Unit unit, User user);

     Result<Object> addExpertApprove(Expert expert,User user);
}
