# layers-ejercicios

Ejercicio 1:
hecho en clases - pasos

1)

- crear en el modelo una clase que se llame Participantes <la fachada>
- crear método : nuevoParticipante
  crea una nueva instancia de participante
- delegar el registro de un participante en una interface RegistroParticipante
    - crear método: registrar

2)

- crear en el modelo una clase que se llame Participante

3)

- AgregarParticipante (ui) recibe por constructor una instancia de Participantes - inyección de dependencia -

4)

en el método onBotonCargar()

- las validaciones se borran y se cambian de lugar
    - mover validaciones: dentro del constructor del objeto (Ejemplo en Participante)

        - invocar al método de <la fachada> nuevoParticipante
          se pasa por parámetros los datos ingresados desde los campos de texto.

5)

crear una nueva clase Teléfono y mover el método de validación a esa clase
de éste modo se puede reducir la duplicación de código

6)

crear una clase en el paquete database que implemente RegistroParticipante
JdbcRegistroDeParticipantes
mover toda la lógica de base de datos a ésta clase

5)

Configurar el Main

Fin tp1
paso a paso parte1:
https://youtu.be/fk3E2YmDjZk

paso a paso parte2:
https://youtu.be/5GsMyj7Pkvg

Ejercicio 2:

Hecho en clases

1) Escribir la lógica de negocios
    - Crear la clase MensajeCumpleanios
    - Crear método enviarSaludo
    - Crear la interface RegistroDeEmpleados
    - Crear la clase Empleado
    - Crear método esTuCumple
2) Escribir Test

3) Implementar clases LectorCsvEmpleados y ServiceMensaje

4) Escribir Main (funciona)

5) Persistir datos

Ejercicio 3: completo - la carga no funciona

- Mover las validaciones
- *Probar los cambios
- todosLosConcursos() -> carga los concursos al combobox
- crear clase ArchivoDeInscriptos - implementa RegistroDeInscriptos
- crear la clase PersistenciaRegistroDeInscriptos - implementa RegistroDeInscriptos
  */*/hay una SQL exception, los inscriptos no se cargan */*/*