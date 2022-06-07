package com.sms.security.service;

import com.sms.security.model.forUsers.IpAll;
import com.sms.security.repository.IpAllRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class IpAllService {

    @Autowired
    IpAllRepository ipAllRepository;





    //сохранение объекта с Ip-адрессом и ссылкой
    public void save(IpAll ipAll){
        ipAllRepository.save(ipAll);
    }

}
