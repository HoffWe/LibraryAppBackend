package libraryapp.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDtoOut {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String address;

}
