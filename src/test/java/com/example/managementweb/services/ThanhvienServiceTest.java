package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.CreateThanhvienDto;
import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import java.util.List;
@SpringBootTest
@SpringJUnitWebConfig
public class ThanhvienServiceTest {

    @Autowired
    private ThanhvienService thanhvienService;

    @Autowired
    private AppUtil appUtil;

    @Test
    public void testFindAll() {
        List<ThanhvienReponsDto> result =thanhvienService.findAll();
        System.out.println(appUtil.toJson(result));
    }
    @Test void count(){
        System.out.println(thanhvienService.count());
    }
}
