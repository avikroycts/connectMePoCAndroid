package com.example.americanairlinespoc.ViewComponents.Activity.Login.Presenters;

import android.content.Context;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginImplicatorTest {

    private LoginImplicator loginPresenter;
    @Mock
    private LoginView loginView;
    @Mock
    private Context context;
    @Before
    public void setUp() throws Exception {
        loginPresenter = new LoginImplicator(loginView,context);
    }

    @Test
    public void shouldShowErrorMessageOnUserNameEmptyJUNit() {
        when(loginView.getUserNameTest()).thenReturn("ABC");
        loginPresenter.onLoginButtonClickTest();

        verify(loginView).showUserNameErrorTest(R.string.user_id_empty);
    }

}