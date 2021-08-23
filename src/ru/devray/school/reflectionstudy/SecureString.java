package ru.devray.school.reflectionstudy;

public class SecureString {
    public int magicNumber = 9898;
    private String secret;

    public SecureString() {
        this.secret = "You will never get me!";
    }

    private SecureString(String secret) {
        this.secret = secret;
    }

    private String getSecretString(){
        System.err.println("Access violation! No one should access secret string.");
        return this.secret;
    }

    private static String getSecretString(String inputParameter){
        System.out.println("hello from static");
        return "static data";
    }

    @Override
    public String toString() {
        return "SecureString{" +
                "magicNumber=" + magicNumber +
                ", secret='" + secret + '\'' +
                '}';
    }
}
