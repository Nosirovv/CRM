package uz.cristal.CRM.service;

import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.dto.UserDto;

import java.util.List;

public interface UserService {

    ResponseDto addUsers(UserDto userDto);

    ResponseDto getByid(Integer id);

    ResponseDto getUserByPhoneNumber(String phoneNumber);

    ResponseDto updateUsers(UserDto userDto);

    ResponseDto deleteUsers(Integer id);


}
