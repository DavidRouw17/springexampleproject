package nl.david.springvoorbeeld.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        if (studentRepository.findByMail(student.getEmail()).isPresent()){
            throw new IllegalStateException("email bestaat al");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void updateStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)){
            throw new RuntimeException();
        }
        Student currStudent = studentRepository.findById(id).get();
        currStudent.setEmail(student.getEmail());
        currStudent.setName(student.getName());
    }
}
