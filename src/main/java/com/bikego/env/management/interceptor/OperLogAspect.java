//package com.bikego.messagecenter.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 操作日志记录处理
// *
// * @author ruoyi
// */
//@Aspect
//@Component
//public class OperLogAspect{
//    private static final Logger log = LoggerFactory.getLogger(OperLogAspect.class);
//
//    @Autowired
//    private SysOperLogService sysOperLogService;
//
//    @Autowired
//    private AdminUserService adminUserService;
//
//    // 配置织入点
//    @Pointcut("@annotation(com.chinaso.youngservices.appstore.admin.interceptor.annotation.OperLog)")
//    public void logPointCut() {}
//
//    /**
//     * 前置通知 用于拦截操作
//     *
//     * @param joinPoint 切点
//     */
//    @AfterReturning(pointcut = "logPointCut()")
//    public void doBefore(JoinPoint joinPoint)
//    {
//        handleLog(joinPoint, null);
//    }
//
//    /**
//     * 拦截异常操作
//     *
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(value = "logPointCut()", throwing = "e")
//    public void doAfter(JoinPoint joinPoint, Exception e)
//    {
//        handleLog(joinPoint, e);
//    }
//
//    protected void handleLog(final JoinPoint joinPoint, final Exception e){
//        try {
//            // 获得注解
//            OperLog controllerLog = getAnnotationLog(joinPoint);
//            if (controllerLog == null){
//                return;
//            }
//            // *========数据库日志=========*//
//            SysOperLog operLog = new SysOperLog();
//            operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
//            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//            // 请求的地址
//            String ip = IPUtils.getIpAddr(request);
//            operLog.setOperIp(ip);
//            //请求Url
//            operLog.setOperUrl(request.getRequestURI());
//            // 获取当前的用户
//            String token = request.getHeader("token");
//            HashMap<String,String> data = JwtUtil.useVerityInfo(token);
//            Long userId = Long.valueOf(data.get("userId"));
//            AdminUser adminUser = adminUserService.getAdminUserInfoById(userId);
//            if (adminUser != null){
//                operLog.setOperName(adminUser.getName());
//                operLog.setOperUserId(adminUser.getUid());
//            }
//            if (e != null) {
//                operLog.setStatus(BusinessStatus.FAIL.ordinal());
//                operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
//            }
//            // 设置方法名称
//            String className = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            operLog.setMethod(className + "." + methodName + "()");
//            // 处理设置注解上的参数
//            getControllerMethodDescription(controllerLog, operLog,request);
//            // 保存数据库
//            operLog.setOperTime(new Date());
//            sysOperLogService.saveLog(operLog);
//        } catch (Exception exp) {
//            // 记录本地异常日志
//            log.error("==前置通知异常==");
//            log.error("异常信息:{}", exp.getMessage());
//            exp.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取注解中对方法的描述信息 用于Controller层注解
//     *
//     * @return 方法描述
//     * @throws Exception
//     */
//    public void getControllerMethodDescription(OperLog log, SysOperLog operLog, HttpServletRequest request) throws Exception {
//        // 设置action动作
//        operLog.setBusinessType(log.businessType().ordinal());
//        // 设置标题
//        operLog.setName(log.title());
//        // 是否需要保存request，参数和值
//        if (log.isSaveRequestData()) {
//            // 获取参数的信息，传入到数据库中。
//            Map<String, String[]> map = request.getParameterMap();
//            String params = JSONObject.toJSONString(map);
//            operLog.setOperParam(StringUtils.substring(params, 0, 255));
//        }
//    }
//
//    /**
//     * 是否存在注解，如果存在就获取
//     */
//    private OperLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
//        //从切面织入点处通过反射机制获取织入点处的方法
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        //获取切入点所在的方法
//        Method method = methodSignature.getMethod();
//        if (method != null) {
//            return method.getAnnotation(OperLog.class);
//        }
//        return null;
//    }
//}
