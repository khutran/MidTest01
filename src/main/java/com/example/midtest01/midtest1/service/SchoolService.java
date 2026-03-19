package com.example.midtest01.midtest1.service;

import com.example.midtest01.midtest1.model.Classroom;
import com.example.midtest01.midtest1.model.School;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
  private List<School> schools;

  public SchoolService() {
    this.schools = new ArrayList<>();
    initData();
  }

  private void initData() {
    // School 1
    ArrayList<Classroom> c1 = new ArrayList<>();
    c1.add(new Classroom(101, "Class 1A", 30));
    c1.add(new Classroom(102, "Class 1B", 35));
    c1.add(new Classroom(103, "Class 1C", 25));
    schools.add(new School(1, "High School A", "Address A", c1));

    // School 2
    ArrayList<Classroom> c2 = new ArrayList<>();
    c2.add(new Classroom(201, "Class 2A", 40));
    c2.add(new Classroom(202, "Class 2B", 45));
    c2.add(new Classroom(203, "Class 2C", 50));
    schools.add(new School(2, "High School B", "Address B", c2));

    // School 3
    ArrayList<Classroom> c3 = new ArrayList<>();
    c3.add(new Classroom(301, "Class 3A", 20));
    c3.add(new Classroom(302, "Class 3B", 15));
    c3.add(new Classroom(303, "Class 3C", 10));
    schools.add(new School(3, "High School C", "Address C", c3));
  }

  public List<School> getAllSchools() {
    return schools;
  }

  public School getSchoolById(int id) {
    return schools.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
  }

  public List<Classroom> getAllClassrooms() {
    List<Classroom> allClassrooms = new ArrayList<>();
    for (School school : schools) {
      allClassrooms.addAll(school.getClassrooms());
    }
    return allClassrooms;
  }

  public List<Classroom> getClassroomsByMinStudents(int min) {
    return getAllClassrooms().stream()
        .filter(c -> c.getNoStudent() > min)
        .collect(Collectors.toList());
  }

  public List<School> getSchoolsByMinTotalStudents(int min) {
    return schools.stream()
        .filter(s -> s.getTotalStudent() > min)
        .collect(Collectors.toList());
  }
}
