package com.homework.rockband_song_manager.data_filters;

import com.homework.rockband_song_manager.models.DTOs.SongDTO;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecifictions {

    public static Specification<SongDTO> titleSearch (String titleName){
        return (root, query, criteriaBuilder)-> (titleName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(root.get("song_name")),"%"+titleName.toLowerCase()+"%" ));
    }

    public static Specification<SongDTO> yearOfReleaseSearch (Short yearOfRelease){
        return (root, query, criteriaBuilder)->(yearOfRelease==null? null:
                criteriaBuilder.like(root.get("year_of_release"), "%"+ yearOfRelease +"%"));

    }

}
