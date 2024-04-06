package org.csystem.app.chatsystem.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCleaner
{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void clear()
    {
        entityManager.createNativeQuery("DELETE FROM login_info").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM user_info").executeUpdate();
    }
}