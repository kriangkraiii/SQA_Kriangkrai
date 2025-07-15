package sqa.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankingBoundaryValueTest {

    Ranking ranking = new Ranking();

    // Nominal values (typical valid values)
    int nominalPurchaseTotal = 50000;
    int nominalFrequency = 3;
    int nominalPointCollected = 500;

    // 1. All nominal
    @Test
    void testAllNominal() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, nominalFrequency, nominalPointCollected));
    }

    // 2-5. Vary purchaseTotal (min, min+, max-, max), others nominal
    @Test
    void testPurchaseTotal_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, nominalFrequency, nominalPointCollected));
    }
    @Test
    void testPurchaseTotal_MinPlus() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1, nominalFrequency, nominalPointCollected));
    }
    @Test
    void testPurchaseTotal_MaxMinus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, nominalFrequency, nominalPointCollected));
    }
    @Test
    void testPurchaseTotal_Max() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(100000, nominalFrequency, nominalPointCollected));
    }

    // 6-9. Vary frequency (min, min+, max-, max), others nominal
    @Test
    void testFrequency_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(nominalPurchaseTotal, 0, nominalPointCollected));
    }
    @Test
    void testFrequency_MinPlus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, 1, nominalPointCollected));
    }
    @Test
    void testFrequency_MaxMinus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, 6, nominalPointCollected));
    }
    @Test
    void testFrequency_Max() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, 7, nominalPointCollected));
    }

    // 10-13. Vary pointCollected (min, min+, max-, max), others nominal
    @Test
    void testPointCollected_Min() {
        assertEquals("Standard", ranking.CalculateMembershipRank(nominalPurchaseTotal, nominalFrequency, 0));
    }
    @Test
    void testPointCollected_MinPlus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, nominalFrequency, 1));
    }
    @Test
    void testPointCollected_MaxMinus() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, nominalFrequency, 999));
    }
    @Test
    void testPointCollected_Max() {
        assertEquals("Gold", ranking.CalculateMembershipRank(nominalPurchaseTotal, nominalFrequency, 1000));
    }
}
