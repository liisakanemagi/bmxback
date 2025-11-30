package ee.valiit.bmxback.persistence.user;

import ee.valiit.bmxback.controller.LoginResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse (User user);

}