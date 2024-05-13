 package com.example.managementweb.services;


 import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
 import com.example.managementweb.repositories.ThongtinsdEntityRepository;
 import com.example.managementweb.services.interfaces.IThongtinsdService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import java.util.List;

 @Service
 public class ThongtinsdService implements IThongtinsdService {
 @Autowired
 private ThongtinsdEntityRepository thongtinsdEntityRepository;

 @Override
 public List<ThongtinsudungdangmuonDto> listDangMuon(String id) {
   return thongtinsdEntityRepository.findThongtinsudungdangmuonDtoByMaTVId(id);
 }
 }
