package uz.cristal.CRM.service.mapper;


import org.mapstruct.Mapper;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMappper extends CommonMapper<UserDto, Users> {

}
