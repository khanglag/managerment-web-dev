package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.repositories.ThietbiEntityRepository;
import com.example.managementweb.services.mappers.ThietBiMapper;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void testFindByID() {

        String id = "120191";
        Optional<ThietbiReponsDto> result = service.findByID(id);
        System.out.println("================================================");
        System.out.println(result.get());
    }

}
