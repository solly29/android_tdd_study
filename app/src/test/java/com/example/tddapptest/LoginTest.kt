package com.example.tddapptest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tddapptest.model.UserData
import com.example.tddapptest.viewmodel.LoginViewModel
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginTest {

    // LiveData Unit Test Rule
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    var viewModel = spy(LoginViewModel::class.java)

    private val userData = UserData("admin12a", "admin")

    @Test
    fun `로그인_아이디_유효성_검사_성공`() {
        /* Given */
        val id = "admin12a"

        /* When */
        val result = viewModel.loginIdCheck(id)

        /* Then */
        assertEquals(true, result)
    }

    @Test
    fun `로그인_아이디_유효성_검사_실패`() {
        /* Given */
        val id = "ad'mi_n12a__"

        /* When */
        val result = viewModel.loginIdCheck(id)

        /* Then */
        assertEquals(false, result)
    }

    @Test
    fun `로그인_비밀번호_유효성_검사_성공`() {
        /* Given */
        val pw = "test1235@"

        /* When */
        val result = viewModel.loginPwCheck(pw)

        /* Then */
        assertEquals(true, result)
    }

    @Test
    fun `로그인_비밀번호_유효성_검사_실패`() {
        /* Given */
        val pw = "test1235_"

        /* When */
        val result = viewModel.loginPwCheck(pw)

        /* Then */
        assertEquals(false, result)
    }

    @Test
    fun `로그인_성공`() {
        /* Given */
        val id = "admin123"
        val pw = "test1235@"

        /* When */
        viewModel.login(id, pw)

        /* Then */
        verify(viewModel).loginIdCheck(anyString())
        verify(viewModel).loginPwCheck(anyString())
        assertEquals(userData, viewModel.userLiveData.value)
    }

    @Test
    fun `로그인_실패`() {
        /* Given */
        val id = "admin123"
        val pw = "test12354@"

        /* When */
        viewModel.login(id, pw)

        /* Then */
        verify(viewModel).loginIdCheck(anyString())
        verify(viewModel).loginPwCheck(anyString())
        assertEquals(true, viewModel.loginFail.value)
    }

    @Test
    fun `로그인_유효성_검사_실패`() {
        /* Given */
        val id = "admin12a@"
        val pw = "test1235"

        /* When */
        viewModel.login(id, pw)

        /* Then */
        // 조건문에 and 걸어서 뒤에 함수는 실행안됨
        verify(viewModel).loginIdCheck(anyString())
//        verify(viewModel).loginPwCheck(anyString())
        assertEquals(true, viewModel.loginCheckLiveData.value)
    }
}