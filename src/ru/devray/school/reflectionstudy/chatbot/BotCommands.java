package ru.devray.school.reflectionstudy.chatbot;

public class BotCommands {

    @Command(mainCommand = "weather", russianAlias = "погода")
    public void getWeatherData(){
        System.out.println("Its 23 degrees Celsium");
    }

    @Command(mainCommand = "howareu", russianAlias = "привет")
    public void replyToGreeting(){
        System.out.println("I'm good, thank you!");
    }

    @Command(mainCommand = "exit", russianAlias = "выход")
    public void exit(){
        System.exit(0);
    }

    @Command(mainCommand = "help", russianAlias = "помощь")
    public void printHelp(){
        System.out.println("This is a simple chat bot. You can try and greet him! To exit - call exit command.");
    }

}
