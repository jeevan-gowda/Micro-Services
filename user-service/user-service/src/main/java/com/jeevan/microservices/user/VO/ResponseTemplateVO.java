package com.jeevan.microservices.user.VO;

import com.jeevan.microservices.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Users users;
    private Department department;
}
