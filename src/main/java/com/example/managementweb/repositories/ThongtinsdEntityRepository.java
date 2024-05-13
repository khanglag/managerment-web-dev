// package com.example.managementweb.repositories;

// import
// com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
// import com.example.managementweb.models.entities.ThongtinsdEntity;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import java.util.List;

// public interface ThongtinsdEntityRepository extends
// JpaRepository<ThongtinsdEntity, Integer> {
// @Query("SELECT NEW
// com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto("
// +
// "tt.id, tt.maTV.id, tt.maTB.id, tb.tenTB, tt.tgvao, tt.tgmuon, tt.tgtra,
// tt.tgdatcho) " +
// "FROM ThongtinsdEntity tt " +
// "LEFT JOIN FETCH tt.maTB tb " + // Sử dụng LEFT JOIN FETCH để thực hiện LEFT
// JOIN và đồng thời lấy dữ liệu
// // của ThietbiEntity
// "WHERE tt.maTV.id = :maTVId AND tt.tgmuon IS NOT NULL AND tt.tgtra IS NULL")
// List<ThongtinsudungdangmuonDto>
// findThongtinsudungdangmuonDtoByMaTVId(@Param("maTVId") String maTVId);
// }