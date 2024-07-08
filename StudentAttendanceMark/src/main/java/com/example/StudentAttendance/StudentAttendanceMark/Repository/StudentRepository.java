package com.example.StudentAttendance.StudentAttendanceMark.Repository;

import com.example.StudentAttendance.StudentAttendanceMark.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {
}
