package uz.cristal.CRM.service;

import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.dto.ResponseDto;

public interface Filialservice {

    ResponseDto addFilial(FilialDto filialDto);

    ResponseDto getByName(String name);

    ResponseDto updateFilial(FilialDto filialDto);

    ResponseDto deleteFilialByid(Integer id);
}
