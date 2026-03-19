package com.example.midtest01.controller;

import com.example.midtest01.model.Classroom;
import com.example.midtest01.model.School;
import com.example.midtest01.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SchoolController {

  @Autowired
  private SchoolService schoolService;

  @GetMapping("/schools")
  public List<School> getAllSchools(@RequestParam(required = false) Integer noNumber) {
    if (noNumber != null) {
      return schoolService.getSchoolsByMinTotalStudents(noNumber);
    }
    return schoolService.getAllSchools();
  }

  @GetMapping("/schools/{schoolId}")
  public School getSchoolById(@PathVariable int schoolId) {
    return schoolService.getSchoolById(schoolId);
  }

  @GetMapping("/classrooms")
  public List<Classroom> getAllClassrooms(@RequestParam(required = false) Integer noNumber) {
    if (noNumber != null) {
      return schoolService.getClassroomsByMinStudents(noNumber);
    }
    return schoolService.getAllClassrooms();
  }
}
