package pl.mwojtas.wordslides.service;

import java.util.List;

import pl.mwojtas.wordslides.domain.Slide;

public interface SlideFactory {
    List<Slide> create(String input);
}
