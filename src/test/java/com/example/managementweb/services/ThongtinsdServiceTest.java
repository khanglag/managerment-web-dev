package com.example.managementweb.services;

// import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import com.example.managementweb.util.AppUtil;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    // @Test
    // public void testThongtinsdService() {
    // for (ThongtinsudungdangmuonDto temp :
    // thongtinsdService.listDangMuon("1190308010")) {
    // System.out.println(temp.toString());
    // }
    // }

    @Test
    public void testThongtinsdService2() {
        System.out.println(thongtinsdService.kiemTraMuonHopLe("420236"));
    }

    @Test
    public void testCreateThongtinsd() {
        // Arrange
        // Integer id = 1;
        ThanhvienEntity maTV = new ThanhvienEntity();
        maTV.setId(1190308010);
        ThietbiEntity maTB = new ThietbiEntity();
        maTB.setId(120191);
        LocalDateTime tgvao = LocalDateTime.now();
        LocalDateTime tgmuon = LocalDateTime.now();
        LocalDateTime tgtra = LocalDateTime.now();
        LocalDateTime tgdatcho = LocalDateTime.now();

        ThongtinsdEntity thongtinsd = new ThongtinsdEntity();
        // thongtinsd.setId(id);
        thongtinsd.setMaTV(maTV);
        thongtinsd.setMaTB(maTB);
        thongtinsd.setTgvao(tgvao);
        thongtinsd.setTgmuon(tgmuon);
        thongtinsd.setTgtra(tgtra);
        thongtinsd.setTgdatcho(tgdatcho);

        ThongtinsdEntity thongtinsdEntity = thongtinsdService.createThongtinsd(thongtinsd);
        System.out.println("================================================");
        System.out.println(thongtinsdEntity);
        // insert into thongtinsd (matb,matv,tgdatcho,tgmuon,tgtra,tgvao) values
        // (120191,1190308010,null,null,null,null)

    }
    @Test
    public void testThongtinsdService2() {
        System.out.println(thongtinsdService.kiemtraThanhVienHopLe(1220102008));

    }
}
