package pl.mwojtas.wordslides;

import java.util.Arrays;

import pl.mwojtas.wordslides.domain.Slide;
import pl.mwojtas.wordslides.domain.Word;

public class TestHelper {
    public static final Word MARY = new Word("Mary");
    public static final Word WENT = new Word("went");
    public static final Word MARY_S = new Word("Mary's");
    public static final Word GONE = new Word("gone");

    public static Slide createSlide(Word... words) {
        Slide slide = new Slide();
        Arrays.stream(words).forEach(slide::add);

        return slide;
    }
}
