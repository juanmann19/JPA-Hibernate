package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.dao.CategoriaDao;

public class RegistroDeProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Categoria celulares = new Categoria("Celulares");
		Producto celular = new Producto("Samsung","telefono usado", new BigDecimal("1000"), celulares);
		
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		
		em.getTransaction().commit();
		em.clear();
		
		
	}

}
