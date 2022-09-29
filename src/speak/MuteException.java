package speak;

public class MuteException extends Exception {
    private Person person;

    public MuteException(Person person) {
        super();
        this.person = person;
    }

    public MuteException(Person person, String msg) {
        super(msg);
        this.person = person;
    }

    @Override
    public String getMessage() {
        return person.getNm() + " is mute";
    }
}
