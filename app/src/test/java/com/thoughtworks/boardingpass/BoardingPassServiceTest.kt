package com.thoughtworks.boardingpass

import com.thoughtworks.boardingpass.service.ServiceFactory
import org.junit.Test

import org.junit.Assert.*

class BoardingPassServiceTest {
    @Test
    fun boardingPassServiceShouldReturnCorrectBoardingPass() {
        val response = ServiceFactory.boardingPassService().boardingPassById("1").execute()

        assertTrue(response.isSuccessful)
        assertEquals("1", response.body()?.id)
        assertEquals("Boarding Pass 1", response.body()?.name)
        assertEquals("https://raw.githubusercontent.com/zpao/qrcode.react/HEAD/qrcode.png", response.body()?.url)
    }
}
