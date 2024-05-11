package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

@SpringBootTest
@SpringJUnitWebConfig
public class XuLyServiceTest {

    @Autowired
    private XuLyService service;

    @Autowired
    private AppUtil appUtil;

    @Test
    public void findByPerson() {
        String id = "1190412013";
        List<XuLyReponsDtos> result = service.findByPerson(id);
        System.out.println(result);

    }
    
    
}
