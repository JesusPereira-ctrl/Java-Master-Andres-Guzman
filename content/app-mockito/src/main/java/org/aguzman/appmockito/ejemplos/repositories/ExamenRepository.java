package org.aguzman.appmockito.ejemplos.repositories;

import org.aguzman.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();
}
