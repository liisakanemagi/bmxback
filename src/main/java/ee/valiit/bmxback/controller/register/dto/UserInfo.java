package ee.valiit.bmxback.controller.register.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class UserInfo implements Serializable {
    @NotNull
    @Size(max = 255)
    String username;
    @NotNull
    @Size(max = 255)
    String password;
    @NotNull
    @Size(max = 30)
    String email;
}