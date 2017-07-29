package controllers;

/**
 * Created by igor on 29.07.2017.
 */
public class CurrentState {
    private final long id;
    private final String content;

    public CurrentState(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {

        return id;
    }

    public String getContent() {
        return content;
    }
}
