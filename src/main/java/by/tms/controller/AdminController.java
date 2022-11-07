package by.tms.controller;

import by.tms.entity.*;
import by.tms.service.*;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Groupservice groupservice;


    @GetMapping("/registration")
    public String registration(@ModelAttribute("admin") Admin admin) {
        return "admin/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("admin") Admin admin, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "admin/registration";
        }
        httpSession.setAttribute("currentAdmin", admin);
        return "redirect: /admin/login";
    }

    @GetMapping("/login")
    public String authorisation(@ModelAttribute("adminDto") Admin admin) {
        return "admin/login";
    }

    @PostMapping("/login")
    public String authorisation(@Valid @ModelAttribute("adminDto") Admin admin,
                                BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/login";
        }
        Admin adminDao = adminService.findByName(admin.getName());
        if (adminDao.getPassword().equals(admin.getPassword())) {
            httpSession.setAttribute("currentAdmin", admin);
            return "admin/accaunt";
        } else {
            return "admin/registration";
        }
    }

    @GetMapping("/account")
    public String account() {
        return "admin/account";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(@ModelAttribute("newTeacher") Teacher teacher) {
        return "admin/addTeacher";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute("newTeacher") Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addTeacher";
        }
        teacherService.saveTeacher(teacher);
        return "redirect: /admin/accaunt";
    }

    @GetMapping("/selectTeacher")
    public String selectTeacher(Teacher teacher, Model model) {
        List<Teacher> teachers = teacherService.getTeacherList();
        model.addAttribute("teacher", teachers);
        return "admin/selectTeacher";
    }

    @PostMapping("/selectTeacher")
    public String selectTeacher(long teacherId, Model model) {
        Teacher selectTeacher = teacherService.findById(teacherId);
        model.addAttribute("selectTeacher", selectTeacher);
        return "redirect: /admin/updateTeacher";
    }

    @PostMapping("/updateTeacher")
    public String updateTeacher(@ModelAttribute("updateTeacher") Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addTeacher";
        }
        adminService.updateTeacher(teacher);
        return "redirect:/admin/updateTeacher";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("group", groupservice.getGroupList());
        model.addAttribute("newStudent",new Student());
        return "admin/addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student, HttpSession httpSession,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/addStudent";
        }
        Student addStudent = studentService.saveStudent(new Student());
        adminService.addStudent(addStudent);
        adminService.addStudentAtGroup((Student) addStudent.getGroup().getSubjects());
        return "admin/accaunt";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        model.addAttribute("group", groupservice.getGroupList());
        model.addAttribute("newGroup",new Group());
        return "admin/addGroup";
    }

    @PostMapping("/addGroup")
    public String addGroup(String name,long groupId, Group group, HttpSession httpSession,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/addGroup";
        }
        Group addGroup = groupservice.save(new Group());
        adminService.addGroup(new Group());
        adminService.addGroupName(name,groupId);
        return "admin/accaunt";
    }

    @GetMapping("/addSubject")
    public String addSubject(Model model) {
        model.addAttribute("subject", subjectService.getSubjectList());
        model.addAttribute("newSubject",new Subject());
        return "admin/addSubject";
    }

    @PostMapping("/addSubject")
    public String addSubject(Subject subject, HttpSession httpSession,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/addSubject";
        }
        Subject addSubject = subjectService.save(new Subject());
        adminService.addSubject(new Subject());
        return "admin/accaunt";
    }
}


