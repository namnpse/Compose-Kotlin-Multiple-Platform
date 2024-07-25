import assertk.assertThat
import assertk.assertions.isEqualTo
import testing.calculateSum
import kotlin.test.Test


class SumTest {

    @Test
    fun calculateSumTest() {
        assertThat(calculateSum(1,2)).isEqualTo(3)
    }
}