package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.models.entities.XulyEntity;
import java.util.*;
public interface IXuLyService {

        List<XuLyReponsDtos> findByPerson(String id);

} 