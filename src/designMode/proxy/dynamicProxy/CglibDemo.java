package designMode.proxy.dynamicProxy;




import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDemo {

    // 功能增强的实现
    static class MyMethodInterceptor implements MethodInterceptor {
        private Object target;

        public MyMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

            System.out.println("**************** " + method.getName());
            // 前置增强
            doSomethingBefore();
            // 返回值
            Object res = null;
            // 调用父类的该方法，当是生成接口的代理时不可调用。
            // Object res = methodProxy.invokeSuper(proxy, args);
            // 通过method来调用被代理对象的方法
            if (this.target != null) {
                res = method.invoke(target, args);
            }
            // 后置增强
            doSomethingAfter();
            return res;
        }

        private void doSomethingBefore() {
            System.out.println("老板你好，这个我试过了，很不错，推荐给你！");
        }

        private void doSomethingAfter() {
            System.out.println("老板你觉得怎样？ 欢迎下次.....");
        }
    }

    public static void main(String[] args) {
        Enhancer e = new Enhancer();
        BusinessImpl tc = new BusinessImpl();
        // 设置增强回调
        e.setCallback(new MyMethodInterceptor(tc));
        // 获得接口代理对象
        e.setInterfaces(new Class[]{Business.class});
        Business proxy = (Business)e.create();
        proxy.doAction();

        // 对类生成代理对象
        e.setSuperclass(BusinessImpl.class);
        e.setInterfaces(null);
        BusinessImpl proxy1 = (BusinessImpl)e.create();
        proxy1.doAction();
    }
}
