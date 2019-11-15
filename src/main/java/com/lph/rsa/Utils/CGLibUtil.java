package com.lph.rsa.Utils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;


/**
 * CGLib动态类的生成,进行方法的增强
 * @author: lph
 * @date:  2019/11/15 14:14
 * @version V1.0
 */
public class CGLibUtil {

    public static Enhancer interceptor(Class clz, boolean useCache, final String methodCode) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setUseCache(useCache);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                if (Objects.equals(methodCode, method.getName())) {
                    System.err.println("方法前的处理,方法名为：【" + methodCode + "】");
                    return methodProxy.invokeSuper(o, objects);
                }
                return null;
            }
        });

        return enhancer;

    }
}
