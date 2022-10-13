//package com.bikego.messagecenter.utils;
//
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.util.Date;
//import java.util.HashMap;
//
//public class JwtUtil {
//    /**
//     * 过期时间为一天
//     */
//    private static final long EXPIRE_TIME = 24*60*60*1000;
//
//    /**
//     * token私钥
//     */
//    private static final String TOKEN_SECRET = "com_chinaso_youngservices_appstore_common_util_JwtUtil";
//
//    /**
//     * 生成签名,15分钟后过期
//     * @param username
//     * @param userId
//     * @return
//     */
//    public static String sign(String username,String userId){
//        //过期时间
//        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//        //私钥及加密算法
//        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//        //设置头信息
//        HashMap<String, Object> header = new HashMap<>(2);
//        header.put("typ", "JWT");
//        header.put("alg", "HS256");
//        //附带username和userID生成签名
//        return JWT.create().withHeader(header).withClaim("loginName",username)
//                .withClaim("userId",userId).withExpiresAt(date).sign(algorithm);
//    }
//
//
//    public static boolean verity(String token){
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            DecodedJWT jwt = verifier.verify(token);
//            String loginName = jwt.getClaim("loginName").asString();
//            String userId = jwt.getClaim("userId").asString();
//
//            Date expiresAt = jwt.getExpiresAt();
//            Date currentDate = new Date();
//            if (currentDate.getTime() > expiresAt.getTime()) {
//                return false;
//            }
//
//            return true;
//        } catch (IllegalArgumentException e) {
//            return false;
//        } catch (JWTVerificationException e) {
//            return false;
//        }
//
//    }
//
//    public static String userSign(String mobile,String userId){
//        //过期时间
//        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//        //私钥及加密算法
//        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//        //设置头信息
//        HashMap<String, Object> header = new HashMap<>(2);
//        header.put("typ", "JWT");
//        header.put("alg", "HS256");
//        //附带username和userID生成签名
//        return JWT.create().withHeader(header).withClaim("mobile",mobile)
//                .withClaim("userId",userId).withExpiresAt(date).sign(algorithm);
//    }
//
//    public static String userSign(String mobile,String userId, long expireTime){
//        //过期时间
//        Date date = new Date(System.currentTimeMillis() + expireTime);
//        //私钥及加密算法
//        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//        //设置头信息
//        HashMap<String, Object> header = new HashMap<>(2);
//        header.put("typ", "JWT");
//        header.put("alg", "HS256");
//        //附带username和userID生成签名
//        return JWT.create().withHeader(header).withClaim("mobile",mobile)
//                .withClaim("userId",userId).withExpiresAt(date).sign(algorithm);
//    }
//
//    public static boolean userVerity(String token){
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            DecodedJWT jwt = verifier.verify(token);
//            String mobile = jwt.getClaim("mobile").asString();
//            String userId = jwt.getClaim("userId").asString();
//
//            Date expiresAt = jwt.getExpiresAt();
//            Date currentDate = new Date();
//            if (currentDate.getTime() > expiresAt.getTime()) {
//                return false;
//            }
//
//            return true;
//        } catch (IllegalArgumentException e) {
//            return false;
//        } catch (JWTVerificationException e) {
//            return false;
//        }
//
//    }
//
//    /**
//     * 解析token信息
//     */
//    public static HashMap useVerityInfo(String token){
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            DecodedJWT jwt = verifier.verify(token);
//            Date expiresAt = jwt.getExpiresAt();
//            Date currentDate = new Date();
//            if (currentDate.getTime() > expiresAt.getTime()) {
//                return null;
//            }
//            String mobile = jwt.getClaim("mobile").asString();
//            String userId = jwt.getClaim("userId").asString();
//            HashMap<String ,String> dataMap = new HashMap<>();
//            dataMap.put("mobilePhone",mobile);
//            dataMap.put("userId",userId);
//            return dataMap;
//        } catch (IllegalArgumentException e) {
//            return null;
//        } catch (JWTVerificationException e) {
//            return null;
//        }
//    }
//}
