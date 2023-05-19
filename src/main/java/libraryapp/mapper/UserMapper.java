package libraryapp.mapper;

import libraryapp.dto.UserDtoOut;
import libraryapp.entity.UserApp;

public class UserMapper {



    public static UserDtoOut mapUserDtoOut (UserApp userApp){
        return UserDtoOut.builder()
                .id(userApp.getId())
                .username(userApp.getUsername())
                .password(userApp.getPassword())
                .email(userApp.getEmail())
                .build();
    }
}
