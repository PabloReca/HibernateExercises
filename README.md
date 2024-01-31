# Guía de Ejercicios de Hibernate

Este repositorio te proporciona una base sólida para trabajar con Hibernate, especialmente útil si estás enfrentando problemas de inestabilidad en tu proyecto actual.

## Configuración del Entorno de Desarrollo

Dependiendo de tus necesidades y preferencias, tienes dos opciones para configurar el entorno de base de datos para tu proyecto Hibernate:

### Opción A: Uso de Docker para instancia de Base de Datos Dedicada

1. **Instalación de Docker**: Asegúrate de tener Docker instalado en tu sistema. Si aún no lo has hecho, puedes descargarlo desde el sitio oficial de Docker.

2. **Levantar la Base de Datos**:
    - Navega hasta el directorio `src/db` de este repositorio.
    - Ejecuta el comando `docker compose up -d` para iniciar la base de datos en modo desacoplado (detached).
    - Este paso levantará una instancia de la base de datos dedicada exclusivamente para tu proyecto.

3. **Detener el Servicio de la Base de Datos**:
    - Cuando necesites detener la base de datos, asegúrate de estar en el directorio `src/db`.
    - Ejecuta el comando `docker compose down` para detener y eliminar la instancia de la base de datos.

### Opción B: Uso de una Base de Datos Genérica

Si prefieres utilizar una base de datos existente o una configuración más general (por ejemplo, con XAMPP, MAMP, etc.), puedes seguir esa ruta. Esta opción es ideal si ya tienes un entorno de base de datos configurado y deseas integrar tu proyecto Hibernate con él.

Selecciona la opción que mejor se adapte a tus necesidades para comenzar a trabajar con Hibernate de manera eficiente y sin contratiempos.
