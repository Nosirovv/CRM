package uz.cristal.CRM.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.service.Filialservice;

import javax.validation.Valid;

@RestController
@RequestMapping("/filial")
@RequiredArgsConstructor
public class FilialController {

    private final Filialservice filialservice;

    @GetMapping("/byName")
    public ResponseDto<FilialDto> getByName(@RequestParam("name") String name){
        return filialservice.getByName(name);
    }

    @PostMapping
    public ResponseDto<FilialDto> addFilial(@RequestBody @Valid FilialDto filialDto){
        return filialservice.addFilial(filialDto);
    }

    @PatchMapping()
    public ResponseDto<FilialDto> updateMarkaz(@RequestBody FilialDto filialDto){
        return filialservice.updateFilial(filialDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<FilialDto> deleteMarkaz(@PathVariable Integer id){
        return filialservice.deleteFilialByid(id);
    }


}
