package uz.cristal.CRM.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.cristal.CRM.dto.CourseDto;
import uz.cristal.CRM.dto.ResponseDto;
import uz.cristal.CRM.service.CourseService;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAllCourse")
    public ResponseDto<Page<CourseDto>> getAll(@RequestParam(defaultValue = "0") Integer page,
                                                       @RequestParam(defaultValue = "10") Integer size){
        return courseService.getAllCourses(page, size);
    }

    @PostMapping
    public ResponseDto<CourseDto> addCourse(@RequestBody @Valid CourseDto courseDto){
        return courseService.addCourse(courseDto);
    }

    @PatchMapping("/update")
    public ResponseDto<CourseDto> updateCourse(@RequestBody CourseDto courseDto){
        return courseService.updateCourse(courseDto);
    }

    @DeleteMapping
    public ResponseDto<CourseDto> deleteCourse(@RequestParam Integer id){
        return courseService.deleteCourse(id);
    }



}
