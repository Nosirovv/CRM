package uz.cristal.CRM.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.entity.Filial;
import uz.cristal.CRM.entity.Users;
import uz.cristal.CRM.repository.FilialRepository;
import uz.cristal.CRM.service.Filialservice;
import uz.cristal.CRM.service.mapper.FilialMapper;
import uz.cristal.CRM.service.mapper.UsersMappper;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.File;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilialServiceImpl implements Filialservice {

    private final FilialRepository filialRepository;

    private final FilialMapper filialMapper;

    @Override
    public ResponseDto addFilial(FilialDto filialDto) {
        try {
            Filial filial = filialMapper.toEntity(filialDto);
            filialRepository.save(filial);

            return ResponseDto.<FilialDto>builder()
                    .success(true)
                    .message("OK")
                    .data(filialMapper.toDto(filial))
                    .build();
        } catch (Exception e){
            return ResponseDto.<FilialDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto getByName(String name) {

        try {
            return filialRepository.findFirstByName(name)
                    .map(i -> ResponseDto.<FilialDto>builder()
                            .data(filialMapper.toDto(i))
                            .success(true)
                            .message("OK")
                            .build())
                    .orElse(ResponseDto.<FilialDto>builder()
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
    public ResponseDto updateFilial(FilialDto filialDto) {
        if(filialDto.getId() == null){
            return ResponseDto.<FilialDto>builder()
                    .message("Id is null")
                    .success(false)
                    .build();
        }

        Optional<Filial> optional = filialRepository.findById(filialDto.getId());
        if (optional.isEmpty()){
            return ResponseDto.<FilialDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        Filial filial = optional.get();


        try {
            filialRepository.save(filial);
            return ResponseDto.<FilialDto>builder()
                    .message("OK")
                    .success(true)
                    .data(filialMapper.toDto(filial))
                    .build();
        }catch (Exception e){
            return ResponseDto.<FilialDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }

}

    @Override
    public ResponseDto deleteFilialByid(Integer id) {
        Optional<Filial> filial = filialRepository.findById(id);
        if (filial.isEmpty()){
            return ResponseDto.<FilialDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        filialRepository.deleteById(id);
        return ResponseDto.<FilialDto>builder()
                .message("OK")
                .success(true)
                .build();
    }
}
