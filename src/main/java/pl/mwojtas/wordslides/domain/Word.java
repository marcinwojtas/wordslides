package pl.mwojtas.wordslides.domain;

import java.util.Objects;

public final class Word {
    private final String value;
    private Boolean valid;

    public Word(String value) {
        this.value = value;
        this.valid = true;
    }

    public String getValue() {
        return value;
    }

    public Boolean isValid() {
        return valid;
    }

    public void invalidate() {
        valid = false;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value) &&
                Objects.equals(valid, word.valid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, valid);
    }
}
