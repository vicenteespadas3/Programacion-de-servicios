# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Coursework for *Programación de Servicios y Procesos* (PSP), 2º DAM. The repo root is not a project: it holds several **independent Maven projects** (no parent POM), each opened separately in NetBeans/IntelliJ. Code, identifiers and output messages are in Spanish; keep that convention.

| Project | Topic | Main class |
|---|---|---|
| `EjerciciosDePractica` | Process API exercises (`ProcessBuilder`, redirections, `waitFor` with timeout, stdin/stdout piping) | `com.iescavanilles.EjerciciosDePractica` (set as `exec.mainClass`) |
| `Practica1PSP` | Graded practice split into "hitos" (milestones) | `com.iescavanilles.ProcessMonitorCLI` (set as `exec.mainClass`) |
| `PracticoMultiHilo` | Threads and synchronization, one package per exercise (`ejercicio1`, `ejercicio2`, ...) | several `Main` classes, no `exec.mainClass` |
| `RepasoExamenPSPtema1` | Exam review for unit 1 (processes) | `org.example.ExamenEjercicio1` / `ExamenEjercicio2` |

Package names are inconsistent between projects (`com.iescavanilles`, `com.iesCavanilles`, `org.example`). Match the package already used in the project you are editing.

## Build and run

There are no tests and no extra dependencies. Run every command from inside the project folder, not from the repo root.

```bash
mvn -q compile
mvn -q exec:java                                              # projects that set exec.mainClass
mvn -q exec:java -Dexec.mainClass=com.iesCavanilles.ejercicio1.Main   # any other entry point
```

The JDK is easy to get wrong. The POMs target Java 26/27 (`maven.compiler.release`/`source`), but the `java` on PATH is Java 8 (Oracle `java8path`). Maven comes from NetBeans and uses `JAVA_HOME=C:\Program Files\Apache NetBeans\jdk`. When running compiled classes directly, use `"$JAVA_HOME/bin/java"`, not the bare `java` command.

## Things that depend on the working directory and the OS

- `Practica1PSP` hito 2 starts a child JVM with `java -cp target/classes com.iescavanilles.LogFilterEngine` and pipes text into it. That only works if the project has been compiled and the working directory is `Practica1PSP/`. It also uses the bare `java` from PATH, so the child process is Java 8.
- Several programs read or write relative files in the project folder: `datos.txt` (input for `sort`), `ejercicio7.txt`, `reporte_sistema.log`.
- The exercises target Windows (`cmd.exe /c`, `tasklist`, `findstr`, `ping -n`). Some of them branch on `os.name` to use Linux equivalents. When adding external commands, keep or add that branching.
