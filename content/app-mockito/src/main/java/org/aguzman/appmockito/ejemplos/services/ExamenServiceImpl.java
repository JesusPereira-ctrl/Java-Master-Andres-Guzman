package org.aguzman.appmockito.ejemplos.services;

import org.aguzman.appmockito.ejemplos.models.Examen;
import org.aguzman.appmockito.ejemplos.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return this.examenRepository.findAll()
                .stream()
                .filter(e -> e.getNombre().contains(nombre))
                .findFirst();
    }
}
