package com.yimanb.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.yimanb.util.token.JwtUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@CrossOrigin
@Controller
@RequestMapping("/uploadFile")
public class UploadController {
	
	@PostMapping(value="/uploadFiles.do",produces={"text/html;charset=utf-8"})
	@ResponseBody    //表示返回到前端的是json對象
	public String uploadHearing(@RequestParam("file") MultipartFile[] files,String token,String path,String type) throws Exception {
		Map<String,Object> json = new HashMap<String,Object>();
		
//		验证登录状态
		boolean verify = JwtUtil.verify(token);
		if(!verify || !JwtUtil.getUserType(token).equals("root")) {
			json.put("code", 201);
			json.put("msg", "无权访问或账号已过期！");
			return JSON.toJSONString(json);
		}
		
		//定义我们的命名空间,所有的文件都可以上传在这之下   File.separator 根据系统打不同的斜杠
		//linux上阿德部署路径
		//String fileSpace=File.separator+"java_all"+File.separator+"workspace-wxxcs"+File.separator+"video-space"+File.separator+"admin-bgm";
		String fileSpace=path;
		//保存到数据库中的相对路径(在命名空间每个不同用户存的文件)
		String uploadPathDB="/bgm";//可修改为用户名

		String fileN = "";
	    FileOutputStream fileOutputStream=null;
	    InputStream inputStream=null;
		try {
			if(files!=null && files.length>0) {
			    //获取文件名
			    String fileName=files[0].getOriginalFilename();
			    if(StringUtils.isNotBlank(fileName)) {
			    	UUID uuid = UUID.randomUUID();
					String sound_src = uuid+"."+type;
					fileN = sound_src;
			    	//文件上传的最终保存路径
			    	String finalPath=fileSpace+uploadPathDB+"/"+sound_src;
			    	//设置数据库保存的路径
			    	uploadPathDB += ("/"+sound_src);
			    	
			    	File outFile = new File(finalPath);
			    	if(outFile.getParentFile()!=null ||!outFile.getParentFile().isDirectory()) {
			    		//创建父文件夹
			    		outFile.getParentFile().mkdirs();
			    	}
			    	//文件输出
			    	fileOutputStream = new FileOutputStream(outFile);
			    	inputStream = files[0].getInputStream();
			    	IOUtils.copy(inputStream, fileOutputStream);
			    }
			}else {
				json.put("code", 400);
				json.put("msg", "上传出错");
				return JSON.toJSONString(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("code", 400);
			json.put("msg", "上传出错");
			return JSON.toJSONString(json);
		}finally {
			if(fileOutputStream!=null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		//uploadPathDB
		json.put("code", 200);
		json.put("msg", "上传成功！");
		json.put("data", fileN);
		return JSON.toJSONString(json);
	}
	
}
