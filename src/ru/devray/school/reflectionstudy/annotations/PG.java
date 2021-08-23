package ru.devray.school.reflectionstudy.annotations;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PG {

    String field;

    public static void main(String[] args) throws Exception {
        PG pg = new PG();


    }

    public PG() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for(Method method:methods){
            MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
            if (annotation != null){
                System.out.println(annotation.name());
                try {
                    method.invoke(this);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @MyAnnotation(name = "method to be automatically called")
    public void method(){
        System.out.println("yay");
    }

    @MyAnnotation
    public void anotherMethod(){
        System.out.println("sdf");
    }

}
