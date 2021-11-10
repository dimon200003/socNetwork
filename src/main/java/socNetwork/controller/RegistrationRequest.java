package socNetwork.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class RegistrationRequest {

        @NotEmpty
        private String name;

        @NotEmpty
        private String password;

}
