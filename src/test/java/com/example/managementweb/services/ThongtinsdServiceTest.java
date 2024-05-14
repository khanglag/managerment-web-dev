package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import com.example.managementweb.util.AppUtil;

import java.time.LocalDateTime;

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
        for (ThongtinsudungdangmuonDto temp : thongtinsdService.listDangMuon("1190308010")) {
            System.out.println(temp.toString());
        }
    }

    @Test
    public void testThongtinsdService2() {
        System.out.println(thongtinsdService.kiemtraThanhVienHopLe(1220102008));

    }

    @Test
    public void TestReservationDevice() {
        ThanhvienEntity maTV = new ThanhvienEntity();
        maTV.setId(123456789);
        ThietbiEntity maTB = new ThietbiEntity();
        maTB.setId(620235);
        LocalDateTime tgvao = null;
        LocalDateTime tgmuon = null;
        LocalDateTime tgtra = null;
        LocalDateTime tgdatcho = LocalDateTime.now();

        ThongtinsdEntity thongtinsd = new ThongtinsdEntity();
        // thongtinsd.setId(id);
        thongtinsd.setMaTV(maTV);
        thongtinsd.setMaTB(maTB);
        thongtinsd.setTgvao(tgvao);
        thongtinsd.setTgmuon(tgmuon);
        thongtinsd.setTgtra(tgtra);
        thongtinsd.setTgdatcho(tgdatcho);

        System.out.println("================================================");
        System.out.println(thongtinsdService.reservationDevice(thongtinsd));
    }
}
