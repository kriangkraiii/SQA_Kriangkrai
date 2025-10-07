package main;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class WhiteboardManager {

    private static final WhiteboardManager INSTANCE = new WhiteboardManager();

    private WhiteboardManager() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }
    }

    public static WhiteboardManager getInstance() {
        return INSTANCE;
    }
    
    private final Map<String, UserWhiteboard> userWhiteboards = new ConcurrentHashMap<>();

    public UserWhiteboard getWhiteboardForUser(String userId) {
        return userWhiteboards.computeIfAbsent(
            userId, 
            k -> new UserWhiteboard(userId)
        );
    }
	
    public int getTotalWhiteboardCount() {
        return userWhiteboards.size();
    }
}
