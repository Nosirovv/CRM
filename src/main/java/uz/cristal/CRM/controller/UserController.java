package uz.cristal.CRM.controller;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import uz.cristal.CRM.dto.MentorDto;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseDto<UserDto> addUsers(@RequestBody @Valid UserDto userDto){
        return userService.addUsers(userDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<UserDto> getById(@PathVariable Integer id){
        return userService.getByid(id);
    }

    @GetMapping("/by-phone-number")
    public ResponseDto<UserDto> getUserByPhoneNumber(@RequestParam String phoneNumber){
        return userService.getUserByPhoneNumber(phoneNumber);
    }

    @PatchMapping
    public ResponseDto<UserDto> updateUser(@RequestBody UserDto usersDto) {
        return userService.updateUsers(usersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<UserDto> deleteUser(@PathVariable Integer id) {
        return  userService.deleteUsers(id);
    }

    @GetMapping("nginx")
    public String backSalom(){
        return "Salom nginx ishaldi";
    }




}
