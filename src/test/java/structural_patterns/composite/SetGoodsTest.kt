package structural_patterns.composite

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SetGoodsTest {

    @Test
    fun getGrossMass() {
        val p1 = PieceUnpackGoods("simpleProduct", 12)
        val p2 = PiecePackGoods("packProduct1", 33, 12)
        val p3 = PiecePackGoods("packProduct2", 87, 5)
        val p4 = SetGoods("setProduct", p1, p2, p3)
        val p5 = SetGoods("setProduct2", p4, p1, p1, p3)
        val p6 = SetGoods("setProduct3", p4, p5)

        assertEquals(p1.grossMass, 12)
        assertEquals(p2.netMass, 33)
        assertEquals(p3.grossMass, 87 + 5)
        assertEquals(p5.grossMass - p4.grossMass, 12 + 12 + 87 + 5)

        assertEquals(p6.netMass, 375)
        assertEquals(p6.grossMass, 414)
    }
}