package com.bikego.env.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.bikego.env.management.context.ThreadContext;
import com.bikego.env.management.domain.VariableEntity;
import com.bikego.env.management.service.VariableService;
import com.bikego.env.management.service.dto.VariableDto;
import com.bikego.env.management.utils.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    private VariableService variableService;

    @RequestMapping("/index")
//    @ResponseBody
    public String index1(String memberId) {
        Integer ss = 123;
        System.out.println("memberId=" + memberId);

        System.out.println("index0 envmagt");
        System.out.println("index1 envmagt");
        System.out.println("index2 envmagt");
        System.out.println("index3 envmagt");
        Integer ff = 53;
        System.out.println("index4 envmagt");
        System.out.println("index5 envmagt");
        return "envmagt env0";
    }
    /**
     * pc后台分页列表
     * @param params
     * @return
     */
    @RequestMapping("/api/variable/listPage")
    @ResponseBody
    public Object listPage(@RequestBody Map<String,Object> params)
    {
        System.out.println(params);

        int page = 1;

        int pageSize = 10;

        System.out.println("params.get(page_size)");

        System.out.println(params.get("page_size"));

        if( params.get("page_size") != null )
        {
            pageSize =Integer.parseInt(params.get("page_size").toString());
        }
        if( params.get("page") != null )
        {
            page =Integer.parseInt(params.get("page").toString());
        }

        if( page < 1 )
        {
            page = 1;
        }
        if( pageSize < 1 )
        {
            pageSize = 10;
        }

        String name = null;

        if( params.get("name") != null )
        {
            name = params.get("name").toString();
        }

        String env = null;

        if( params.get("env") != null )
        {
            env = params.get("env").toString();
        }

        System.out.println("name");
        System.out.println(name);
        System.out.println("env");
        System.out.println(env);

        Page<VariableEntity> variableEntityPage = variableService.getPageVariable(name,env,page,pageSize,Sort.Direction.ASC,"id");

        return variableEntityPage;
    }

    /**
     * pc后台新增变量,编辑变量
     * @param map
     * @return
     */
    @RequestMapping("/api/variable/add")
    @ResponseBody
    public Map<String,Object> add(@RequestBody Map<String, String> map) {

//        System.out.println(map);
        Object id = map.get("id");
        String msg = "";
        int code = 1;

        JSONObject authInfo = ThreadContext.get("authInfo");
        Timestamp currentTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
        System.out.println(authInfo);
        Map<String,Object> returnData = new HashMap<String,Object>();

        if( id != null )
        {
            VariableDto variableDto = variableService.info(Integer.parseInt(map.get("id")));
            if( !variableDto.name.equals(map.get("name")) || !variableDto.env.equals(map.get("env")) )
            {
                Boolean hasExist = this.hasExistVariable(map.get("name"),map.get("env"));
                if( hasExist )
                {
                    msg = "该name + env已存在,请勿重复写入";
                    code = 224;
                    returnData.put("msg",msg);
                    returnData.put("code",code);
                    return returnData;
                }
            }

            variableDto.name = map.get("name");
            variableDto.env = map.get("env");
            variableDto.value = map.get("value");
            variableDto.updatedBy = authInfo.getString("name");
            variableDto.updatedAt = currentTime;
            Boolean editRs =  this.variableService.add(variableDto);

            msg = editRs ? "编辑成功" : "编辑失败,请稍后重试";
            code = editRs ? 0 : 221;
            returnData.put("msg",msg);
            returnData.put("code",code);

        }else{
            Boolean hasExist = this.hasExistVariable(map.get("name"),map.get("env"));
            if( hasExist )
            {
                msg = "该name + env已存在,请勿重复写入";
                code = 224;
                returnData.put("msg",msg);
                returnData.put("code",code);
                return returnData;
            }
            VariableDto variableDto = new VariableDto();
            variableDto.createdBy = authInfo.getString("name");
            variableDto.createdAt = currentTime;
            variableDto.updatedBy = authInfo.getString("name");
            variableDto.updatedAt = currentTime;

            variableDto.name = map.get("name");
            variableDto.env = map.get("env");
            variableDto.value = map.get("value");

            Boolean addRs =   this.variableService.add(variableDto);

            msg = addRs ? "添加成功" : "添加失败,请稍后重试";
            code = addRs ? 0 : 221;
            returnData.put("msg",msg);
            returnData.put("code",code);
        }
        return returnData;
    }

    /**
     * description 环境变量是否重复
     * @param name
     * @param env
     * @return
     */
    private boolean hasExistVariable(String name ,String env)
    {

        List<VariableEntity> res = this.variableService.getVariable(name,env);

        return !res.isEmpty();
    }

    /**
     * 变量详情
     * @param map
     * @return
     */
    @RequestMapping("/api/variable/info")
    @ResponseBody
    public VariableDto info(@RequestBody Map<String, Integer> map) {

        System.out.println(map.get("id"));

        VariableDto variableDto = variableService.info(map.get("id"));

        return variableDto;

    }

    /**
     * description 用于发布系统
     * @param params
     * @return
     */
    @RequestMapping("/api/variable/list")
    @ResponseBody
    public JSON list(@RequestBody Map<String,Object> params) {

        List<VariableEntity> variableEntityList = queryVariable(params);

        Map<String, Object> data = new HashMap<>();

        for (VariableEntity item : variableEntityList) {
            data.put(item.getName(), (item.getValue() == null ? "" : item.getValue()));
        }

        JSON jp = new JSON();
        jp.put("code", 0);
        jp.put("msg", "success");
        jp.put("data", data);
        jp.put("success", true);
        return jp;
    }

    /**
     * 查询变量(用于发布环境变量)
     * @param params
     * @return
     */
    protected List<VariableEntity> queryVariable(Map<String,Object> params)
    {

        Object objectVars = params.get("vars");

        List<String> nameList = new ArrayList<>();

        if (objectVars instanceof ArrayList<?>) {
            for (Object o : (List<?>) objectVars) {
                nameList.add(String.class.cast(o));
            }
        }

        List<VariableEntity> variableEntityList = variableService.list(nameList, params.get("env").toString(),params.get("project").toString());

        return variableEntityList;
    }

}
