package Trabalho1206;

public class Aluno {
     protected String nome; 
     protected int nota;

     public Aluno(String nome, int nota)
     {
          this.nome = nome; 
          this.nota = nota;
     }

     public Aluno() {}

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public int getNota() {
          return nota;
     }

     public void setNota(int nota) {
          this.nota = nota;
     }
}
