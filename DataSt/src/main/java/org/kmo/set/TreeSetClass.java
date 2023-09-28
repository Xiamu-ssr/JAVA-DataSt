package org.kmo.set;

import org.junit.Test;
import org.kmo.utils.StudentCom;
import org.kmo.utils.StudentComp;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetClass {
    /**
     * TreeSet是基于红黑树的Set，具有排序特性
     * */
    @Test
    public void test01() {
        Set<Integer> set1 = new TreeSet<>();
        set1.add(6);
        set1.add(5);
        set1.add(5);
        set1.add(7);
        System.out.println(set1);
    }
    /**
     * 但是无法对自定义对象排序
     * <ol>
     *     <li>实现Comparable接口，重写compareTo方法制定比较规则</li>
     *     <ol>
     *         <li>已在Student类实现</li>
     *         <li>测试看Test02</li>
     *     </ol>
     *     <li>调用TreeSet集合的参数构造器，设置Comparator对象</li>
     *     <ol>
     *         <li>优先级高</li>
     *         <li>测试看Test03，Test04</li>
     *     </ol>
     * </ol>
     * */
    @Test
    public void test02(){
        Set<StudentComp> set2 = new TreeSet<>();
        set2.add(new StudentComp("至尊宝",28,178.4));
        set2.add(new StudentComp("之猪猪",20,165.1));
        set2.add(new StudentComp("矮人",20,167.2));
        set2.add(new StudentComp("紫霞",20,167.2));
        set2.add(new StudentComp("矮人",20,167.2));
        System.out.println(set2);
    }
    @Test
    public void test03(){
        Set<StudentCom> set2 = new TreeSet<>(new Comparator<StudentCom>() {
            @Override
            public int compare(StudentCom o1, StudentCom o2) {
                if (o1.age!=o2.age){
                    return Integer.compare(o1.age, o2.age);
                }else if (o1.height!=o2.height){
                    return Double.compare(o1.height, o2.height);
                }else{
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        set2.add(new StudentCom("至尊宝",28,178.4));
        set2.add(new StudentCom("之猪猪",20,165.1));
        set2.add(new StudentCom("矮人",20,167.2));
        set2.add(new StudentCom("紫霞",20,167.2));
        set2.add(new StudentCom("矮人",20,167.2));
        System.out.println(set2);
    }
    @Test
    public void test04(){
        Set<StudentCom> set2 = new TreeSet<>((o1, o2)->Double.compare(o1.height,o2.height));
        set2.add(new StudentCom("至尊宝",28,178.4));
        set2.add(new StudentCom("之猪猪",20,165.1));
        set2.add(new StudentCom("矮人",20,167.2));
        set2.add(new StudentCom("紫霞",20,167.2));
        set2.add(new StudentCom("矮人",20,167.2));
        System.out.println(set2);
    }
}