package ee.valiit.bmxback.service;

import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.locationtag.LocationTag;
import ee.valiit.bmxback.persistence.locationtag.LocationTagRepository;
import ee.valiit.bmxback.persistence.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationTagService {
    private final LocationService locationService;
    private final TagService tagService;
    private final LocationTagRepository locationTagRepository;

    public void addLocationTag(Integer locationId, Integer tagId) {
        Location location = locationService.getValidLocation(locationId);
        Tag tag = tagService.getValidTag(tagId);
        LocationTag locationTag = new LocationTag();
        locationTag.setLocation(location);
        locationTag.setTag(tag);
        locationTagRepository.save(locationTag);

    }

}
