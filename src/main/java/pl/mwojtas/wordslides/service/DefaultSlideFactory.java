package pl.mwojtas.wordslides.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.mwojtas.wordslides.domain.Slide;
import pl.mwojtas.wordslides.domain.Word;

@Service
public class DefaultSlideFactory implements SlideFactory {
    private final static String WHITE_SPACE = " ";

    public List<Slide> create(String input) {
        Word[] words = Arrays.stream(input.split(WHITE_SPACE))
                .map(Word::new)
                .toArray(Word[]::new);

        var wordsList = new LinkedList<Slide>();

        for (int i = 0; i < words.length; i++) {
            for (int j = words.length - 1; j >= 0; j--) {
                Slide slide = new Slide();
                for (int k = i; k < j + 1; k++) {
                    slide.add(words[k]);
                }
                if (slide.getWords().size() > 0) {
                    wordsList.addFirst(slide);
                }
            }
        }

        wordsList.sort(Comparator.comparingLong(o -> o.getWords().stream().map(Word::getValue).count()));
        Collections.reverse(wordsList);

        return wordsList;
    }
}
