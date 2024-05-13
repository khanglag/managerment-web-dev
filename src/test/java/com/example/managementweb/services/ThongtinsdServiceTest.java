package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;


@SpringBootTest
@SpringJUnitWebConfig
public class ThongtinsdServiceTest {
    @Autowired
    private ThongtinsdService thongtinsdService;
    @Autowired
    private AppUtil appUtil;
    @Test
    public void testThongtinsdService() {
        for(ThongtinsudungdangmuonDto temp: thongtinsdService.listDangMuon("1190308010")){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void testThongtinsdService2() {
        System.out.println(thongtinsdService.kiemTraMuonHopLe("420236"));
    }
}
