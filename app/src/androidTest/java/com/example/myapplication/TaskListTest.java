package com.example.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TaskListTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAdicionarTarefaComSucesso() {
        // Digita um texto no campo (Verifique se o seu ID no XML é editTask)
        onView(withId(R.id.editTask))
                .perform(typeText("Estudar para sistemas operacionais"), closeSoftKeyboard());

        // Clica no botão (Verifique se o seu ID no XML é btnAdd)
        onView(withId(R.id.btnAdd)).perform(click());

        // Verifica se o texto apareceu na tela
        onView(withText("Estudar para sistemas operacionais"))
                .check(matches(isDisplayed()));
    }
}
