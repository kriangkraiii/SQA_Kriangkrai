package sqa.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class CountWordClumpsTest {

	 // กรณีผิดเงื่อนไขเริ่มต้น
    @Test
    void testNullArray() {
        assertEquals(0, CountWordClumps.countClumps(null), "Null array");
    }

    @Test
    void testEmptyArray() {
        assertEquals(0, CountWordClumps.countClumps(new int[]{}), "Empty array");
    }

    // กรณี Array ตัวเดียว ไม่มี clump
    @Test
    void testSingleElement() {
        assertEquals(0, CountWordClumps.countClumps(new int[]{5}), "Single element");
    }

    // กรณีไม่มี clump
    @Test
    void testNoClump() {
        assertEquals(0, CountWordClumps.countClumps(new int[]{1,2,3,4,5}), "No clumps");
    }

    // กรณี all clump ติดกันหมด
    @Test
    void testOneLongClump() {
        assertEquals(1, CountWordClumps.countClumps(new int[]{6,6,6,6,6}), "All same");
    }

    // กรณี clump เดียวกลางอาร์เรย์
    @Test
    void testMiddleClump() {
        assertEquals(1, CountWordClumps.countClumps(new int[]{1,2,2,3}), "Middle clump");
    }

    // กรณี clump หัวท้าย
    @Test
    void testSeparateClumps() {
        assertEquals(2, CountWordClumps.countClumps(new int[]{7,7,8,9,10,10}), "Clump at start and end");
    }

    // กรณี clump ติดกันหลายกลุ่ม
    @Test
    void testMultipleClumps() {
        assertEquals(3, CountWordClumps.countClumps(new int[]{1,1,2,2,3,3,3,4}), "Multiple clumps");
    }

    // กรณี clump ติดกันแยกกลุ่มกลับมา clump เดิมอีก
    @Test
    void testNonconsecutiveClump() {
        assertEquals(2, CountWordClumps.countClumps(new int[]{1,1,2,1,1}), "Separated same number clumps");
    }

    // corner case: คล้าย clump ติดๆแต่ inClump ต้องไม่ถูกนับซ้ำ
    @Test
    void testLongClumpCountOnce() {
        assertEquals(1, CountWordClumps.countClumps(new int[]{4,4,4,4}), "Long single clump");
    }

    // กรณีสลับค่า ไม่เป็น clump
    @Test
    void testAlternating() {
        assertEquals(0, CountWordClumps.countClumps(new int[]{1,2,1,2,1}), "Alternating values");
    }
}
