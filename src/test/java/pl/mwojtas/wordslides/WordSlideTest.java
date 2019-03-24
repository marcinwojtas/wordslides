package pl.mwojtas.wordslides;

import static com.google.common.truth.Truth.assertThat;
import static pl.mwojtas.wordslides.TestHelper.GONE;
import static pl.mwojtas.wordslides.TestHelper.MARY;
import static pl.mwojtas.wordslides.TestHelper.MARY_S;
import static pl.mwojtas.wordslides.TestHelper.WENT;
import static pl.mwojtas.wordslides.TestHelper.createSlide;

import java.util.Map;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import pl.mwojtas.wordslides.repository.StoreRepository;
import pl.mwojtas.wordslides.service.DefaultSlideFactory;
import pl.mwojtas.wordslides.service.DefaultWordSlide;

@RunWith(MockitoJUnitRunner.class)
public class WordSlideTest {

    @Mock
    private DefaultSlideFactory stringDivider;

    @Mock
    private StoreRepository store;

    @InjectMocks
    private DefaultWordSlide wordSlide;


    @Test
    public void acceptableTest() {
        Mockito.when(stringDivider.create("Mary went Mary's gone"))
                .thenReturn(Lists.newArrayList(
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
                ));

        Mockito.when(store.keyExists("Mary")).thenReturn(Boolean.TRUE);
        Mockito.when(store.keyExists("went Mary's")).thenReturn(Boolean.TRUE);
        Mockito.when(store.getValue("Mary")).thenReturn(1);
        Mockito.when(store.getValue("went Mary's")).thenReturn(4);

        Map<String, Integer> result = wordSlide.getMap("Mary went Mary's gone");

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(
                "went Mary's", 4,
                "Mary", 1)
                .inOrder();

    }
}