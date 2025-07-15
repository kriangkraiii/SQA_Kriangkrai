package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {

	@Test
	void testCalculateMembershipRank() {
		fail("Not yet implemented");
	}
	Ranking ranking = new Ranking();
	
	//Boundary value testing
    // Silver: ยอดซื้อรวม 10,000-49,999 บาท, ไปห้าง 1-2 ครั้ง/เดือน, สะสมคะแนน 100-499 คะแนน
    @Test
    void testSilver_LowerBoundary() {
        assertEquals("Silver", ranking.CalculateMembershipRank(10000, 1, 100));
    }

    @Test
    void testSilver_UpperBoundary() {
        assertEquals("Silver", ranking.CalculateMembershipRank(49999, 2, 499));
    }

    // Gold: ยอดซื้อรวม 50,000-99,999 บาท, ไปห้าง 3-5 ครั้ง/เดือน, สะสมคะแนน 500-999 คะแนน
    @Test
    void testGold_LowerBoundary() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 3, 500));
    }

    @Test
    void testGold_UpperBoundary() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, 5, 999));
    }

    // Platinum: ยอดซื้อรวม 100,000 บาทขึ้นไป, ไปห้าง 6-7 ครั้ง/เดือน, สะสมคะแนน 1,000 คะแนนขึ้นไป
    @Test
    void testPlatinum_LowerBoundary() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(100000, 6, 1000));
    }

    @Test
    void testPlatinum_UpperBoundary() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(150000, 7, 5000));
    }
    
    
    
    //Robustness testing
    // Standard: ต่ำกว่าทุกเงื่อนไขข้างบน
    @Test
    void testStandard_BelowAll() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 0, 0));
    }

    // กรณีพิเศษ: ไปห้างแต่ไม่ซื้อของเลย
    @Test
    void testGoToMallButBuyNothing() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 12, 0));
    }

    // กรณีพิเศษ: มาซื้อของแต่ไม่ได้ซื้อประจำ
    @Test
    void testBuyButNotRegularly() {
        assertEquals("Standard", ranking.CalculateMembershipRank(20000, 0, 200));
    }

}
