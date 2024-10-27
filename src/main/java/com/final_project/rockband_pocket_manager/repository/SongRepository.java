package com.final_project.rockband_pocket_manager.repository;

import com.final_project.rockband_pocket_manager.models.entitties.SongEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntitty, Short>,
                                        JpaSpecificationExecutor<SongEntitty> {
}
