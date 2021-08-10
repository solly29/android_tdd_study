package com.example.tddapptest

import com.example.tddapptest.viewmodel.LoginViewModel
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class LoginTest {

    @Test
    fun `로그인_아이디_유효성_검사_성공`() {
        /* Given */
        val id = "admin12a"
        val viewModel = LoginViewModel()

        /* When */
        val result = viewModel.loginIdCheck(id)

        /* Then */
        assertEquals(true, result)
    }

    @Test
    fun `로그인_아이디_유효성_검사_실패`() {
        /* Given */
        val id = "ad'mi_n12a__"
        val viewModel = LoginViewModel()

        /* When */
        val result = viewModel.loginIdCheck(id)

        /* Then */
        assertEquals(false, result)
    }

    @Test
    fun `로그인_비밀번호_유효성_검사_성공`() {
        /* Given */
        val pw = "test1235@"
        val viewModel = LoginViewModel()

        /* When */
        val result = viewModel.loginPwCheck(pw)

        /* Then */
        assertEquals(true, result)
    }

    @Test
    fun `로그인_비밀번호_유효성_검사_실패`() {
        /* Given */
        val pw = "test1235_"
        val viewModel = LoginViewModel()

        /* When */
        val result = viewModel.loginPwCheck(pw)

        /* Then */
        assertEquals(false, result)
    }

    @Test
    fun `로그인_성공`() {
        /* Given */

        /* When */

        /* Then */
    }
}