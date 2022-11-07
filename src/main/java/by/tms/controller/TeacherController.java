package by.tms.controller;

import by.tms.entity.*;
import by.tms.service.GradesService;
import by.tms.service.StudentService;
import by.tms.service.SubjectService;
import by.tms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GradesService gradesService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/login")
    public String authorisation(@ModelAttribute("teacherDto") Teacher teacher) {
        return "teacher/login";
    }

    @PostMapping("/login")
    public String authorisation(@Valid @ModelAttribute("teacherDto") Teacher teacher,
                                BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "teacher/login";
        }
        Teacher teacherDao = teacherService.findByUsername(teacher.getUsername());
        if (teacherDao.getPassword().equals(teacher.getPassword())) {
            httpSession.setAttribute("currentTeacher", teacherDao);
            return "redirect:account"; // лиcт групп преподавателя
        } else {
            return "teacher/login";
        }
    }


    @GetMapping("/account")
    public String account() {
        return "teacher/account";
    }
    @PostMapping("/account")
    public String selectGroup(final Group groupName, HttpSession httpSession, Model model) {
        Teacher currentTeacher = (Teacher) httpSession.getAttribute("currentTeacher");
        Group group = currentTeacher.getGroups().stream()
                .filter(g -> g.getName().equals(groupName))
                .findFirst()
                .orElse(null);
        if(group == null){
            throw new IllegalArgumentException("Incorrect group name " + groupName);
        }
        model.addAttribute("group", group);
        return "teacher/group"; // список студентов определенной группы
    }

    @GetMapping("/group")
    public String getStudent() {
        return "group";
    }

    @PostMapping("/group")
    public String getStudent(long studentId, long subjectId, Model model) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        Subject subject = subjectService.findById(subjectId);
        model.addAttribute("subjects", subject);
        List<Grades> gradesList = gradesService.getAll();
        model.addAttribute("grades", gradesList);
        return "teacher/student"; // студент  + выбор предмета, внести оценку
    }
    
    @PostMapping("/student")
    public String addGradesToStudent(int point, long studentId, long subjectId, Model model) {
        if(point < 0 || point > 10){
            throw new IllegalArgumentException("Incorrect point " + point);
        }
        Student student = studentService.findById(studentId);
        Subject subject = subjectService.findById(subjectId);
        if(student == null || subject == null){
            throw new IllegalArgumentException("Incorrect student or subject" );
        }
        Grades grades = new Grades(point,student,subject);
        gradesService.save(grades);
        return "teacher/student";
    }
}
