package uz.cristal.CRM.service.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.entity.Filial;
import uz.cristal.CRM.entity.Users;

@Mapper(componentModel = "spring")
public interface FilialMapper extends CommonMapper<FilialDto,Filial>{
    




}
