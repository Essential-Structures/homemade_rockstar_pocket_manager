package com.final_project.rockband_pocket_manager.data_filters;

import com.final_project.rockband_pocket_manager.models.entitties.SongEntitty;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecifications {

    public static Specification<SongEntitty> titleSearch (String titleName){
        return (root, query, criteriaBuilder)-> (titleName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(root.get("song_name")),"%"+titleName.toLowerCase()+"%" ));
    }

    public static Specification<SongEntitty> yearOfReleaseSearch (Short yearOfRelease){
        return (root, query, criteriaBuilder)->(yearOfRelease==null? null:
                criteriaBuilder.like(root.get("year_of_release"), "%"+ yearOfRelease +"%"));

    }

}
