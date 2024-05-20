package com.librosapi.challenge.apiexterna.service;

public interface IConversor {
    public <T> T obtenerDatos(String json, Class<T> clase);
}
