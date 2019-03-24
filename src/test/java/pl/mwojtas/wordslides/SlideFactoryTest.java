package pl.mwojtas.wordslides;

import static com.google.common.truth.Truth.assertThat;
import static pl.mwojtas.wordslides.TestHelper.GONE;
import static pl.mwojtas.wordslides.TestHelper.MARY;
import static pl.mwojtas.wordslides.TestHelper.MARY_S;
import static pl.mwojtas.wordslides.TestHelper.WENT;
import static pl.mwojtas.wordslides.TestHelper.createSlide;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.mwojtas.wordslides.domain.Slide;
import pl.mwojtas.wordslides.service.DefaultSlideFactory;

public class SlideFactoryTest {

    private DefaultSlideFactory stringDivider;

    @Before
    public void setUp() {
        stringDivider = new DefaultSlideFactory();
    }

    @Test
    public void acceptableTest() {
        List<Slide> divide = stringDivider.create("Mary went Mary's gone");

        assertThat(divide)
                .containsExactly(
                        createSlide(MARY, WENT, MARY_S, GONE),
                        createSlide(MARY, WENT, MARY_S),
                        createSlide(WENT, MARY_S, GONE),
                        createSlide(MARY, WENT),
                        createSlide(WENT, MARY_S),
                        createSlide(MARY_S, GONE),
                        createSlide(MARY),
                        createSlide(WENT),
                        createSlide(MARY_S),
                        createSlide(GONE)
                )
                .inOrder();
    }
}