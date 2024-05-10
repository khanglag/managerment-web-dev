package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.CreateThanhvienDto;
import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.repositories.ThanhvienEntityRepository;
import com.example.managementweb.services.interfaces.IThanhvienService;
import com.example.managementweb.services.mappers.ThanhvienMapper;
import com.example.managementweb.util.ObjectsValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThanhvienService implements IThanhvienService {
    ThanhvienEntityRepository thanhvienEntityRepository;
    ThanhvienMapper thanhvienMapper;
    ObjectsValidator<CreateThanhvienDto> thanhvienValidator;

    @Override
    public List<ThanhvienReponsDto> findAll() {
        List<ThanhvienEntity> thanhvienEntityList = thanhvienEntityRepository.findAll();
        return thanhvienEntityList.stream()
                .map(thanhvienMapper::toReponsDto)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return thanhvienEntityRepository.count();
    }


    @Override
    public boolean checkLogin(String id, String password) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = thanhvienEntityRepository.findByID(id);
        if (thanhvienEntityOptional.isPresent() && thanhvienEntityOptional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<ThanhvienReponsDto> findByID(String id) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = thanhvienEntityRepository.findByID(id);
        return thanhvienEntityOptional.map(thanhvienMapper::toReponsDto);
    }

    @Override
    public boolean checkEmailExists(String email) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = thanhvienEntityRepository.findByEmail(email);
        if (thanhvienEntityOptional.isPresent())
            return true;
        return false;
    }

    @Transactional
    public void changePassword(String email, String newPassword) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = thanhvienEntityRepository.findByEmail(email);
        if (thanhvienEntityOptional.isPresent()) {
            ThanhvienEntity entity = thanhvienEntityOptional.get();
            entity.setPassword(newPassword);
            thanhvienEntityRepository.save(entity);

            System.out.println("==========================\nMật khẩu đã được cập nhật thành công cho người dùng ");
        } else {
            System.out.println("Không tìm thấy người dùng có tên ");
        }
    }

    @Override
    public ThanhvienEntity createThanhvien(ThanhvienEntity thanhvien) {
        return thanhvienEntityRepository.save(thanhvien);
    }

}
