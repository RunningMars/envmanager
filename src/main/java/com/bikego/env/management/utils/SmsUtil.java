//package com.bikego.messagecenter.utils;
//
//import cn.hutool.http.HttpUtil;
//import com.alibaba.fastjson.JSONObject;
//import com.chinaso.youngservices.appstore.common.exception.Code;
//import com.chinaso.youngservices.appstore.common.exception.CommonException;
//import com.chinaso.youngservices.appstore.common.model.dto.AppUserInfoDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.util.*;
//
///**
// * 短信 邮箱操作相关工具
// * Created by Sun JinShuang on 2020/9/30.
// */
//
//public class SmsUtil {
//
//    private final static Logger logger = LoggerFactory.getLogger(SmsUtil.class);
//
//    //app发送短信验证码接口地址
//    private static String appCodeUrl = "http://appapitest.chinaso.com/young/v2/user/usercenter/passport/sendSmsCodeForClient";
//
//    //app短信验证码登录接口地址
//    private static String appValidCodeUrl = "http://appapitest.chinaso.com/young/v2/user/usercenter/passport/smsLogin";
//
//    //后台管理发送短信验证码
//    private static String codeUrl = "http://appapitest.chinaso.com/young/v2/user/sms/third/sendsms";
//
//    //绑定邮件接口地址
//    private static String emsUrl = "http://appapitest.chinaso.com/young/v2/user/mail/third/sendmail";
//
//
//    private static String auth = "3c751jyfqv715r9b5y023m63ir967382";
//
//    private static String emailAuth = "96jgvj5426w3f95lirg372d965l4mkj6";
//
//    private static HashMap<String, String> headers ;
//
//    static {
//        headers = new HashMap<>();//存放请求头，可以存放多个请求头
//        headers.put("user-agent", "Young/3.1.2(com.chinaso.so; hypad)");
//        headers.put("Content-Type", "application/json");
//        headers.put("Accept-Charset", "UTF-8");
//    }
//    /**
//     * 根据手机号获取之前得到的验证码
//     * @Author: sun JinShuang
//     * @Date: 2020/9/29
//     */
//    public static String getVerifyCode(String phone) {
//        // redis 中获取验证码
//
//        return "123456";
//    }
//
//    /**
//     * app验证码登录接口
//     * @Author: sun JinShuang
//     * @Date: 2020/9/29
//     */
//    public static AppUserInfoDTO validCodeLogin(String phone, String code) {
//        /*if(!code.equals(getVerifyCode(phone))){ //测试使用固定验证码
//            return true;
//        }*/
//        Map<String,Object> paramsMap = new HashMap<String,Object>();
//        paramsMap.put("phone",phone);
//        paramsMap.put("smsCode",code);
//        String resultStr = "";
//        //{  "status": 0,"msg": "操作成功!","data": {} }
//        try{
//            resultStr = HttpUtil.createPost(appValidCodeUrl)
//                    .addHeaders(headers)
//                    .body(JSONObject.toJSONString(paramsMap))
//                    .execute().body();  //请求接口
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new CommonException(Code.INTERFACE_CALL_EXCEPTION,"第三方接口异常!");
//        }
//        logger.info(resultStr);
//        JSONObject jsonResult= JSON.parseObject(resultStr);
//        int status = jsonResult.getIntValue("status");
//        if(status == 100001 ){ // 第三方接口异常
//            throw new CommonException(Code.INTERFACE_CALL_EXCEPTION,jsonResult.getString("msg"));
//        }else if(status != 0){  // 验证失败
//            throw new CommonException(Code.VERIFY_CODE_ERROR,jsonResult.getString("msg"));
//        }
//        //JSONObject datas = jsonResult.getJSONObject("data");
//        String data = jsonResult.getString("data");
//        AppUserInfoDTO userInfoDTO = JSONObject.parseObject(data,AppUserInfoDTO.class);
//        userInfoDTO.getUserInfo().setNick(decode(userInfoDTO.getUserInfo().getNick()));
//        return userInfoDTO;
//    }
//
//    public static void SendVerifyCode(String mobile, String code) {
//        return;
//    }
//
//    /**
//     * app请求接口发送短信验证码
//     * @Author: sun JinShuang
//     * @Date: 2020/10/13
//     */
//    public static void sendAppVerifyCode(String mobile) {
//        String resultStr = "";
//        try{
//            resultStr = HttpUtil.get(appCodeUrl + "?phone=" + mobile);  //请求接口
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new CommonException(Code.INTERFACE_CALL_EXCEPTION,"第三方接口异常!");
//        }
//        logger.info(resultStr);
//        //解析参数 正常返回值{ "status": 0, "msg": "操作成功!", "data": {} }
//        //status:0 操作成功  1301 手机号为空  1302 手机号格式错误  1315 验证码错误次数过多，请于 3 小时后再试  1313 发送失败
//        JSONObject jsonResultStr = JSON.parseObject(resultStr);
//        int status = jsonResultStr.getIntValue("status");
//        if(status != 0){  // 发送失败
//            throw new CommonException(Code.CODE_SEND_ERROR,jsonResultStr.getString("msg"));
//        }
//        return;
//    }
//
//    /**
//     * 后台管理\开发者平台 请求接口发送短信验证码
//     * @Author: sun JinShuang
//     * @Date: 2020/10/13
//     */
//    public static void sendSmsCode(String mobile,int smsCode) {
//        Map<String,Object> paramsMap = new HashMap<String,Object>();
//        paramsMap.put("phone",mobile);
//        paramsMap.put("sendContent","您好，您的登录验证码是" + smsCode +",五分钟内有效哦！");//短信内容
//        paramsMap.put("auth",auth); // 校验字符串
//        paramsMap.put("description","给用户发送短信验证码");//描述
//        String resultStr = "";
//        try{
//            resultStr = HttpUtil.createPost(codeUrl)
//                    .addHeaders(headers)
//                    .body(JSONObject.toJSONString(paramsMap))
//                    .execute().body();  //请求接口
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new CommonException(Code.INTERFACE_CALL_EXCEPTION,"第三方接口异常!");
//        }
//        logger.info("接口返回值：",resultStr);
//        JSONObject jsonResult= JSON.parseObject(resultStr);
//        int status = jsonResult.getIntValue("status");
//        if(status != 0){  // 验证失败
//            throw new CommonException(Code.CODE_SEND_ERROR,jsonResult.getString("msg"));
//        }
//    }
//
//    /**
//     * 发送邮件测试
//     * @Author: sun JinShuang
//     * @Date: 2020/10/13
//     */
//    public static void sendEmail(int code ,String receiveEmailUrl) {
//        Map<String,Object> paramsMap = new HashMap<String,Object>();
//        List<String> emailUrl = new ArrayList();
//        emailUrl.add(receiveEmailUrl);
//        paramsMap.put("receiveList", emailUrl);
//        paramsMap.put("sendTitle","花漾登录");//邮件标题
//        paramsMap.put("auth",emailAuth); // 校验字符串
//        paramsMap.put("sendContent","尊敬的用户您好，您正在进行花漾邮箱绑定，验证码是" + code + ",请在五分钟内正确输入哦！");//内容
//        String resultStr = "";
//        System.out.println(JSONObject.toJSONString(paramsMap));
//        try{
//            resultStr = HttpUtil.createPost(emsUrl)
//                    .addHeaders(headers)
//                    .body(JSONObject.toJSONString(paramsMap))
//                    .execute().body();  //请求接口
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new CommonException(Code.INTERFACE_CALL_EXCEPTION,"第三方接口异常!");
//        }
//        JSONObject jsonResult= JSON.parseObject(resultStr);
//        logger.info("接口返回值：",jsonResult);
//        int status = jsonResult.getIntValue("status");
//        if(status != 0){  // 验证失败
//            throw new CommonException(Code.CODE_SEND_ERROR,jsonResult.getString("msg"));
//        }
//    }
//
//    public static String decode(String str) {
//        if(StringUtils.isBlank(str)){
//            return "";
//        }
//        String str1 = "";
//        try {
//            str1 = URLDecoder.decode(str, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return str1;
//    }
//
//}
