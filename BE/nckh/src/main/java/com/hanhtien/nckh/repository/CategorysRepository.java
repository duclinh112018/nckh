package com.hanhtien.nckh.repository;

import com.hanhtien.nckh.bean.Categorys;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Categorys entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategorysRepository extends JpaRepository<Categorys, Long> {

}
