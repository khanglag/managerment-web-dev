package com.example.managementweb.controllers.usercontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import com.example.managementweb.services.ThanhvienService;
import com.example.managementweb.services.ThietBiService;
import com.example.managementweb.services.ThongtinsdService;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {
    @Autowired
    private ThanhvienService thanhvienService;

    @Autowired
    private ThietBiService thietBiService;
    @Autowired
    private ThongtinsdService thongtinsdService;

    @GetMapping("/reservation")
    public String getThietBis(Model model, HttpSession session) {
        List<ThietbiReponsDto> list = thietBiService.findAll();
        model.addAttribute("thietbisList", list);
        session.removeAttribute("message");
        session.removeAttribute("alert");
        return "View/reservation";
    }

    @GetMapping("/reservation/{id}")
    public String getThietBiDetailn(@PathVariable("id") String id, Model model) {

        Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
        model.addAttribute("thietbi", thietbi.get());
        return "View/thietbiDetail"; // Trả về view chi tiết của thiết bị
    }

    @PostMapping("/findDevice")
    public String findDevice(@RequestParam("tenTB") String tenTB, Model model) {
        List<ThietbiReponsDto> list = thietBiService.findByTenTB(tenTB);
        model.addAttribute("thietbisList", list);
        return "View/reservation";
    }

    @PostMapping("/reservationDevice")
    public String reservationDevice(HttpSession session, Model model, @RequestParam("thietbiId") String id,
            @RequestParam(value = "ngayGioDat", required = false) LocalDateTime date) {
        if (date == null) {
            String alert = "Vui lòng chọn ngày giờ đặt";
            session.setAttribute("alert", alert);
            return "redirect:/reservation/" + id;
        }
        session.removeAttribute("alert");
        String mssv = (String) session.getAttribute("mssv");
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT + 7");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        String formattedTGVao = sdfDisplay.format(Date.from(date.atZone(ZoneId.of("GMT")).toInstant()));
        ThongtinsdEntity thongtinsdEntity = new ThongtinsdEntity();
        ThietbiEntity thietbiEntity = new ThietbiEntity();
        ThanhvienEntity tv = new ThanhvienEntity();
        tv.setId(Integer.parseInt(mssv));
        int maTB = Integer.parseInt(id);
        thietbiEntity.setId(maTB);
        thongtinsdEntity.setMaTB(thietbiEntity);
        thongtinsdEntity.setTgdatcho(date);
        thongtinsdEntity.setMaTV(tv);
        String message = (String) thongtinsdService.reservationDevice(thongtinsdEntity);
        session.setAttribute("message", message);
        return "redirect:/reservation/" + id;
    }

}
