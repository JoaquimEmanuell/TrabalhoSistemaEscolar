package Trabalho1206;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
     public static void main(String args[]) {
          int q = 1;
          Scanner teclado = new Scanner(System.in);
          while (q == 1) {
               System.out.println("|-----------------------|");
               System.out.println("|    \u001B[33mTrabalho de POO\u001B[0m    |");
               System.out.println("|   \u001B[33mSistema academico\u001B[0m   |");
               System.out.println("|-----------------------|");
               System.out.println("|  1. Disciplinas       |");
               System.out.println("|  2. Gerar resultado   |");
               System.out.println("|  3. Sair              |");
               System.out.println("|-----------------------|");
               System.out.println("|  \u001B[33mjoaquim, jv e pedro\u001B[0m  |");
               System.out.println("|-----------------------|");
               int opc = teclado.nextInt();
               if (opc == 1) {
                    criarDisciplina();
               }
               if (opc == 2) {
                    gerarResultado();    
               }
               if (opc == 3) {
                    q = 0;
                    break;
               }
          }
     }

     public static void criarDisciplina() {
          Scanner teclado = new Scanner(System.in);
          System.out.println("|-----------------------|");
          System.out.println("|      \u001B[33mDisciplinas\u001B[0m      |");
          System.out.println("|-----------------------|");
          System.out.println("|  1. Add. discilpina   |");
          System.out.println("|  2. Adicionar aluno   |");
          System.out.println("|  3. Excluir discip.   |");
          System.out.println("|-----------------------|");
          int opc = teclado.nextInt();
          if (opc == 1) {
               adiconarDisciplina();
          }
          if (opc == 2) {
               adicionarAluno();
          }
          if (opc == 3) {
               removerDisciplina();
          }
     }

     public static void adiconarDisciplina() {
          Scanner teclado = new Scanner(System.in);
          System.out.print("Digite o nome da disciplina: ");
          String nome = teclado.next();
          try { // Ficar atento nos diretórios dos arquivos
               FileWriter file = new FileWriter("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas/" + nome + ".txt");
               System.out.println("Disciplina adicionada com sucesso!");
          } catch (IOException e) {
               // TODO Auto-generated catch block
               System.out.println("Ocorreu um erro ao adicionar a disciplina");
          }
     }

     public static void adicionarAluno() {
          Scanner teclado = new Scanner(System.in);
          System.out.println("|-----------------------|");
          File file = new File("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas");
          String[] lista = file.list();
          if (lista.length > 0) {
               for (String nome : lista) {
                    System.out.println("| " + nome);
               }
          } else {
               System.out.println("Não existe nenhuma disciplina");
               return;
          }
          System.out.println("|-----------------------|");
          System.out.print("Digite o nome da disciplina que deseja selecionar: ");
          String nome = teclado.next();
          for (String disciplina : lista) {
               String nomeCerto = nome + ".txt";
               if (disciplina.equalsIgnoreCase(nomeCerto)) {
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = teclado.next();
                    System.out.println("Digite as respostas: ");
                    String respostas = teclado.next();
                    try {
                         FileWriter arquivo = new FileWriter("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas/" + disciplina, true);
                         BufferedWriter bw = new BufferedWriter(arquivo);
                         bw.write(respostas + "\t" + nomeAluno);
                         bw.newLine();
                         bw.close();
                         arquivo.close();
                    } catch (IOException e) {
                         // TODO Auto-generated catch block
                         System.out.println("Erro ao abrir arquivo");
                    }
               }
          }
     }

     public static void removerDisciplina() {
          Scanner teclado = new Scanner(System.in);
          System.out.println("|-----------------------|");
          File file = new File("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas");
          String[] lista = file.list();
          if (lista.length > 0) {
               for (String nome : lista) {
                    System.out.println("| " + nome);
               }
          } else {
               System.out.println("Não existe nenhuma disciplina");
               return;
          }
          System.out.println("|-----------------------|");
          System.out.print("Digite o nome da disciplina que deseja selecionar para remover: ");
          String nome = teclado.next();
          for (String disciplina : lista) {
               String nomeCerto = nome + ".txt";
               if (disciplina.equalsIgnoreCase(nomeCerto)) {
                    File arquivo = new File("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas/" + disciplina);
                    boolean resultado = arquivo.delete();
                    if (resultado == true) {
                         System.out.println("Arquivo excluído com sucesso!");
                    } else {
                         System.out.println("Erro ao excluír arquivo");
                    }
               }
          }
     }

     public static void gerarResultado() {
          ArrayList<Aluno> alunos = new ArrayList<Aluno>();
          Scanner teclado = new Scanner(System.in);
          System.out.println("|-----------------------|");
          System.out.println("|       \u001B[33mResultados\u001B[0m      |");
          System.out.println("|-----------------------|");
          File file = new File("/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas");
          String[] lista = file.list();
          if (lista.length > 0) {
               for (String nome : lista) {
                    System.out.println("| " + nome);
               }
          } else {
               System.out.println("Não existe nenhuma disciplina");
               return;
          }

          System.out.println("|-----------------------|");
          System.out.print("Digite o nome da disciplina que deseja selecionar (sem .txt): ");
          String nome = teclado.next();
          try {
               FileReader respostas = new FileReader(
                         "/home/joaqm_/Documentos/TrabalhoPOO/Disciplinas/" + nome + ".txt");
               BufferedReader bResp = new BufferedReader(respostas);
               String linhaR = bResp.readLine();
               if (linhaR == null) {
                    System.out.println("O arquivo de disciplina está vazio");
                    return;
               }
               System.out.print("Digite o diretório do arquivo do gabarito (Ex:/home/user/arquivo.txt): ");
               String diretorio = teclado.next();
               FileReader gabarito = new FileReader(diretorio);
               BufferedReader bGabr = new BufferedReader(gabarito);
               String linhaG = bGabr.readLine();
               String[] dado = linhaG.split("\t");
               while (linhaR != null) {
                    String[] dados = linhaR.split("\t");
                    int nota = 0;
                    if (dados[0].equalsIgnoreCase("VVVVVVVVVV") || dados[0].equalsIgnoreCase("FFFFFFFFFF")) {
                         nota = 0;
                    } else {
                         for (int i = 0; i < 10; i++) {
                              char charR = dados[0].charAt(i);
                              char charG = dado[0].charAt(i);
                              if (charR == charG) {
                                   nota = nota + 1;
                              }
                         }
                    }
                    Aluno aluno = new Aluno(dados[1], nota);
                    alunos.add(aluno);
                    linhaR = bResp.readLine();
               }
               double media = 0;
               double soma = 0;
               int quantidade = 0;
               for (Aluno aluno : alunos) {
                    soma = aluno.getNota() + soma;
                    quantidade++;
               }
               media = soma / quantidade;
               gerarLista1(alunos, nome, media);
               gerarLista2(alunos, nome, media);
          } catch (FileNotFoundException e) {
               System.out.println("arquivo nao encontrado");
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public static void gerarLista1(ArrayList<Aluno> alunos, String disciplina, double media) {

          for (int i = 0; i < alunos.size(); i++) {
               for (int j = 0; j < alunos.size(); j++) {
                    Aluno a1 = alunos.get(i);
                    Aluno a2 = alunos.get(j);
                    if (a1.getNota() > a2.getNota()) {
                         Aluno aux = a1;
                         alunos.set(i, a2);
                         alunos.set(j, aux);
                    }
               }
          }

          try {
               FileWriter file = new FileWriter(
                         "/home/joaqm_/Documentos/TrabalhoPOO/Resultados/" + disciplina + "-PorNota" + ".txt");
               BufferedWriter bw = new BufferedWriter(file);
               for (Aluno aluno : alunos) {
                    bw.write(aluno.getNome() + "\t" + aluno.getNota());
                    bw.newLine();
               }
               bw.write("Media da turma: " + media);
               bw.close();
               file.close();
               System.out.println("Lista em ordem de nota criada com sucesso!");
          } catch (IOException e) {
               // TODO Auto-generated catch block
               System.out.println("Ocorreu um erro ao criar o arquivo");
               e.printStackTrace();
          }
     }

     public static void gerarLista2(ArrayList<Aluno> alunos, String disciplina, double media) {
          Collections.sort(alunos, new Comparator<Aluno>() {
               @Override
               public int compare(Aluno o1, Aluno o2) {
                    return o1.getNome().compareToIgnoreCase(o2.getNome());
               }
          });

          try {
               FileWriter file = new FileWriter(
                         "/home/joaqm_/Documentos/TrabalhoPOO/Resultados/" + disciplina + "-PorNome" + ".txt");
               BufferedWriter bw = new BufferedWriter(file);
               for (Aluno aluno : alunos) {
                    bw.write(aluno.getNome() + "\t" + aluno.getNota());
                    bw.newLine();
               }
               bw.write("Media da turma: " + media);
               bw.close();
               file.close();
               System.out.println("Lista em ordem alfabética criada com sucesso!");
          } catch (IOException e) {
               // TODO Auto-generated catch block
               System.out.println("\u001BO[41mOcorreu um erro ao criar o arquivo\u001B[0m");
               e.printStackTrace();
          }
     }
}
