package uz.cristal.CRM.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import uz.cristal.CRM.dto.CourseDto;
import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.entity.Course;
import uz.cristal.CRM.entity.Filial;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CourseMapper extends CommonMapper<CourseDto, Course> {

 }
