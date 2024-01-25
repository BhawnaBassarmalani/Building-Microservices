package springboot.demo.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

    Department findByDepartmentCode(String departmentCode);
}
