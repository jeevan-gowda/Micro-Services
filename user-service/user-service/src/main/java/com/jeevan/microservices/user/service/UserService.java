package com.jeevan.microservices.user.service;

import com.jeevan.microservices.user.VO.Department;
import com.jeevan.microservices.user.VO.ResponseTemplateVO;
import com.jeevan.microservices.user.entity.Users;
import com.jeevan.microservices.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users users) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(users);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside saveUser method of getUserWithDepartment");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        Users users =userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ users.getDepartmentId()
                ,Department.class);
        vo.setUsers(users);
        vo.setDepartment(department);
        return vo;
    }
}
