package org.aguzman.poointerfaces.modelo;

import java.util.Objects;

public abstract class BaseEntity {

    protected Integer id;

    private static int ultimoId;

    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
