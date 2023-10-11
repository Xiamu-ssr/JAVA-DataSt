package org.kmo.d08_Annotation.Test01;

public @interface MyAnnotation {
    String aaa();
    boolean bbb() default true;
    String[] ccc();
}
