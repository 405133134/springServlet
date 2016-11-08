package cn.enn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	public static void main(String[] args) {
		RealSubject realSubject=new RealSubject();
		InvocationHandler handler=new ProxyHandler(realSubject);
		Subject proxyInstance = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				realSubject.getClass().getInterfaces(),
				handler);
		proxyInstance.doSomething();
		
	}
	
}
