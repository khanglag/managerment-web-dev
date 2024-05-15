package com.example.managementweb.controllers.usercontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.services.ThongtinsdService;
import com.example.managementweb.services.XuLyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeviceController {
    @Autowired
    private ThongtinsdService ttsdService;

    @RequestMapping("/borrowdevice")
    public String penalties(ModelMap models, HttpSession session) {
        String mssv = (String) session.getAttribute("mssv");
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT + 7");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        List<ThongtinsudungdangmuonDto> borrowDevice = ttsdService.listDangMuon(mssv);
        List<ThongtinsudungdangmuonDto> borrowedDevice = ttsdService.listDaMuon(mssv);
        if ((borrowDevice.size() == 0) || (borrowedDevice.size() == 0)) {
            models.addAttribute("borrowDevice", borrowDevice);
            models.addAttribute("borrowedDevice", borrowedDevice);
            return "View/borrowDevice";
        }
        LocalDateTime tgMuonCuaTBDangMuon = (LocalDateTime) borrowDevice.get(0).getTgmuon();
        LocalDateTime tgVaoCuaTBDangMuon = (LocalDateTime) borrowDevice.get(0).getTgvao();
        String fmtgMuonCuaTBDangMuon = sdfDisplay
                .format(Date.from(tgMuonCuaTBDangMuon.atZone(ZoneId.of("GMT")).toInstant()));
        String fmtgVaoCuaTBDangMuon = sdfDisplay
                .format(Date.from(tgVaoCuaTBDangMuon.atZone(ZoneId.of("GMT")).toInstant()));

        // models.addAttribute("penalties", penalties);
        // models.addAttribute("formattedTGVao", formattedTGVao);
        models.addAttribute("borrowDevice", borrowDevice);
        models.addAttribute("borrowedDevice", borrowedDevice);
        return "View/borrowDevice";
    }
}
