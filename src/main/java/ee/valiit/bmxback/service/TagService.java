package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.tag.dto.TagDto;
import ee.valiit.bmxback.persistence.tag.Tag;
import ee.valiit.bmxback.persistence.tag.TagMapper;
import ee.valiit.bmxback.persistence.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public void addTags(List<TagDto> tagDtos) {
        List<Tag> tags = tagMapper.toTags(tagDtos);
        tagRepository.saveAll(tags);
    }

}
