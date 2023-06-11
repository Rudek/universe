package com.fluffy.universe.controllers;

import com.fluffy.universe.models.User;
import com.fluffy.universe.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserControllerTest {

    private final Context ctx = mock(Context.class);

    private final Javalin app = mock(Javalin.class);

    @Test
    public void signInTest() {
        User user = new User();
        user.setPassword("fs$fFl24");
        user.setEmail("test@email.com");
        user.setFirstName("Max");
        user.setLastName("Rudenko");

        when(ctx.formParam("email")).thenReturn("Max");
        when(ctx.formParam("email")).thenReturn("Max");

        try (MockedStatic<UserService> userService = Mockito.mockStatic(UserService.class)) {
            userService.when(() -> UserService.getUserByEmail(user.getEmail())).thenReturn(user);

            (new UserController(app)).signIn(ctx);
            verify(ctx).redirect("/");
        }
    }
}
