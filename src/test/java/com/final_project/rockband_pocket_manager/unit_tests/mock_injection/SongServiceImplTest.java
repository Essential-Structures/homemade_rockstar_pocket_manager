package com.final_project.rockband_pocket_manager.unit_tests.mock_injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.final_project.rockband_pocket_manager.models.DTOs.SongDTO;
import com.final_project.rockband_pocket_manager.models.entitties.SongEntitty;
import com.final_project.rockband_pocket_manager.repository.SongRepository;
import com.final_project.rockband_pocket_manager.services.SongServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
    class SongServiceImplTest {

        @Mock
        private ObjectMapper objectMapper;

        @Mock
        private SongRepository songRepository;

        @InjectMocks
        private SongServiceImpl songService;

       // @AfterAll
        //public static void test() {
            //code goes here
        //}

        @Test
        void testSaveSong() {
            //given
            SongDTO songDTO = new SongDTO();
            songDTO.setTitle("Test Title");
            songDTO.setComposer("Test Composer");

            SongEntitty songEntity = new SongEntitty();
            songEntity .setID(1);
            songEntity .setName("Test Name");
            songEntity .setComposer("Test Composer");

            when(objectMapper.convertValue(songDTO, SongEntitty.class)).thenReturn(songEntity);
            when(songRepository.save(songEntity)).thenReturn(songEntity);
            when(objectMapper.convertValue(songEntity, SongDTO.class)).thenReturn(songDTO);

            //when
            SongDTO savedSongDTO = songService.saveSong(songDTO);

            //then
            verify(songRepository, times(1)).save(songEntity);
            assertEquals(songDTO.getComposer(), savedSongDTO.getComposer());
            assertEquals(songDTO.getTitle(), savedSongDTO.getTitle());
        }
    }
