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
    ThanhvienEntityRepository ThanhvienEntityRepository;
    ThanhvienMapper thanhvienMapper;
    ObjectsValidator<CreateThanhvienDto> ThanhvienValidateor;
    private final ThanhvienEntityRepository thanhvienEntityRepository;

    @Override
    public List<ThanhvienReponsDto> findAll() {
        List<ThanhvienEntity> thanhvienEntityList = ThanhvienEntityRepository.findAll();
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
        Optional<ThanhvienEntity> thanhvienEntityOptional = ThanhvienEntityRepository.findByID(id);
        if (thanhvienEntityOptional.isPresent() && thanhvienEntityOptional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<ThanhvienReponsDto> findByID(String id) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = ThanhvienEntityRepository.findByID(id);
        return thanhvienEntityOptional.map(thanhvienMapper::toReponsDto);
    }

    @Override
    public boolean checkEmailExists(String email) {
        Optional<ThanhvienEntity> thanhvienEntityOptional = ThanhvienEntityRepository.findByEmail(email);
        if (thanhvienEntityOptional != null)
            return true;
        return false;
    }

    @Transactional
    public void changePassword(String email, String newPassword) {
        // thanhvienEntityRepository = memberRepository.findByEmail(email);
        // if (member != null) {
        // member.setPassword(newPassword);
        // memberRepository.save(member);
        // } else {
        // throw new IllegalArgumentException("Email không tồn tại trong hệ thống");
        // }
        Optional<ThanhvienEntity> thanhvienEntityOptional = ThanhvienEntityRepository.findByEmail(email);
        if (thanhvienEntityOptional.isPresent()) {
            ThanhvienEntity entity = thanhvienEntityOptional.get();
            entity.setPassword(newPassword);
            ThanhvienEntityRepository.save(entity);

            System.out.println("==========================\nMật khẩu đã được cập nhật thành công cho người dùng ");
        } else {
            System.out.println("Không tìm thấy người dùng có tên ");
        }
        // if (thanhvienEntity != null) {
        // ThanhvienEntityRepository.setPassword(newPassword);

        // }

    }
}
