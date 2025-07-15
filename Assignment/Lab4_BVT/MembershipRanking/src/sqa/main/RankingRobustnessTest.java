package sqa.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankingRobustnessTest {

    Ranking ranking = new Ranking();
 // 1. All nominal
    @Test
    void testAllNominal() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 5, 500));
    }

    // 2-7. purchaseTotal: min-1, min, min+1, max-1, max, max+1
    @Test
    void testPurchaseTotal_BelowMin() {
        assertEquals("Standard", ranking.CalculateMembershipRank(-1, 5, 500));
    }
    @Test
    void testPurchaseTotal_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 5, 500));
    }
    @Test
    void testPurchaseTotal_MinPlus() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1, 5, 500));
    }
    @Test
    void testPurchaseTotal_MaxMinus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, 5, 500));
    }
    @Test
    void testPurchaseTotal_Max() {
        assertEquals("Gold", ranking.CalculateMembershipRank(100000, 5, 500));
    }
    @Test
    void testPurchaseTotal_AboveMax() {
        assertEquals("Gold", ranking.CalculateMembershipRank(100001, 5, 500));
    }

    // 8-13. frequency: min-1, min, min+1, max-1, max, max+1
    @Test
    void testFrequency_BelowMin() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, -1, 500));
    }
    @Test
    void testFrequency_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 0, 500));
    }
    @Test
    void testFrequency_MinPlus() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 1, 500));
    }
    @Test
    void testFrequency_MaxMinus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 6, 500));
    }
    @Test
    void testFrequency_Max() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 7, 500));
    }
    @Test
    void testFrequency_AboveMax() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 8, 500));
    }

    // 14-19. pointCollected: min-1, min, min+1, max-1, max, max+1
    @Test
    void testPointCollected_BelowMin() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 5, -1));
    }
    @Test
    void testPointCollected_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 5, 0));
    }
    @Test
    void testPointCollected_MinPlus() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 5, 1));
    }
    @Test
    void testPointCollected_MaxMinus() {
        assertEquals("Standard", ranking.CalculateMembershipRank(50000, 5, 499));
    }
    @Test
    void testPointCollected_Max() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 5, 500));
    }
    @Test
    void testPointCollected_AboveMax() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 5, 501));
    }
    
}
