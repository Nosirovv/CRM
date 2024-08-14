package uz.cristal.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.cristal.CRM.entity.Filial;
import uz.cristal.CRM.entity.Users;

import java.util.Optional;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Integer> {
    Optional<Filial> findFirstByName(String name);

}
