package testing

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test


class GetAbbreviationTest {


    @Test
    fun testGetInitials() {
        val fullName = "Bryan Nguyen"

        assertThat(getAbbreviation(fullName)).isEqualTo("BN")
    }
}