package com.osama.reddittest

import com.osama.reddittest.utils.DateUtils
import org.junit.Assert.assertTrue
import org.junit.Test

class DateUtilValidatorTest {
    @Test
    fun dateUtilValidator_printDateFromUtc_ReturnsCorrectEpoch() {
        //TODO mock getSystem for this to work
        assertTrue(DateUtils.printDateFromUtc(0) == "01/01/1970 07:30 am")
    }
}