/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iescavanilles;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vicen
 */
public class EjerciciosDePractica {

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        ejercicio9();
        //ejercicio10();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio14();
        
    }

    /**
     * Ejecuta el primer ejercicio.
     * Inicia un proceso de ping básico y espera a que este finalice su ejecución.
     */
    public static void ejercicio1() {
        ProcessBuilder pb = new ProcessBuilder("ping", "-n", "2", "127.0.0.1");
        
        try {
            Process p = pb.start();
            
            // Corrección: Utilizar waitFor() en lugar de wait()
            p.waitFor();
            
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
            Thread.currentThread().interrupt(); // Buena práctica al capturar InterruptedException
        }
    }
    
    /**
     * Ejecuta el segundo ejercicio.
     * Realiza una llamada al sistema para listar los directorios de la carpeta src
     * y muestra la salida estándar del proceso por consola.
     */
    public static void ejercicio2() {
        File carpeta = new File("./src");
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        pb.directory(carpeta);
        
        try {
            Process p = pb.start();
            
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String linea;
                
                for (String archivo : carpeta.list()) {
                    System.out.println(archivo);
                }
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            
            p.waitFor();
            
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.getLogger(EjerciciosDePractica.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Ejecuta el tercer ejercicio.
     * Lanza un script de Python en un subproceso pasándole una variable de entorno,
     * y posteriormente lee su salida estándar.
     */
    public static void ejercicio3() {
        String programa = "import os \n" + "print(\"El valor recibido en el subproceso es: \" + str(os.environ.get('MI_VARIABLE')))";
        ProcessBuilder pb = new ProcessBuilder("python", "-c", programa);
        
        Map<String, String> env = pb.environment();
        env.put("MI_VARIABLE", "PSP_2026");
        
        try {
            Process p = pb.start();
            
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                }
            }            
            p.waitFor();
            
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.getLogger(EjerciciosDePractica.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Ejecuta el cuarto ejercicio (Hito 4).
     * Simula una tarea pesada utilizando ping y controla su ejecución mediante
     * un tiempo de espera máximo. Si el proceso excede este tiempo, es destruido forzosamente.
     */
    public static void ejercicio4() {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder pb;
        
        // Configuración multiplataforma para el comando ping
        if (os.contains("win")) {
            pb = new ProcessBuilder("ping", "-n", "10", "127.0.0.1");
        } else {
            pb = new ProcessBuilder("ping", "-c", "10", "127.0.0.1");
        }
        
        try {
            Process p = pb.start();
            
            // Límite de 3 segundos
            boolean finalizado = p.waitFor(3, TimeUnit.SECONDS);
            
            if (!finalizado) {
                System.out.println("Advertencia: El proceso de diagnóstico ha superado los 3 segundos de espera.");
                p.destroyForcibly();
                System.out.println("Confirmación: El proceso ha sido cerrado limpiamente de forma forzosa.");
            } else {
                System.out.println("El proceso ha terminado correctamente antes del límite de tiempo.");
            }
            
        } catch (IOException e) {
            System.err.println("Error I/O: " + e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.getLogger(EjerciciosDePractica.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Ejecuta el quinto ejercicio.
     * Lanza un proceso que introduce una pausa de 3 segundos y monitorea
     * si el subproceso sigue vivo mediante comprobaciones periódicas.
     */
    public static void ejercicio5() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", "timeout", "/t", "3", "/nobreak");
        
        try {
            Process p = pb.start();
            
            while (p.isAlive()) {
                System.out.println(".");
                Thread.sleep(2);
            }
            
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getLocalizedMessage());
            Thread.currentThread().interrupt();
        }
    }
    
    public static void ejercicio6(){
        ProcessBuilder pb = new ProcessBuilder("ping", "/n", "10", "127.0.0.1");
        
        try {
            Process p = pb.start();
            
            if (!p.waitFor(3, TimeUnit.SECONDS)) {
                p.destroyForcibly();
                System.out.println("Proceso cancelado por exceder el tiempo máximo.");
            }
            
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getLocalizedMessage());
            Thread.currentThread().interrupt();
        }
    }
    
    
    public static void ejercicio7(){
        ProcessBuilder pb = new ProcessBuilder("ping", "-n", "2", "127.0.0.1");
        pb.redirectOutput(ProcessBuilder.Redirect.to(new File("ejercicio7.txt")));
        
        try{
            Process p = pb.start();
            
            p.waitFor();
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.getLogger(EjerciciosDePractica.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void ejercicio8() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ping -invalidParam");
        
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        
        try{
            Process p = pb.start();
            
            p.waitFor();
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static void ejercicio9() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "sort");
        pb.redirectInput(ProcessBuilder.Redirect.from(new File("datos.txt")));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        
        try{
            Process p = pb.start();
            
            p.waitFor();
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            System.getLogger(EjerciciosDePractica.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void ejercicio10() {

    }

    public static void ejercicio11() {
    }

    public static void ejercicio12() {
    }

    public static void ejercicio13() {
    }

    public static void ejercicio14() {
    }
}