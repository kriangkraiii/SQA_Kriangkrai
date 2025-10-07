package main;

public class UserWhiteboard {
	
	private final String userId;
    private String content;

    protected UserWhiteboard(String userId) {
        this.userId = userId;
        this.content = "Initial content set by system.";
        System.out.println("Whiteboard created for User: " + userId);
    }

    public String getUserId() {
        return userId;
    }

    public void addContent(String text) {
        this.content += "\n[User " + userId + "]: " + text;
        System.out.println("Content updated on whiteboard for " + userId);
    }
    
    public String getContent() {
        return "--- Whiteboard for User " + userId + " ---\n" + this.content;
    }

    @Override
    public String toString() {
        return "UserWhiteboard{userId='" + userId + "', hashCode=" + System.identityHashCode(this) + "}";
    }

}
