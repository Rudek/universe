package com.fluffy.universe.controllers;

import com.fluffy.universe.models.User;
import com.fluffy.universe.services.UserService;
import com.fluffy.universe.utils.Configuration;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.io.File;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("Test UserController")
public class UserControllerTest {
    private final Context ctx = mock(Context.class);
    private final Javalin app = mock(Javalin.class);

    @Test
    @DisplayName("Testing signIn action")
    public void signInTest() {
        Configuration.load(new File("application.properties"));
        UserController userController = new UserController(this.app);

        User user = new User();
        final String password = "fs$fFl24";
        user.setPassword(UserService.encodePassword(password));
        user.setEmail("test@mail.com");
        user.setFirstName("Maxim");
        user.setLastName("Rudenko");

        when(ctx.formParam("email")).thenReturn(user.getEmail());
        when(ctx.formParam("password")).thenReturn(password);

        try (MockedStatic<UserService> userService = Mockito.mockStatic(UserService.class)) {
            userService.when(() -> UserService.getUserByEmail(anyString())).thenReturn(user);
            userService.when(() -> UserService.isCorrectPassword(anyString(), anyString())).thenReturn(true);
            userController.signIn(ctx);

            Mockito.inOrder(ctx).verify(ctx, calls(1)).sessionAttribute(Mockito.anyString());
            Mockito.inOrder(ctx).verify(ctx, calls(2)).formParam(Mockito.anyString());
            Mockito.inOrder(ctx).verify(ctx, calls(1)).sessionAttribute(Mockito.anyString(), any(User.class));
            verify(ctx).redirect("/");
        }
    }
}
