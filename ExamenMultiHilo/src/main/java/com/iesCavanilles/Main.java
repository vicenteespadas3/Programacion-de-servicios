package com.iesCavanilles;

import com.iesCavanilles.ej1.Carrera;
import com.iesCavanilles.ej2.SumaParalela;
import com.iesCavanilles.ej3.ContadorWeb;
import com.iesCavanilles.ej3.SimuladorVisitas;
import com.iesCavanilles.ej4.Banco;
import com.iesCavanilles.ej4.Cuenta;
import com.iesCavanilles.ej4.Transferencia;
import com.iesCavanilles.ej5.Cliente;
import com.iesCavanilles.ej5.Estanteria;
import com.iesCavanilles.ej5.Panadero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * ============================================================
 *  MAIN DE PRUEBAS — NO HACE FALTA QUE LO TOQUES
 * ============================================================
 *  Este main llama a tus métodos y COMPRUEBA si funcionan.
 *  Tú solo tienes que rellenar los TODO de cada paquete ej1..ej5.
 *
 *  Cómo ejecutarlo:
 *   - Sin argumentos: sale un menú para elegir ejercicio.
 *   - Con argumentos (Propiedades del proyecto > Run > Arguments):
 *        1                      -> ejercicio 1 con valores por defecto
 *        1 Turbo Lento Baboso   -> ejercicio 1 con esos caracoles
 *        2 4                    -> ejercicio 2 con 4 hilos
 *        3 8 20000              -> ejercicio 3 con 8 hilos y 20000 visitas cada uno
 *        4 peligroso            -> ejercicio 4 provocando el DEADLOCK
 *        4                      -> ejercicio 4 con tu versión segura
 *        5 3 10 2               -> ejercicio 5: capacidad 3, 10 barras, 2 clientes
 * ============================================================
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            menu();
        } else {
            ejecutar(args);
        }
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== EXAMEN MULTIHILO =====");
            System.out.println("1. Carrera de caracoles   (Thread/Runnable, sleep, join)");
            System.out.println("2. Suma paralela          (repartir trabajo, join, recoger resultados)");
            System.out.println("3. Contador de visitas    (condición de carrera, synchronized)");
            System.out.println("4. Banco                  (deadlock y cómo evitarlo)");
            System.out.println("5. Panadería              (productor-consumidor, wait/notifyAll)");
            System.out.println("0. Salir");
            System.out.print("Elige (puedes añadir parámetros, ej: '3 8 20000' o '4 peligroso'): ");
            String linea = sc.nextLine().trim();
            if (linea.equals("0") || linea.isEmpty()) {
                return;
            }
            ejecutar(linea.split("\\s+"));
        }
    }

    private static void ejecutar(String[] args) {
        try {
            switch (args[0]) {
                case "1" -> probarEj1(args);
                case "2" -> probarEj2(args);
                case "3" -> probarEj3(args);
                case "4" -> probarEj4(args);
                case "5" -> probarEj5(args);
                default -> System.out.println("Ejercicio no válido: " + args[0]);
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Ha saltado una excepción: " + e);
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------
    // EJERCICIO 1
    // ------------------------------------------------------------------
    private static void probarEj1(String[] args) {
        String[] nombres = args.length > 1
                ? java.util.Arrays.copyOfRange(args, 1, args.length)
                : new String[]{"Turbo", "Lento", "Baboso", "Rayo"};
        int metros = 10;

        System.out.println("\n--- EJ1: Carrera de " + nombres.length + " caracoles, " + metros + " metros ---");
        long inicio = System.currentTimeMillis();
        List<String> podio = Carrera.correr(nombres, metros);
        long ms = System.currentTimeMillis() - inicio;
        System.out.println("¡Carrera terminada! (" + ms + " ms)");
        System.out.println("Orden de llegada: " + podio);

        comprobar(podio != null && podio.size() == nombres.length,
                "Han llegado todos los caracoles (" + nombres.length + ")");
        comprobar(podio != null && new HashSet<>(podio).containsAll(List.of(nombres)),
                "Están todos y ninguno repetido");
        // Si fueran en secuencia tardaría ~ nombres * metros * 250ms. En paralelo, ~ metros * 400ms como mucho.
        comprobar(ms >= 1000 && ms < metros * 400L + 1500,
                "Han corrido EN PARALELO (si tarda muchísimo, ¿has usado run() en vez de start()?)");
    }

    // ------------------------------------------------------------------
    // EJERCICIO 2
    // ------------------------------------------------------------------
    private static void probarEj2(String[] args) {
        int[] datos = new int[1_000_000];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = i + 1;
        }
        long esperado = (long) datos.length * (datos.length + 1) / 2;

        int[] pruebas = args.length > 1 ? new int[]{Integer.parseInt(args[1])} : new int[]{1, 2, 4, 7};
        System.out.println("\n--- EJ2: Suma paralela de 1..1.000.000 (esperado " + esperado + ") ---");
        for (int hilos : pruebas) {
            long res = SumaParalela.sumar(datos, hilos);
            comprobar(res == esperado, hilos + " hilo(s) -> " + res);
        }
    }

    // ------------------------------------------------------------------
    // EJERCICIO 3
    // ------------------------------------------------------------------
    private static void probarEj3(String[] args) {
        int hilos = args.length > 1 ? Integer.parseInt(args[1]) : 5;
        int visitas = args.length > 2 ? Integer.parseInt(args[2]) : 10_000;
        int esperado = hilos * visitas;

        System.out.println("\n--- EJ3: " + hilos + " hilos x " + visitas + " visitas (esperado " + esperado + ") ---");
        System.out.println("Versión INSEGURA (debería fallar casi siempre):");
        for (int i = 1; i <= 3; i++) {
            int r = SimuladorVisitas.simular(new ContadorWeb(), hilos, visitas, false);
            System.out.println("   intento " + i + ": " + r + (r == esperado ? "  (hoy has tenido suerte)" : "  <- se han perdido " + (esperado - r)));
        }
        System.out.println("Versión SEGURA (tiene que salir exacto siempre):");
        boolean ok = true;
        for (int i = 1; i <= 3; i++) {
            int r = SimuladorVisitas.simular(new ContadorWeb(), hilos, visitas, true);
            System.out.println("   intento " + i + ": " + r);
            ok &= (r == esperado);
        }
        comprobar(ok, "La versión segura da siempre " + esperado);
    }

    // ------------------------------------------------------------------
    // EJERCICIO 4
    // ------------------------------------------------------------------
    private static void probarEj4(String[] args) throws InterruptedException {
        boolean peligroso = args.length > 1 && args[1].equalsIgnoreCase("peligroso");
        Cuenta a = new Cuenta(1, "Ana", 10_000);
        Cuenta b = new Cuenta(2, "Luis", 10_000);
        double totalInicial = a.getSaldo() + b.getSaldo();
        int veces = 1000;

        System.out.println("\n--- EJ4: Banco " + (peligroso ? "(MODO PELIGROSO: debería bloquearse)" : "(tu versión segura)") + " ---");
        Thread t1 = new Thread(new Transferencia(a, b, 5, veces, !peligroso), "Ana->Luis");
        Thread t2 = new Thread(new Transferencia(b, a, 7, veces, !peligroso), "Luis->Ana");
        t1.setDaemon(true); // para que el programa pueda acabar aunque se queden bloqueados
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join(5000);
        t2.join(5000);

        if (t1.isAlive() || t2.isAlive()) {
            System.out.println("[!!!] DEADLOCK detectado tras 5 s:");
            System.out.println("   " + t1.getName() + " -> " + t1.getState());
            System.out.println("   " + t2.getName() + " -> " + t2.getState());
            if (peligroso) {
                System.out.println("   Esto es justo lo que tenía que pasar: los dos BLOCKED esperando al otro.");
                System.out.println("   Ahora arregla Banco.transferir() y ejecuta el ejercicio 4 sin 'peligroso'.");
            } else {
                comprobar(false, "En la versión segura NO debería haber deadlock (revisa el orden de los cerrojos)");
            }
            return;
        }
        double totalFinal = a.getSaldo() + b.getSaldo();
        System.out.println("Saldo Ana: " + a.getSaldo() + " | Saldo Luis: " + b.getSaldo());
        if (peligroso) {
            System.out.println("(Esta vez no se ha bloqueado, pero puede pasar. Vuelve a probar.)");
        } else {
            comprobar(totalFinal == totalInicial, "No se ha creado ni perdido dinero (total " + totalFinal + ")");
            comprobar(a.getSaldo() == 10_000 - 5 * veces + 7 * veces, "El saldo de Ana es el esperado (" + (10_000 - 5 * veces + 7 * veces) + ")");
            Cuenta pobre = new Cuenta(3, "Pobre", 10);
            comprobar(!Banco.transferir(pobre, a, 50) && pobre.getSaldo() == 10,
                    "No deja transferir más dinero del que hay");
        }
    }

    // ------------------------------------------------------------------
    // EJERCICIO 5
    // ------------------------------------------------------------------
    private static void probarEj5(String[] args) throws InterruptedException {
        int capacidad = args.length > 1 ? Integer.parseInt(args[1]) : 3;
        int barras = args.length > 2 ? Integer.parseInt(args[2]) : 10;
        int numClientes = args.length > 3 ? Integer.parseInt(args[3]) : 2;

        System.out.println("\n--- EJ5: Panadería (capacidad " + capacidad + ", " + barras + " barras, " + numClientes + " clientes) ---");
        Estanteria estanteria = new Estanteria(capacidad);
        Thread panadero = new Thread(new Panadero(estanteria, barras, numClientes), "Panadero");
        panadero.setDaemon(true);

        List<Cliente> clientes = new ArrayList<>();
        List<Thread> hilos = new ArrayList<>();
        for (int i = 1; i <= numClientes; i++) {
            Cliente c = new Cliente("Cliente" + i, estanteria);
            clientes.add(c);
            Thread t = new Thread(c, c.getNombre());
            t.setDaemon(true);
            hilos.add(t);
        }

        panadero.start();
        for (Thread t : hilos) t.start();

        panadero.join(barras * 600L + 3000);
        for (Thread t : hilos) t.join(barras * 600L + 3000);

        boolean colgado = panadero.isAlive();
        for (Thread t : hilos) colgado |= t.isAlive();
        if (colgado) {
            System.out.println("[!!!] Algún hilo se ha quedado esperando para siempre:");
            System.out.println("   Panadero -> " + panadero.getState());
            for (Thread t : hilos) System.out.println("   " + t.getName() + " -> " + t.getState());
        }

        List<Integer> todas = new ArrayList<>();
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " compró: " + c.getCompradas());
            todas.addAll(c.getCompradas());
        }
        Set<Integer> sinRepetir = new HashSet<>(todas);
        comprobar(!colgado, "Todos los hilos han terminado (nadie se queda esperando)");
        comprobar(sinRepetir.size() == todas.size(), "Ninguna barra se ha vendido dos veces");
        comprobar(todas.size() == barras, "Se han vendido las " + barras + " barras (vendidas: " + todas.size() + ")");
        comprobar(!todas.contains(-1), "La señal de fin (-1) no se cuenta como barra");
        comprobar(estanteria.getMaximaOcupacion() <= capacidad,
                "La estantería nunca ha superado su capacidad (máximo: " + estanteria.getMaximaOcupacion() + ")");
    }

    // ------------------------------------------------------------------
    private static void comprobar(boolean condicion, String mensaje) {
        System.out.println((condicion ? "   [OK]    " : "   [FALLO] ") + mensaje);
    }
}
