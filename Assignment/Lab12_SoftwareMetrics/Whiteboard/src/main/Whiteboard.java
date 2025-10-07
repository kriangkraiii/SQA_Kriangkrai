package main;

public class Whiteboard {
	
public static void main(String[] args) {
        
        WhiteboardManager managerA = WhiteboardManager.getInstance();
        WhiteboardManager managerB = WhiteboardManager.getInstance();

        System.out.println("--- Manager Verification ---");
        System.out.println("Manager A Hash: " + System.identityHashCode(managerA));
        System.out.println("Manager B Hash: " + System.identityHashCode(managerB));
        //System.out.println("Are both managers the same instance? " + (managerA == managerB));
        System.out.println("----------------------------\n");

        
        String userId1 = "alice@example.com";
        String userId2 = "bob@example.com";
        
        System.out.println("--- Whiteboard Generation ---");
        
        UserWhiteboard aliceWb1 = managerA.getWhiteboardForUser(userId1);
        aliceWb1.addContent("Alice starts drawing a square.");

        UserWhiteboard bobWb = managerA.getWhiteboardForUser(userId2);
        bobWb.addContent("Bob writes his name.");

        UserWhiteboard aliceWb2 = managerB.getWhiteboardForUser(userId1);
        aliceWb2.addContent("Alice adds a circle.");
        
        
        System.out.println("\n--- Per-User Verification ---");
        
        System.out.println("Alice Wb 1 == Alice Wb 2? " + (aliceWb1 == aliceWb2));
        System.out.println("Alice Whiteboard object: " + aliceWb1);
        System.out.println("Bob Whiteboard object: " + bobWb);
        System.out.println("Are Alice's and Bob's whiteboards different? " + (aliceWb1 != bobWb));

        
        System.out.println("\n--- Content Isolation Check ---");
        System.out.println(aliceWb2.getContent());
        System.out.println("\n" + bobWb.getContent());
        
        System.out.println("\nTotal unique whiteboards managed: " + managerA.getTotalWhiteboardCount());
    }

}
