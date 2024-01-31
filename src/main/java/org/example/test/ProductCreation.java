package org.example.test;

import entity.ProductsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ProductCreation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los datos del producto
        System.out.println("Ingrese el nombre del producto:");
        String productName = scanner.nextLine();

        System.out.println("Ingrese el ID del proveedor (entero):");
        int supplierId = scanner.nextInt();

        System.out.println("Ingrese el ID de la categoría (entero):");
        int categoryId = scanner.nextInt();

        System.out.println("Ingrese la cantidad por unidad (texto):");
        scanner.nextLine();
        String quantityPerUnit = scanner.nextLine();

        System.out.println("Ingrese el precio por unidad (decimal):");
        double unitPrice = scanner.nextDouble();

        System.out.println("Ingrese las unidades en stock (entero corto):");
        short unitsInStock = scanner.nextShort();

        System.out.println("Ingrese las unidades en pedido (entero corto):");
        short unitsOnOrder = scanner.nextShort();

        System.out.println("Ingrese el nivel de reordenamiento (entero corto):");
        short reorderLevel = scanner.nextShort();

        System.out.println("Ingrese el estado de discontinuación (byte):");
        byte discontinued = scanner.nextByte();

        ProductsEntity product = new ProductsEntity();
        product.setProductName(productName);
        product.setSupplierId(supplierId);
        product.setCategoryId(categoryId);
        product.setQuantityPerUnit(quantityPerUnit);
        product.setUnitPrice(unitPrice);
        product.setUnitsInStock(unitsInStock);
        product.setUnitsOnOrder(unitsOnOrder);
        product.setReorderLevel(reorderLevel);
        product.setDiscontinued(discontinued);

        // Configuración de Hibernate y persistencia de datos
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(product); // Guardar el producto en la base de datos
            session.getTransaction().commit();
            System.out.println("Producto creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Error al crear el producto.");
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
