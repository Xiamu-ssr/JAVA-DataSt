package org.kmo.d09_Proxy.Test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star createProxy(BigStar bigStar){
        Star starProxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sing")){
                    System.out.println("准备场地，收钱200w");
                }else if (method.getName().equals("dance")){
                    System.out.println("准备场地，收钱100w");
                }
                return method.invoke(bigStar, args);
            }
        });
        return starProxy;
    }
}
