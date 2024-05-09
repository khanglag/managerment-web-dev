// package com.example.managementweb.services;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.stream.Collectors;
// import com.example.managementweb.models.dtos.ThietBi.ThietBiDTO;
// import com.example.managementweb.models.entities.ThietbiEntity;
// import com.example.managementweb.repositories.ThietbiEntityRepository;
// import com.example.managementweb.services.interfaces.IThietBiService;
// import com.example.managementweb.services.mappers.ThietBiMapper;
// import lombok.AccessLevel;
// import lombok.RequiredArgsConstructor;
// import lombok.experimental.FieldDefaults;

// @Service
// @RequiredArgsConstructor
// @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// public class ThietBiService implements IThietBiService {

//     private final ThietbiEntityRepository repository;

//     private final ThietBiMapper mapper;

//     public List<ThietBiDTO> findByName(String TenTB) {
//         List<ThietbiEntity> entities = repository.findByName(TenTB);
//         return entities.stream().map(mapper::toDto).collect(Collectors.toList());
//     }
// }
