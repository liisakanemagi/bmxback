package ee.valiit.bmxback.persistence.user;

import ee.valiit.bmxback.controller.login.dto.LoginResponse;
import ee.valiit.bmxback.controller.register.dto.UserInfo;
import ee.valiit.bmxback.infrastructure.status.Status;
import org.mapstruct.*;

@Mapper(componentModel = "spring", imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id",target ="userId" )
    @Mapping(source = "role.name",target ="roleName" )
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    User toUser(UserInfo userInfo);

}