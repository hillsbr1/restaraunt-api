package jhu.rest.service;

import jhu.rest.jpa.Registrar;

public interface RegistrarService {
    Registrar findById(Long id);
}
