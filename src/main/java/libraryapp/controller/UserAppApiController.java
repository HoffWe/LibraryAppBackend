package libraryapp.controller;

import libraryapp.dto.UserDtoIn;
import libraryapp.dto.UserDtoOut;
import libraryapp.entity.UserApp;
import libraryapp.mapper.UserMapper;
import libraryapp.service.AuthenticationService;
import libraryapp.service.UserAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserAppApiController {

    private final UserAppService userAppService;
    private final AuthenticationService authService ;

    public UserAppApiController(UserAppService userAppService, AuthenticationService authService) {
        this.userAppService = userAppService;
        this.authService = authService;
    }

    @GetMapping
    List<UserDtoOut> getAllUsers(){
        return userAppService.getAllUsers().stream()
                .map(UserMapper::mapUserDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public List<UserDtoOut> getUsersById(@PathVariable UUID id){
        return userAppService.getUsersById(id).stream()
                .map(UserMapper::mapUserDtoOut)
                .collect(Collectors.toList());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserApp updateUser(@PathVariable UUID id, @RequestBody UserDtoIn userDtoIn){
        return userAppService.updateUser(id, userDtoIn);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestParam UUID id){
        userAppService.deleteUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> createUser(@RequestBody UserDtoIn userDtoIn){
        return ResponseEntity.ok( authService.register(userDtoIn));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
