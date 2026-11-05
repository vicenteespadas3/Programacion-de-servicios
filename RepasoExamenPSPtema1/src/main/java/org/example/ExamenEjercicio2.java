package org.example;

public class ExamenEjercicio2 {
    public static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("win");

    public void main() {
        ProcessBuilder pb1, pb2;
        if(isWindows){
            pb1 = new ProcessBuilder("tasklist");
            pb2 = new ProcessBuilder("findstr", "/i", "java");
        }else {
            pb1 = new ProcessBuilder("ps", "aux");
            pb2 = new ProcessBuilder("grep", "-i","java");
        }
    }
}
