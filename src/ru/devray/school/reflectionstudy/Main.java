package ru.devray.school.reflectionstudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        SecureString secureString = new SecureString();

        Arrays.stream(secureString.getClass().getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("=====");
        Arrays.stream(secureString.getClass().getConstructors()).forEach(System.out::println);

        Constructor constructor = SecureString.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        SecureString constructedObject = (SecureString) constructor.newInstance("argument for constructor");
        System.out.println(constructedObject);
    }

    public static void checkPrivateMethods() throws Exception{
        SecureString secureString = new SecureString();

        //all access modifiers  everything that belongs to this class
        Method[] methods = secureString.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Method publicMethod = secureString.getClass().getDeclaredMethod("getSecretString", String.class);
        publicMethod.setAccessible(true);
        publicMethod.invoke(SecureString.class, "fdsf");
    }

    public static void checkPrivateField() throws Exception{
        SecureString secureString = new SecureString();

        System.out.println(secureString.toString());

        Field magicNumberField = SecureString.class.getDeclaredField("secret");
        magicNumberField.setAccessible(true);
        magicNumberField.set(secureString, "my custom string");
        System.out.println((String) magicNumberField.get(secureString));

        System.out.println(secureString.toString());
    }
}
