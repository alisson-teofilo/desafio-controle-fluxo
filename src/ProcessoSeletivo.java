import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = new String[]{"ALISSON", "ALESSANDRA", "ATANAEL", "VILMA", "WESLEY"};
        String[] var2 = candidatos;
        int var3 = candidatos.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String candidato = var2[var4];
            entrandoEmContado(candidato);
        }

    }

    static void entrandoEmContado(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando) {
                ++tentativasRealizadas;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while(continuaTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas);
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", numero máximo tentativa  " + tentativasRealizadas + " realizada");
        }

    }

    static boolean atender() {
        return (new Random()).nextInt(3) == 1;
    }

    static void imprimeSelecionados() {
        String[] candidatos = new String[]{"ALISSON", "ALESSANDRA", "ATANAEL", "VILMA", "WESLEY"};
        System.out.println("Imprime lista candidatos");

        for(int indice = 0; indice < candidatos.length; ++indice) {
            System.out.println("Candidato " + (indice + 1) + "é : " + candidatos[indice]);
        }

        String[] var5 = candidatos;
        int var2 = candidatos.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String indice = var5[var3];
            System.out.println(indice);
        }

    }

    static void selecaoCandidatos() {
        String[] candidatos = new String[]{"ALISSON", "ALESSANDRA", "ATANAEL", "VILMA", "WESLEY"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;

        for(double salarioBase = 2000.0; candidatosSelecionados < 5 && candidatosAtual < candidatos.length; ++candidatosAtual) {
            String candidato = candidatos[candidatosAtual];
            double salarioPetendido = valorPretendido();
            System.out.println("O candidato " + candidato + " Solicitou R$:" + salarioPetendido);
            if (salarioBase >= salarioPetendido) {
                System.out.println("O candidato " + candidato + " foi selecionado");
                ++candidatosSelecionados;
            }
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }

    }
}
