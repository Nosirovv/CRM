package uz.cristal.CRM.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.entity.Users;
import uz.cristal.CRM.repository.UserRepository;
import uz.cristal.CRM.service.UserService;
import uz.cristal.CRM.service.mapper.UsersMappper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersMappper usersMappper;

    private final UserRepository userRepository;


    @Override
    public ResponseDto addUsers(UserDto userDto) {
        try {
            Users user = usersMappper.toEntity(userDto);
            userRepository.save(user);

            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("OK")
                    .data(usersMappper.toDto(user))
                    .build();
        } catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<UserDto> getByid(Integer id) {
        try{
            Users users = userRepository.getReferenceById(id);
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("OK")
                    .data(usersMappper.toDto(users))
                    .build();
        } catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
            }


    }

    @Override
    public ResponseDto getUserByPhoneNumber(String phoneNumber) {
        try{
            return userRepository.findFirstByPhoneNumber(phoneNumber)
                    .map(u -> ResponseDto.<UserDto>builder()
                            .data(usersMappper.toDto(u))
                            .success(true)
                            .message("OK")
                            .build())
                    .orElse(ResponseDto.<UserDto>builder()
                            .message("Not found")
                            .success(false)
                            .build());
        } catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .message("Database Eror code")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto updateUsers(UserDto userDto) {
        if (userDto.getId() == null){
            return ResponseDto.<UserDto>builder()
                    .message("User ID is null")
                    .success(false)
                    .build();
        }

        Optional<Users> optional = userRepository.findById(userDto.getId());
        if (optional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        Users users = optional.get();

        if (userDto.getFirstName() != null){
            users.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null){
            users.setLastName(userDto.getLastName());
        }
        if (userDto.getBirthDate() != null){
            users.setBirthDate(userDto.getBirthDate());
        }
        if (userDto.getPhoneNumber() != null){
            users.setPhoneNumber(userDto.getPhoneNumber());
        }
        if (userDto.getGender() != null){
            users.setGender(userDto.getGender());
        }
        if (userDto.getUsername() != null){
            users.setUsername(userDto.getUsername());
        }
        if (userDto.getPassword() != null){
            users.setPassword(userDto.getPassword());
        }
        if (userDto.getRole() != null){
            users.setRole(userDto.getRole());
        }

        try {
            userRepository.save(users);

            return ResponseDto.<UserDto>builder()
                    .message("OK")
                    .success(true)
                    .data(usersMappper.toDto(users))
                    .build();
        }catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto deleteUsers(Integer id) {

        Optional<Users> users = userRepository.findById(id);
        if (users.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        Users deleteUsers = users.get();
        try {
            userRepository.delete(deleteUsers);
            return ResponseDto.<UserDto>builder()
                    .message("OK")
                    .success(true)
                    .data(usersMappper.toDto(deleteUsers))
                    .build();
        }catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }
}
