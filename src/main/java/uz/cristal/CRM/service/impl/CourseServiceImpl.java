package uz.cristal.CRM.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.cristal.CRM.dto.CourseDto;
import uz.cristal.CRM.dto.FilialDto;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.dto.UserDto;
import uz.cristal.CRM.entity.Course;
import uz.cristal.CRM.entity.Filial;
import uz.cristal.CRM.repository.CourseRepository;
import uz.cristal.CRM.service.CourseService;
import uz.cristal.CRM.service.mapper.CourseMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    private final CourseRepository courseRepository;
    @Override
    public ResponseDto<CourseDto> addCourse(CourseDto courseDto) {
        try {
            Course course = courseMapper.toEntity(courseDto);
            courseRepository.save(course);

            return ResponseDto.<CourseDto>builder()
                    .success(true)
                    .message("OK")
                    .data(courseMapper.toDto(course))
                    .build();
        } catch (Exception e){
            return ResponseDto.<CourseDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<Page<CourseDto>> getAllCourses(Integer page, Integer size) {
        Long count = courseRepository.count();

        PageRequest pageRequest = PageRequest.of(
                (count / size) <= page ?
                        (count % size == 0 ? (int) (count / size) - 1
                                : (int) (count / size))
                        : page,
                size);

        Page<CourseDto> courseDtos = courseRepository.findAll(pageRequest)
                .map(courseMapper::toDto);

        return ResponseDto.<Page<CourseDto>>builder()
                .success(true)
                .message("OK")
                .data(courseDtos)
                .build();

    }


    @Override
    public ResponseDto<CourseDto> updateCourse(CourseDto courseDto) {
        if(courseDto.getId() == null){
            return ResponseDto.<CourseDto>builder()
                    .message("Id is null")
                    .success(false)
                    .build();
        }

        Optional<Course> optional = courseRepository.findById(courseDto.getId());
        if (optional.isEmpty()){
            return ResponseDto.<CourseDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        Course course = optional.get();


        try {
            courseRepository.save(course);
            return ResponseDto.<CourseDto>builder()
                    .message("OK")
                    .success(true)
                    .data(courseMapper.toDto(course))
                    .build();
        }catch (Exception e){
            return ResponseDto.<CourseDto>builder()
                    .message("Database eror")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<CourseDto> deleteCourse(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()){
            return ResponseDto.<CourseDto>builder()
                    .message("Not found")
                    .success(false)
                    .build();
        }
        courseRepository.deleteById(id);
        return ResponseDto.<CourseDto>builder()
                .message("OK")
                .success(true)
                .build();
    }
}
