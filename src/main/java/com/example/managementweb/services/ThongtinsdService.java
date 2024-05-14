
// package com.example.managementweb.services;

// import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
// import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
// import com.example.managementweb.models.entities.XulyEntity;
// import com.example.managementweb.repositories.ThanhvienEntityRepository;
// import com.example.managementweb.repositories.ThongtinsdEntityRepository;
// import com.example.managementweb.repositories.XulyEntityRepository;
// import com.example.managementweb.services.interfaces.IThongtinsdService;
// import com.example.managementweb.services.mappers.ThanhvienMapper;
// import com.example.managementweb.services.mappers.ThongtinsdMapper;
// import com.example.managementweb.services.mappers.XuLyMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class ThongtinsdService implements IThongtinsdService {
//     @Autowired
//     private ThongtinsdEntityRepository thongtinsdEntityRepository;
//     @Autowired
//     private ThongtinsdMapper thongtinsdMapper;
//     @Autowired
//     private ThanhvienMapper thanhvienMapper;

//     @Override
//     public List<ThongtinsudungdangmuonDto> listDangMuon(String id) {
//         return thongtinsdEntityRepository.findThongtinsudungdangmuonDtoByMaTVId(id);
//     }

//     @Override
//     public boolean kiemTraTBMuonHopLe(String maTB, LocalDateTime time) {
//         List<com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto> listdtos = thongtinsdEntityRepository.listTB(maTB)
//                 .stream().map(thongtinsdMapper::toReponsDTO).collect(Collectors.toList());
//         com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto dto = listdtos.get(listdtos.size() - 1);
//         System.out.println(dto.toString());
//         if ((dto.getTgtra() != null && dto.getTgtra().isBefore(time.minusDays(1))) &&
//                 (dto.getTgdatcho() == null))
//             return true;
//         if ((dto.getTgtra() != null && dto.getTgtra().isBefore(time.minusDays(1))) &&
//                 (dto.getTgdatcho().isBefore(LocalDateTime.now().minusDays(1))))
//             return true;
//         return false;
//     }
//     @Autowired
//     XulyEntityRepository xulyEntityRepository;
//     @Autowired
//     ThanhvienEntityRepository tvrepository;
//     @Autowired
//     private XuLyMapper xuLyMapper;

//     public static int findNumberInString(String input) {
//         // Duyệt qua từng ký tự trong chuỗi
//         for (int i = 0; i < input.length(); i++) {
//             char c = input.charAt(i);
//             // Kiểm tra xem ký tự có phải là số không
//             if (Character.isDigit(c)) {
//                 return Character.getNumericValue(c); // Trả về số nếu tìm thấy ký tự số đầu tiên trong chuỗi
//             }
//         }
//         return -1; // Trả về -1 nếu không tìm thấy ký tự số trong chuỗi
//     }
//     public static int tinhSoNgay(int soThang) {
//         return soThang * 30;
//     }
//     public static boolean kiemTraNgay(LocalDateTime ngayDaChoTruoc, long soNgay) {
//         // Lấy ngày hiện tại
//         LocalDateTime ngayHienTai = LocalDateTime.now();

//         // Cộng số ngày vào ngày đã cho trước
//         LocalDateTime ngayMoi = ngayDaChoTruoc.plusDays(soNgay);

//         // So sánh với ngày hiện tại
//         return ngayMoi.isBefore(ngayHienTai);
//     }
//     @Override
//     public boolean kiemtraThanhVienHopLe(int maTV){
//         List<XulyEntity> list =xulyEntityRepository.findByPersonAll(maTV+"");
//         List<XuLyReponsDtos> listdto= list.stream().map(xuLyMapper::toDto).collect(Collectors.toList());
//         if(listdto.size()==0) return true;
//         XuLyReponsDtos dto = listdto.get(listdto.size() - 1);
//         System.out.println(dto.toString());
//         if (dto.getHinhthucXL().equals("Khóa thẻ vĩnh viễn")) return false;
//         if(findNumberInString(dto.getHinhthucXL())== -1 && dto.getTrangthaiXL()==1) return true;
//         if(dto.getTrangthaiXL()==0) return false;
//         if(findNumberInString(dto.getHinhthucXL())!=-1)
//             if(kiemTraNgay(dto.getNgayxl(),tinhSoNgay(findNumberInString(dto.getHinhthucXL())))) return true;
//         return false;
//     }
//     @Override
//     public String kiemTraDatChoHopLe(int maTV, String maTB,LocalDateTime time){
//         if(kiemtraThanhVienHopLe(maTV)&&kiemTraTBMuonHopLe(maTB,time))return "Mượn thành công";
//         return "Mượn thất bại";
//     }
// }

// <<<<<<< HEAD
// import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto;
// import com.example.managementweb.models.entities.ThanhvienEntity;
// import com.example.managementweb.models.entities.ThietbiEntity;
// // import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
// import com.example.managementweb.models.entities.ThongtinsdEntity;
// import com.example.managementweb.repositories.ThongtinsdEntityRepository;
// import com.example.managementweb.services.interfaces.IThongtinsdService;
// import com.example.managementweb.services.mappers.ThongtinsdMapper;

// import jakarta.transaction.Transactional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class ThongtinsdService implements IThongtinsdService {
//     @Autowired
//     private ThongtinsdEntityRepository thongtinsdEntityRepository;
//     @Autowired
//     private ThongtinsdMapper thongtinsdMapper;

//     // @Override
//     // public List<ThongtinsudungdangmuonDto> listDangMuon(String id) {
//     // return thongtinsdEntityRepository.findThongtinsudungdangmuonDtoByMaTVId(id);
//     // }

//     @Override
//     public boolean kiemTraMuonHopLe(String maTB) {
//         List<com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto> listdtos = thongtinsdEntityRepository
//                 .listTB(maTB)
//                 .stream().map(thongtinsdMapper::toReponsDTO).collect(Collectors.toList());
//         com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto dto = listdtos.get(listdtos.size() - 1);
//         System.out.println(dto.toString());
//         if ((dto.getTgtra() != null && dto.getTgtra().isBefore(LocalDateTime.now().minusDays(1))) &&
//                 (dto.getTgdatcho() == null))
//             return true;
//         if ((dto.getTgtra() != null && dto.getTgtra().isBefore(LocalDateTime.now().minusDays(1))) &&
//                 (dto.getTgdatcho().isBefore(LocalDateTime.now().minusDays(1))))
//             return true;
//         return false;
//     }

//     @Transactional
//     public ThongtinsdEntity createThongtinsd(ThongtinsdEntity thongtinsdEntity) {
//         return thongtinsdEntityRepository.save(thongtinsdEntity);
//     }

//     // public ThongtinsdEntity createThongtinsd(Integer id, ThanhvienEntity maTV,
//     // ThietbiEntity maTB,
//     // LocalDateTime tgvao, LocalDateTime tgmuon, LocalDateTime tgtra,
//     // LocalDateTime tgdatcho) {
//     // ThongtinsdEntity thongtinsd = new ThongtinsdEntity();
//     // thongtinsd.setId(id);
//     // thongtinsd.setMaTV(maTV);
//     // thongtinsd.setMaTB(maTB);
//     // thongtinsd.setTgvao(tgvao);
//     // thongtinsd.setTgmuon(tgmuon);
//     // thongtinsd.setTgtra(tgtra);
//     // thongtinsd.setTgdatcho(tgdatcho);
//     // return thongtinsdRepository.save(thongtinsd);
//     // }

// }
// =======

// >>>>>>> main
package com.example.managementweb.services;

import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto;
import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import com.example.managementweb.models.entities.XulyEntity;
import com.example.managementweb.repositories.ThanhvienEntityRepository;
import com.example.managementweb.repositories.ThongtinsdEntityRepository;
import com.example.managementweb.repositories.XulyEntityRepository;
import com.example.managementweb.services.interfaces.IThongtinsdService;
import com.example.managementweb.services.mappers.ThanhvienMapper;
import com.example.managementweb.services.mappers.ThongtinsdMapper;
import com.example.managementweb.services.mappers.XuLyMapper;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThongtinsdService implements IThongtinsdService {
    @Autowired
    private ThongtinsdEntityRepository thongtinsdEntityRepository;
    @Autowired
    private ThongtinsdMapper thongtinsdMapper;
    @Autowired
    private ThanhvienMapper thanhvienMapper;

    @Override
    public List<ThongtinsudungdangmuonDto> listDangMuon(String id) {
        return thongtinsdEntityRepository.findThongtinsudungdangmuonDtoByMaTVId(id);
    }

    @Override
    public boolean kiemTraTBMuonHopLe(String maTB, LocalDateTime time) {
        List<ThongtinsdReponsDto> listdtos = thongtinsdEntityRepository.listTB(maTB)
                .stream().map(thongtinsdMapper::toReponsDTO).collect(Collectors.toList());
        ThongtinsdReponsDto dto = listdtos.get(listdtos.size() - 1);
        System.out.println(dto.toString());
        if ((dto.getTgtra() != null && dto.getTgtra().isBefore(time.minusDays(1))) &&
                (dto.getTgdatcho() == null))
            return true;
        if ((dto.getTgtra() != null && dto.getTgtra().isBefore(time.minusDays(1))) &&
                (dto.getTgdatcho().isBefore(LocalDateTime.now().minusDays(1))))
            return true;
        return false;
    }

    @Autowired
    XulyEntityRepository xulyEntityRepository;
    @Autowired
    ThanhvienEntityRepository tvrepository;
    @Autowired
    private XuLyMapper xuLyMapper;

    public static int findNumberInString(String input) {
        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Kiểm tra xem ký tự có phải là số không
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c); // Trả về số nếu tìm thấy ký tự số đầu tiên trong chuỗi
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy ký tự số trong chuỗi
    }

    public static int tinhSoNgay(int soThang) {
        return soThang * 30;
    }

    public static boolean kiemTraNgay(LocalDateTime ngayDaChoTruoc, long soNgay) {
        // Lấy ngày hiện tại
        LocalDateTime ngayHienTai = LocalDateTime.now();

        // Cộng số ngày vào ngày đã cho trước
        LocalDateTime ngayMoi = ngayDaChoTruoc.plusDays(soNgay);

        // So sánh với ngày hiện tại
        return ngayMoi.isBefore(ngayHienTai);
    }

    @Override
    public boolean kiemtraThanhVienHopLe(int maTV) {
        List<XulyEntity> list = xulyEntityRepository.findByPersonAll(maTV + "");
        List<XuLyReponsDtos> listdto = list.stream().map(xuLyMapper::toDto).collect(Collectors.toList());
        if (listdto.size() == 0)
            return true;
        XuLyReponsDtos dto = listdto.get(listdto.size() - 1);
        System.out.println(dto.toString());
        if (dto.getHinhthucXL().equals("Khóa thẻ vĩnh viễn"))
            return false;
        if (findNumberInString(dto.getHinhthucXL()) == -1 && dto.getTrangthaiXL() == 1)
            return true;
        if (dto.getTrangthaiXL() == 0)
            return false;
        if (findNumberInString(dto.getHinhthucXL()) != -1)
            if (kiemTraNgay(dto.getNgayxl(), tinhSoNgay(findNumberInString(dto.getHinhthucXL()))))
                return true;
        return false;
    }

    @Override
    public String kiemTraDatChoHopLe(int maTV, String maTB, LocalDateTime time) {
        if (kiemtraThanhVienHopLe(maTV) && kiemTraTBMuonHopLe(maTB, time))
            return "Mượn thành công";
        return "Mượn thất bại";
    }

    @Transactional
    public ThongtinsdEntity createThongtinsd(ThongtinsdEntity thongtinsdEntity) {
        return thongtinsdEntityRepository.save(thongtinsdEntity);
    }

    public String reservationDevice(ThongtinsdEntity thongtinsd) {
        if (kiemtraThanhVienHopLe(thongtinsd.getMaTV())) {
            if (kiemTraTBMuonHopLe(thongtinsd.getMaTB().toString(), thongtinsd.getTgdatcho())) {
                createThongtinsd(thongtinsd);
                return "Đặt chỗ thành công";
            }
            return "Thiết bị bận";
        }

        return "Thành viên không thể mượn thiết bị";
    }
}