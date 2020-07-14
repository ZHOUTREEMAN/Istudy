package com.xmu.istudy.util;

import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

//@Getter
//@Setter
public class JwtUtils {
    //签名私钥
    private String key="userlogin";
    //签名失效时间
    private Long failureTime= Long.valueOf(3600000);

    /**
     * 设置认证token
     *
     * @param id      用户id
     * @param subject 用户类型
     * @param map     其他私有数据
     * @return
     */
    public String createJwt(String id, String subject, Map<String, Object> map) {

        //1、设置失效时间啊
        long now = System.currentTimeMillis();  //毫秒
        long exp = now + failureTime;

        //2、创建JwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject)
                .setIssuedAt(new Date())
                //设置签名防止篡改
                .signWith(SignatureAlgorithm.HS256, key);

        //3、根据map设置claims
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(exp));

        //4、创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 判断是否具有权限
     * @param request
     * @return
     */
    public static boolean ifauthz(HttpServletRequest request, String type)
    {
        //获取请求头信息：名称=Authorization(前后端约定)
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            //系统未捕捉到请求头信息
            return false;
        }
        //替换Bearer+空格
        String token = authorization.replace("Bearer ", "");
        JwtUtils jwtUtils=new JwtUtils();
        //解析token
        Claims claims = jwtUtils.parseJwt(token);
        //获取clamis
        String usertype = claims.getSubject();
        if(type==usertype)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}