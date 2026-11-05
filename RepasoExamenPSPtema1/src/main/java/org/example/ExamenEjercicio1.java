package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ExamenEjercicio1 {
    public static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("win");

    static void main() {
        ProcessBuilder pb = isWindows ? new ProcessBuilder("cmd.exe", "/c", "dir") : new ProcessBuilder("ls", "-la");
        pb.directory(new File("src"));

        try{
            Process p = pb.start();
            System.out.println("Proceso lanzado. PID: " + p.pid());
            while(p.isAlive()){
                System.out.println(".");
                Thread.sleep(200);
            }
            System.out.println();
            System.out.println("Proceso terminado");

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int numLineas = 0;
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
                numLineas++;
            }
            br.close();
            System.out.println("Numero de linhas terminadas: " + numLineas);

            int exitCode = p.waitFor();
            System.out.println("Codigo de salida: " + exitCode);

        } catch (IOException | InterruptedException e){
            System.out.println("Error al abrir la input file" + e.getMessage());
        }


    }




}
