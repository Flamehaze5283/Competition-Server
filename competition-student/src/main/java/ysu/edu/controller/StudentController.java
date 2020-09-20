package ysu.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import ysu.edu.pojo.Email;
import ysu.edu.pojo.Student;
import ysu.edu.service.IStudentService;
import ysu.edu.util.ResponseState;
import ysu.edu.util.ServerResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author halation
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Resource
    IStudentService service;

    @GetMapping("info")
    ServerResponse info(Integer id) {
        return ServerResponse.success(service.getById(id));
    }

    @PostMapping("email-check")
    ServerResponse emailCheck(Email email, Integer stuId) {
        if(service.emailCheck(email, stuId))
            return ServerResponse.success(null,"邮件发送成功");
        else return ServerResponse.failed(ResponseState.FAILED, "邮件发送失败");
    }

}