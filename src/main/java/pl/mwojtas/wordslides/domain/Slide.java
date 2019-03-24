package pl.mwojtas.wordslides.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Slide {
    private List<Word> words = new ArrayList<>();

    public void add(Word word) {
        words.add(word);
    }

    public void invalidate() {
        words.forEach(Word::invalidate);
    }

    public Boolean isValid() {
        return words.stream().allMatch(Word::isValid);
    }

    public List<Word> getWords() {
        return Collections.unmodifiableList(words);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slide slide = (Slide) o;
        return Objects.equals(words, slide.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        return words.stream().map(Word::getValue).collect(Collectors.joining(" "));
    }
}
