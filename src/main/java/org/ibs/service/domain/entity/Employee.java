package org.ibs.service.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departament_id")
    private Departament departament;

    @Column(name = "month_salary")
    private Integer monthSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boss_id")
    private Employee boss;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.MERGE})
    @JoinTable (name = "employee_course",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> course;

}