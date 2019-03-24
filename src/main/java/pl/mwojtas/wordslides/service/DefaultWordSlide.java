package pl.mwojtas.wordslides.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pl.mwojtas.wordslides.domain.Slide;
import pl.mwojtas.wordslides.repository.StoreRepository;

@Component
public class DefaultWordSlide implements WordSlide {

    private DefaultSlideFactory stringDivider;
    private StoreRepository store;

    public DefaultWordSlide(DefaultSlideFactory stringDivider, StoreRepository store) {
        this.stringDivider = stringDivider;
        this.store = store;
    }

    @Override
    public Map<String, Integer> getMap(String input) {
        Map<String, Integer> result = new HashMap<>();
        List<Slide> slides = stringDivider.create(input);

        slides.stream()
                .filter(Slide::isValid)
                .filter(slide -> store.keyExists(slide.toString()))
                .forEach(slide -> {
                    result.put(slide.toString(), store.getValue(slide.toString()));
                    slide.invalidate();
                });

        return result;
    }
}
