/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  NetUtils.java   
 * @Package com.chinaso.appstore.common.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 4, 2018 9:48:26 AM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**   
 * @ClassName:  NetUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Dec 4, 2018 9:48:26 AM   
 *     
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class NetUtils {

	public static String getLocalIp() {
        try {
            //一个主机有多个网络接口
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = netInterfaces.nextElement();
                //每个网络接口,都会有多个"网络地址",比如一定会有loopback地址,会有siteLocal地址等.以及IPV4或者IPV6    .
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    //get only :172.*,192.*,10.*
                    if (address.isSiteLocalAddress() && !address.isLoopbackAddress()) {
                        return address.getHostAddress();
                    }
                }
            }
        }catch (Exception e) {
            //
        }
        return "";
    }
}
