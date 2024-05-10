package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.util.AppUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@SpringJUnitWebConfig
public class ThanhvienServiceTest {

    @Autowired
    private ThanhvienService thanhvienService;

    @Autowired
    private AppUtil appUtil;

    @Test
    public void testFindAll() {
        List<ThanhvienReponsDto> result = thanhvienService.findAll();
        System.out.println(appUtil.toJson(result));
    }

    @Test
    void count() {
        System.out.println(thanhvienService.count());
    }

    @Test
    public void testFindByID() {
        // Arrange
        String maTV = "1190308010"; // Giả sử mã thành viên cần tìm

        // Act
        Optional<ThanhvienReponsDto> result = thanhvienService.findByID(maTV);

        // Assert
        assertTrue(result.isPresent()); // Kiểm tra xem kết quả trả về có tồn tại không
        ThanhvienReponsDto foundThanhvien = result.get();
        System.out.println("================================================================");
        System.out.println("Thông tin thành viên:/n" + foundThanhvien);
    }

    @Test
    public void testUpdatePassword() {
        String email = "1200104043@gmail.com";
        String password = "123456";
        thanhvienService.changePassword(email, password);
    }

    @Test
    public void testEmailExists() {
        String email = "khangminh.do2003@gmail.com";

        System.out.println("================================================================");
        if (thanhvienService.checkEmailExists(email)) {
            System.out.println("Email already exists");
        } else {
            System.out.println("Email don't exist");
        }
    }

    @Test
    public void testCreateThanhVien() {
        Integer id = 123456789;
        String maTV = "123456789";
        String name = "Nguyen Van A";
        String department = "SP KHTN";
        String nganh = "Sư phạm địa lý";
        String phone = "123456789";
        String password = "123456";
        String email = "a@a";
        ThanhvienEntity thanhvienEntity = new ThanhvienEntity();
        thanhvienEntity.setId(id);
        thanhvienEntity.setHoten(name);
        thanhvienEntity.setKhoa(department);
        thanhvienEntity.setNganh(nganh);
        thanhvienEntity.setSdt(phone);
        thanhvienEntity.setPassword(password);
        thanhvienEntity.setEmail(email);
        thanhvienService.createThanhvien(thanhvienEntity);

        Optional<ThanhvienReponsDto> result = thanhvienService.findByID(maTV);

        // Assert
        assertTrue(result.isPresent()); // Kiểm tra xem kết quả trả về có tồn tại không
        ThanhvienReponsDto foundThanhvien = result.get();
        System.out.println("================================================================");
        System.out.println("Thông tin thành viên:/n" + foundThanhvien);

    }
}