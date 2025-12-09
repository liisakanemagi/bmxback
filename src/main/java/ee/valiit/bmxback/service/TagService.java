package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.tag.dto.TagInfo;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.infrastructure.status.Status;
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

    public void addTagAdmin(String tagName) {
        Tag tag = createTag(tagName, Status.ACTIVE.getCode());
        tagRepository.save(tag);
    }

    public void addTag(String tagName) {
        Tag tag = createTag(tagName, Status.PENDING.getCode());
        tagRepository.save(tag);
    }

    public List<TagInfo> findTags() {
        List<Tag> tags = tagRepository.findTagsBy(Status.ACTIVE.getCode());
        return tagMapper.toTagInfos(tags);
    }

    public List<TagInfo> findPendingTags() {
        List<Tag> tags = tagRepository.findTagsBy(Status.ACTIVE.getCode());
        return tagMapper.toTagInfos(tags);
    }

    private static Tag createTag(String tagName, String status) {
        Tag tag = new Tag();
        tag.setName(tagName);
        tag.setStatus(status);
        return tag;
    }

    public void activateTag(Integer tagId) {
        Tag tag = getValidTag(tagId);
        tag.setStatus(Status.ACTIVE.getCode());
        tagRepository.save(tag);
    }

    public Tag getValidTag(Integer tagId) {
        return tagRepository.findById(tagId).orElseThrow(() -> new PrimaryKeyNotFoundException("tagId", tagId));

    }

}
