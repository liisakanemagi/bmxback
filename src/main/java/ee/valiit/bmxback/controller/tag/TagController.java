package ee.valiit.bmxback.controller.tag;

import ee.valiit.bmxback.controller.tag.dto.TagInfo;
import ee.valiit.bmxback.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @GetMapping("/tags/pending")
    public List<TagInfo> findPendingTags() {
        return tagService.findPendingTags();
    }

    @PutMapping("/tag/activate")
    public void activateTag(@RequestParam Integer tagId) {
        tagService.activateTag(tagId);
    }

    @PostMapping("/tag/admin")
    public void addTagAdmin(@RequestParam String tagName) {
        tagService.addTagAdmin(tagName);
    }

    @PostMapping("/tag")
    public void addTag(@RequestParam String tagName) {
        tagService.addTag(tagName);
    }

    @GetMapping("/tags")
    public List<TagInfo> findTags() {
        return tagService.findTags();
    }

}
