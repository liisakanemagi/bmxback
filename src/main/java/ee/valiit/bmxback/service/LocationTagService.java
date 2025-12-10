package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.locationtag.dto.LocationTagDto;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.locationtag.LocationTag;
import ee.valiit.bmxback.persistence.locationtag.LocationTagRepository;
import ee.valiit.bmxback.persistence.tag.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationTagService {
    private final LocationService locationService;
    private final TagService tagService;
    private final LocationTagRepository locationTagRepository;

    public void addLocationTag(@Valid LocationTagDto locationTagDto) {
        Location location = locationService.getValidLocation(locationTagDto.getLocationId());
        Tag tag = tagService.getValidTag(locationTagDto.getTagId());

//        Lisada eraldi "lisa uus tag" nupp fronti ja see kasutab TagControllerit.
//        LocationTagController kasutab ainult juba loodud tag-e. Kontrollib asukoha ja tag-i ID-sid ja paneb need kokku LocationTag tabelisse.
        LocationTag locationTag = new LocationTag();
        locationTag.setLocation(location);
        locationTag.setTag(tag);
        locationTagRepository.save(locationTag);

    }

}
