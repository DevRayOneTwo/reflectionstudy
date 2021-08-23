package ru.devray.school.reflectionstudy.chatbot;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        BotCommands commands = new BotCommands();

        while(true){
            String userInput = sc.nextLine();
            Method[] methods = commands.getClass().getDeclaredMethods();
            for(Method method:methods){
                Annotation[] methodAnnotations = method.getDeclaredAnnotations();
                for (Annotation annotation:methodAnnotations) {
                    if (annotation.annotationType() == Command.class){
                        String command = ((Command) annotation).mainCommand();
                        String commandAlias = ((Command) annotation).russianAlias();

                        if (userInput.toLowerCase().equals(command) || userInput.toLowerCase().equals(commandAlias)){
                            try {
                                method.invoke(commands);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
