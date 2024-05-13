package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

@SpringBootTest
@SpringJUnitWebConfig
public class ThietBiServiceTest {

    @Autowired
    private ThietBiService service;

    @Autowired
    private AppUtil appUtil;

    @Test
    void findAll() {
        List<ThietbiReponsDto> result = service.findAll();
        System.out.println("================================================");
        System.out.println(appUtil.toJson(result));

    }

    @Test
    public void testFindByName() {
        List<ThietbiReponsDto> list = service.findByTenTB("Micro");
        System.out.println(appUtil.toJson(list));
    }

}
