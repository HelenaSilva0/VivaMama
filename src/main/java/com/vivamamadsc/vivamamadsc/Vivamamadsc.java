/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vivamamadsc.vivamamadsc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Vivamamadsc {

    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        preencherPaciente(paciente);
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            
            emf = Persistence.createEntityManagerFactory("vivamamadsc");
            em = emf.createEntityManager(); 
            et = em.getTransaction(); 
            et.begin();
            em.persist(paciente);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
    }
}

   /* private static void preencherUsuario(Usuario usuario) {
        usuario.setNome("Fulano da Silva");
        usuario.setEmail("fulano@gmail.com");
        usuario.setSenha("teste"); 
        usuario.setDataNascimento(new Date());
       
    }*/
    
        private static void preencherPaciente(Paciente p) {
        p.setNome("Fulano da Silva");
        p.setEmail("fulano@gmail.com");
        p.setSenha("teste");
        p.setTipo(TipoUsuario.PACIENTE);
        p.setDataNascimento(new GregorianCalendar(2004, Calendar.APRIL, 23).getTime());
    }
}
