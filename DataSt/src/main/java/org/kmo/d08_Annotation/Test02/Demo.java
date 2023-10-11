package org.kmo.d08_Annotation.Test02;

/**
 * <h2>解析注解的案例，具体需求如下：</h2>
 * <ol>
 *     <li>
 *         定义注解MyTest4，要求如
 *         <ol>
 *          <li>包含属性：String value()</li>
 *          <li>包含属性: double aaa()，默认值为 100</li>
 *          <li>包含属性： String[] bbb()</li>
 *          <li>限制注解使用的位置:类和成员方法上</li>
 *          <li>指定注解的有效范围：一直到运行时</li>
 *         </ol>
 *     </li>
 *     <li>定义一个类叫: Demo,在类中定义一个test1方法，并在该类和其方法上使用MyTest4注解</li>
 *     <li>定义AnnotationTest3测试类,解析Demo类中的全部注解。</li>
 * </ol>
 * */

@MyTest4(value = "vv",aaa = 99.9, bbb={"b","bb","bbb"})
public class Demo {

    @MyTest4(value = "我是至尊宝",aaa = 100.9, bbb = {"小淇","爱你"})
    public void test01(){

    }
}
