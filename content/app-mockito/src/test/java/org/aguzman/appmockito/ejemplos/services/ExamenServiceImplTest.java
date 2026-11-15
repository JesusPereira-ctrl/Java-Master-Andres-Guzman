package org.aguzman.appmockito.ejemplos.services;

import org.aguzman.appmockito.ejemplos.models.Examen;
import org.aguzman.appmockito.ejemplos.repositories.ExamenRepository;
import org.aguzman.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepository examenRepository;

    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.openMocks(this);
        // examenRepository = mock(ExamenRepository.class);
        // preguntaRepository = mock(PreguntaRepository.class);
        // service = new ExamenServiceImpl(this.examenRepository, this.preguntaRepository);
    }

    @Test
    void findExamenPorNombre() {
        when(this.examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = this.service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matemáticas", examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListEmpty() {
        List<Examen> datos = Collections.emptyList();

        when(this.examenRepository.findAll()).thenReturn(datos);
        Optional<Examen> examen = this.service.findExamenPorNombre("Matemáticas");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntaExamen() {
        when(this.examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(this.preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = this.service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Integrales"));
    }

    @Test
    void testPreguntaExamenVerify() {
        when(this.examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(this.preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = this.service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Integrales"));
        verify(this.examenRepository).findAll();
        verify(this.preguntaRepository).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void testNoExisteExamenVerify() {
        when(this.examenRepository.findAll()).thenReturn(Collections.emptyList());
        when(this.preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = this.service.findExamenPorNombreConPreguntas("Matemáticas2");
        assertNull(examen);
        verify(this.examenRepository).findAll();
        verify(this.preguntaRepository).findPreguntasPorExamenId(5L);
    }
}