package Acquire;

public class PlayerDoesntExistException extends Exception{
    public PlayerDoesntExistException(String message) {
        super(message);
    }
}
