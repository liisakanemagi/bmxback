package ee.valiit.bmxback.controller.tag;

import ee.valiit.bmxback.controller.tag.dto.TagDto;
import ee.valiit.bmxback.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/tag")
    public void addTags(@RequestBody @Valid List<TagDto> tagDtos) {
        tagService.addTags(tagDtos);
    }
    @GetMapping("/tag")
    public List<TagDto> findTag(@RequestBody @Valid Integer tagId) {
        return tagService.findTags(tagId);
    }

}
