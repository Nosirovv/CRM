package uz.cristal.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.cristal.CRM.entity.Course;
import uz.cristal.CRM.entity.Filial;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<List<Course>> findByName(String name);

}
