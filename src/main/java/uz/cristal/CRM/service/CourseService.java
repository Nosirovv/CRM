package uz.cristal.CRM.service;

import org.springframework.data.domain.Page;
import uz.cristal.CRM.dto.CourseDto;
import uz.cristal.CRM.dto.ResponseDto;

public interface CourseService {
    ResponseDto<CourseDto> addCourse(CourseDto courseDto);

    ResponseDto<Page<CourseDto>> getAllCourses(Integer page, Integer size);

    ResponseDto<CourseDto> updateCourse(CourseDto courseDto);

    ResponseDto<CourseDto> deleteCourse(Integer id);


}
