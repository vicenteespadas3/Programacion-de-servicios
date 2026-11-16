# ExamenMultiHilo — práctica para el examen de PSP (Tema 2)

**Main.java NO se toca.** Llama a tus métodos y te dice `[OK]` o `[FALLO]`.
Tú solo rellenas los `// TODO` de los paquetes `ej1` ... `ej5`.

| Ej | Paquete | Qué practicas | Archivos a completar |
|----|---------|---------------|----------------------|
| 1 | `ej1` Carrera de caracoles | `Runnable`, `start()`, `sleep()`, `join()`, lista compartida | `Caracol.run()`, `Carrera.correr()` |
| 2 | `ej2` Suma paralela | `extends Thread`, repartir trabajo, recoger resultados con `join()` | `SumadorParcial.run()`, `SumaParalela.sumar()` |
| 3 | `ej3` Contador de visitas | Condición de carrera, `synchronized` (método y bloque), lambdas | `ContadorWeb.visitar()`, `SimuladorVisitas.simular()` |
| 4 | `ej4` Banco | Deadlock y cómo evitarlo ordenando cerrojos | `Banco.transferir()`, `Transferencia.run()` |
| 5 | `ej5` Panadería | Productor-consumidor con `wait()` / `notifyAll()`, señal de fin | `Estanteria.poner()/coger()`, `Panadero.run()`, `Cliente.run()` |

## Cómo ejecutar
- **Sin argumentos**: Run → sale un menú. Escribe el número (y parámetros si quieres).
- **Con argumentos** (Propiedades del proyecto → Run → Arguments, o en el menú):
  - `1 Turbo Lento Baboso` → carrera con esos caracoles
  - `2 4` → suma con 4 hilos
  - `3 8 20000` → 8 hilos × 20000 visitas
  - `4 peligroso` → **provoca el deadlock** (hazlo antes de arreglarlo, mola verlo)
  - `4` → tu versión segura
  - `5 3 10 2` → capacidad 3, 10 barras, 2 clientes

## Orden recomendado
1 → 2 → 3 → 4 → 5 (de menos a más difícil). Los ejercicios 1-3 son el nivel mínimo del examen; el 5 es el que más suele caer y más cuesta.

Cuando acabes cada uno, contesta las preguntas que hay en los comentarios (¿por qué aquí no hace falta synchronized?, ¿qué pasa con un solo FIN?...). Si sabes contestarlas, lo has entendido.
