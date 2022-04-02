package com.github.iamhi.onpath.core;

import com.github.iamhi.onpath.core.contentgenerators.ContentGenerator;
import com.github.iamhi.onpath.core.dto.ContentDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public record ContentServiceImpl(
    List<ContentGenerator> generatorList
) implements ContentService {
    @Override
    public Mono<ContentDTO> getContent(String viewName, String userCode) {
        Optional<ContentGenerator> contentGeneratorOptional =
            generatorList.stream()
                .filter(generator -> generator.getViewName().equals(viewName)).findFirst();

        if (contentGeneratorOptional.isPresent()) {
            return contentGeneratorOptional.get().generate(userCode);
        }

        return Mono.error(new RuntimeException("Bad view name"));
    }
}
